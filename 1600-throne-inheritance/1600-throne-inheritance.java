import java.util.*;

class ThroneInheritance {

    private String king;
    private Map<String, List<String>> children;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();

        children.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        children.get(parentName).add(childName);
        children.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(king, result);
        return result;
    }

    private void dfs(String person, List<String> result) {

        if (!dead.contains(person)) {
            result.add(person);
        }

        for (String child : children.get(person)) {
            dfs(child, result);
        }
    }
}