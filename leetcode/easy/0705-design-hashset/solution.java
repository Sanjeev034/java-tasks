class Node {
    int key;
    Node next;

    Node(int key) {
        this.key = key;
        this.next = null;
    }
}

class MyHashSet {
    private static final int SIZE = 769; // A prime number for the bucket array size
    private Node[] buckets;

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    // Hash function to determine the bucket index for a given key
    private int hash(int key) {
        return key % SIZE; // Simple modulo hash function
    }

    /** Inserts the value key into the HashSet. */
    public void add(int key) {
        int index = hash(key);
        Node head = buckets[index];

        // Check if the key already exists in the linked list at this index
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                return; // Key already exists, do nothing
            }
            current = current.next;
        }

        // If the key does not exist, add it to the beginning of the linked list
        Node newNode = new Node(key);
        newNode.next = head;
        buckets[index] = newNode;
    }

    /** Returns whether the value key exists in the HashSet or not. */
    public boolean contains(int key) {
        int index = hash(key);
        Node current = buckets[index];

        // Traverse the linked list at the calculated index
        while (current != null) {
            if (current.key == key) {
                return true; // Key found
            }
            current = current.next;
        }
        return false; // Key not found
    }

    /** Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing. */
    public void remove(int key) {
        int index = hash(key);
        Node head = buckets[index];

        // If the bucket is empty, the key doesn't exist
        if (head == null) {
            return;
        }

        // If the key to be removed is the head of the list
        if (head.key == key) {
            buckets[index] = head.next;
            return;
        }

        // Traverse the linked list to find the node before the one to be removed
        Node current = head;
        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next; // Remove the node
                return;
            }
            current = current.next;
        }
    }
}
