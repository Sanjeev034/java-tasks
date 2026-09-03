import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Stores check-in information: id -> {stationName, time}
    private Map<Integer, Pair<String, Integer>> checkIns;
    // Stores travel statistics: startStation -> {endStation -> {totalTime, tripCount}}
    private Map<String, Map<String, Pair<Long, Integer>>> travelStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInInfo = checkIns.get(id);
        String startStation = checkInInfo.getKey();
        int startTime = checkInInfo.getValue();
        long travelTime = t - startTime;

        // Update travel stats for the route
        travelStats.computeIfAbsent(startStation, k -> new HashMap<>());
        Map<String, Pair<Long, Integer>> endStations = travelStats.get(startStation);
        
        endStations.computeIfAbsent(stationName, k -> new Pair<>(0L, 0));
        Pair<Long, Integer> currentStats = endStations.get(stationName);
        
        currentStats.setKey(currentStats.getKey() + travelTime); // Add to total time
        currentStats.setValue(currentStats.getValue() + 1);      // Increment trip count

        // Remove check-in info as the customer has checked out
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        Map<String, Pair<Long, Integer>> endStations = travelStats.get(startStation);
        Pair<Long, Integer> stats = endStations.get(endStation);
        
        // It's guaranteed that at least one customer has traveled this route before getAverageTime is called.
        return (double) stats.getKey() / stats.getValue();
    }

    // Simple Pair class to hold two values
    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
