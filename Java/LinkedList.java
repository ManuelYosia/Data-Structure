/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author Krista
 */
public class LinkedList {
    
    
    public static class Node {
        private int data;
        private Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static class List {
        private Node head, tail;//head node digunakan untuk menahan list
        private int size = 0;
        
        public void inisialisasi() {
            head = tail = null;
        }

        public void addFirst(Node node) {
            if(isEmpty()) {
                head = node;
                tail = node;
            }else {
                node.next = head; //untuk mengarahkan ke alamat head node
                head = node; //alamat baru head
            }

            size++;
        }

        public void addLast(Node node) {
            if(isEmpty()) {
                head = node;
                tail = node;
            }else {
                tail.next = node;
                tail = node; //alamat baru tail
            }

            size++;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int length() {
            return size;
        }
        
        public void print() {
            Node p = head;
            
            while(p != null) {
                System.out.print(p.data);
                System.out.print(" ");
                
                p = p.next;
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
        Node node1 = new Node(100);
        Node node2 = new Node(200);
        Node node3 = new Node(300);
        Node node4 = new Node(400);
        
        List linkedList = new List();
        
        linkedList.inisialisasi(); //Menginisialisasi list
        
        //kondisi awal
        linkedList.addFirst(node1); //Menambahkan node ke dalam list
        linkedList.addLast(node2);
        linkedList.addLast(node3);
        linkedList.addLast(node4);
        
        //Menambahkan data
        linkedList.addFirst(new Node(99));
        linkedList.addFirst(new Node(98));
        linkedList.addFirst(new Node(97));
        linkedList.addFirst(new Node(96));
        linkedList.addFirst(new Node(95));
        linkedList.addLast(new Node(401));
        linkedList.addLast(new Node(402));
        linkedList.addLast(new Node(403));
        linkedList.addLast(new Node(404));
        linkedList.addLast(new Node(405));
        linkedList.addLast(new Node(406));
        linkedList.addLast(new Node(407));
        linkedList.addLast(new Node(408));
        linkedList.addLast(new Node(409));
        linkedList.addLast(new Node(410));
        
        //Menampilkan ukuran
        System.out.println( "Ukuran: "+linkedList.length());
        
        //Menampilkan data dalam linked list
        linkedList.print();
    }
    
   
}