# Design HashSet

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Design a HashSet without using any built-in hash table libraries.

Implement `MyHashSet` class:

- void add(key) Inserts the value key into the HashSet.
- bool contains(key) Returns whether the value key exists in the HashSet or not.
- void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

 

 **Example 1:** 

```
Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
```

 

 **Constraints:** 

- 0 <= key <= 106
- At most 104 calls will be made to add, remove, and contains.

## Solution

**Language:** Java  
**Runtime:** 13 ms (beats 61.05%)  
**Memory:** 49.8 MB (beats 95.16%)  
**Submitted:** 2026-09-03T06:45:57.825Z  

```java
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

```

---

[View on LeetCode](https://leetcode.com/problems/design-hashset/)