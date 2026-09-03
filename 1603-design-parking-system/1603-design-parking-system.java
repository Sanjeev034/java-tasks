class ParkingSystem {
    private int bigSlots;
    private int mediumSlots;
    private int smallSlots;

    /**
     * Initializes object of the ParkingSystem class.
     * The number of slots for each parking space are given as part of the constructor.
     * @param big The number of big parking slots.
     * @param medium The number of medium parking slots.
     * @param small The number of small parking slots.
     */
    public ParkingSystem(int big, int medium, int small) {
        this.bigSlots = big;
        this.mediumSlots = medium;
        this.smallSlots = small;
    }

    /**
     * Checks whether there is a parking space of carType for the car that wants to get into the parking lot.
     * carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively.
     * A car can only park in a parking space of its carType.
     * If there is no space available, return false, else park the car in that size space and return true.
     * @param carType The type of car (1 for big, 2 for medium, 3 for small).
     * @return true if a parking space is available, false otherwise.
     */
    public boolean addCar(int carType) {
        if (carType == 1) {
            if (bigSlots > 0) {
                bigSlots--;
                return true;
            }
        } else if (carType == 2) {
            if (mediumSlots > 0) {
                mediumSlots--;
                return true;
            }
        } else if (carType == 3) {
            if (smallSlots > 0) {
                smallSlots--;
                return true;
            }
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big,medium,small);
 * boolean param_1 = obj.addCar(carType);
 */
