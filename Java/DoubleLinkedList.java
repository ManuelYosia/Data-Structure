/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Krista
 */

//Link video sebagai bukti jika program berjalan dengan baik
// https://drive.google.com/drive/folders/1BQa5YWPfX9BJX9YEBUaDqZFaqKv8jbgX?usp=share_link
public class DoubleLinkedList {

    /**
     * @param args the command line arguments
     */
    public static class Node {
        private Node next;
        private Node prev;
        private int data;
        
        public Node(int input) {
            data = input;
            prev = null;
            next = null;
        }
    }
    
    public static class List {
        private Node head, tail;
        private int size = 0;
        
        public void inisialisasi() {
            head = tail = null;
        }
        
        public void addFirst(int data) {
            Node newNode = new Node(data);
            
            if(isEmpty()) {
                head = newNode;
                tail = newNode;
            }else{
                head.prev = newNode;
                newNode.next = head;
                newNode.prev = null;
                head = newNode;
            }
            size++;
        }
        
        public void addLast(int data) {
            Node newNode = new Node(data);
            
            if(isEmpty()) {
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                newNode.next = null;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }
        
        public void insertBefore(int data, int key) {
            Node tmp = head;
            Node newNode = new Node(data);
            
            do{
                if(key == tmp.data) {
                    newNode.next = tmp;
                    newNode.prev = tmp.prev;
                    tmp.prev.next = newNode;
                    tmp.prev = newNode;
                    size++;
                    System.out.println("Insert Successful");
                    break;
                }
                tmp = tmp.next;
            }while(tmp != null);
        }
        
        public void insertAfter(int data, int key) {
            Node tmp = head;
            Node newNode = new Node(data);
            
            do{
                if(key == tmp.data) {
                    newNode.next = tmp.next;
                    newNode.prev = tmp;
                    tmp.next.prev = newNode;
                    tmp.next = newNode;
                    size++;
                    System.out.println("Insert Successful");
                    break;
                }
                tmp = tmp.next;
            }while(tmp != null);
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public int length() {
            return size;
        }
        
        public void print() {
            Node tmp = head;
            
            while(tmp != null)
            {
               System.out.print(tmp.data);
               System.out.print(" ");
               
               tmp = tmp.next;
            }    
        }
    }
    
    public static void main(String args[]) {
        // TODO code application logic here
        
        List linkedList = new List();
        
        linkedList.inisialisasi();
        
        linkedList.addFirst(100);
        linkedList.addLast(200);
        linkedList.addLast(300);
        linkedList.addLast(400);

        linkedList.addFirst(99);
        linkedList.addFirst(98);
        linkedList.addFirst(97);
        linkedList.addFirst(96);
        linkedList.addFirst(95);
        linkedList.addLast(401);
        linkedList.addLast(402);
        linkedList.addLast(403);
        linkedList.addLast(404);
        linkedList.addLast(405);
        linkedList.addLast(406);
        linkedList.addLast(407);
        linkedList.addLast(408);
        linkedList.addLast(409);
        linkedList.addLast(410);
        
        
        System.out.println(linkedList.length());
        linkedList.print();
    }
}
