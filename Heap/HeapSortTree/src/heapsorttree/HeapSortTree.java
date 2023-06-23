/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package heapsorttree;
// Link Video : https://drive.google.com/file/d/1lhdGDimGP1_cERSZkNETSyfN3X5RL9B8/view?usp=sharing
/**
 *
 * @author manue
 */
import java.util.Arrays;

class Node {
    int key;
    
    Node(int key) {
        this.key = key;
    }
}

public class HeapSortTree {
    private static void heapify(Node[] tree, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && tree[left].key > tree[largest].key) {
            largest = left;
        }
        
        if (right < n && tree[right].key > tree[largest].key) {
            largest = right;
        }
        
        if (largest != i) {
            swap(tree, i, largest);
            heapify(tree, n, largest);
        }
    }
    
    private static void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void heapSort(int[] arr) {
        int n = arr.length;
        Node[] tree = new Node[n];
        
        for (int i = 0; i < n; i++) {
            tree[i] = new Node(arr[i]);
        }
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(tree, n, i);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = tree[0].key;
            swap(tree, 0, i);
            heapify(tree, i, 0);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Array sebelum diurutkan: " + Arrays.toString(arr));
        
        heapSort(arr);
        
        System.out.println("Array setelah diurutkan menggunakan Heap Sort: " + Arrays.toString(arr));
    }
}