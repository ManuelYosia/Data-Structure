/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linearprobinghashtabletree;

// Link Video : https://drive.google.com/file/d/1Hu9L8a6lmqIWkBHYpPWInuTFdh7zba5G/view?usp=sharing
/**
 *
 * @author manuel
 */
import java.util.*;

class Node {
    int key;
    String value;
    Node left;
    Node right;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class HashTable {
    private static final int SIZE = 10;
    private Node[] hashArray;

    public HashTable() {
        hashArray = new Node[SIZE];
        Arrays.fill(hashArray, null);
    }

    public void insert(int key, String value) {
        int hash = hashFunc(key);

        if (hashArray[hash] == null) {
            hashArray[hash] = new Node(key, value);
        } else {
            // Linear probing to find an empty slot
            int step = 1;
            while (hashArray[hash] != null) {
                hash += step;
                hash %= SIZE;
                step++;
            }
            hashArray[hash] = new Node(key, value);
        }
    }

    public String find(int key) {
        int hash = hashFunc(key);

        if (hashArray[hash] != null && hashArray[hash].key == key) {
            return hashArray[hash].value;
        } else {
            // Linear probing to find the key
            int step = 1;
            while (hashArray[hash] != null && hashArray[hash].key != key) {
                hash += step;
                hash %= SIZE;
                step++;
            }
            if (hashArray[hash] != null && hashArray[hash].key == key) {
                return hashArray[hash].value;
            } else {
                return null;
            }
        }
    }

    private int hashFunc(int key) {
        return key % SIZE;
    }
}

public class LinearProbingHashTableTree {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert(10, "Value 1");
        hashTable.insert(20, "Value 2");
        hashTable.insert(30, "Value 3");

        System.out.println("Value for key 20: " + hashTable.find(20));
        System.out.println("Value for key 30: " + hashTable.find(30));
        System.out.println("Value for key 40: " + hashTable.find(40));
    }
}
