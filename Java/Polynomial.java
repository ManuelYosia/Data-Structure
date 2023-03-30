/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Krista
 */
public class Polynomial {

    /**
     * @param args the command line arguments
     */
    
    public static class Node {
        private int coef = 1;
        private int exponen = 0;
        private Node next;
        private Node prev;
        
        public Node(int coefValue, int exponenValue) {
            coef = coefValue;
            exponen = exponenValue;
            next = null;
            prev = null;
        }
    }
    
    public static class List {
        private Node head, tail;
        private int size;
        
        public List() {
            head = tail = null;
        }
        
        public void addFirst(int coefValue, int exponenValue) {
            Node newNode = new Node(coefValue, exponenValue);
            
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
        
        public void addLast(int coefValue, int exponenValue) {
            Node newNode = new Node(coefValue, exponenValue);
            
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
        
        public void insertBefore(int coefValue, int exponenValue, int key) {
            Node tmp = head;
            Node newNode = new Node(coefValue, exponenValue);
            
            do{
                if(key == tmp.exponen) {
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
        
        public void insertAfter(int coefValue, int exponenValue, int key) {
            Node tmp = head;
            Node newNode = new Node(coefValue, exponenValue);
            
            do{
                if(key == tmp.exponen) {
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
            
            while(tmp != null) {
                if(tmp.coef == 0) {
                    tmp = tmp.next;
                    continue;
                }
                System.out.print(tmp.coef + "x" + tmp.exponen);
                
                if(tmp.next != null) {
                    System.out.print(" + ");
                }
                
                tmp = tmp.next;
            }
            System.out.println();
        }
    }
    
    public static void add(int coefValue, int exponenValue, List list) {// untuk input data
        Node tmp = list.head;
        
        if(list.isEmpty()) {
            list.addFirst(coefValue, exponenValue); 
            return;
        }
        
        if(exponenValue > list.head.exponen) {
            list.addFirst(coefValue, exponenValue); 
            return;
        }
        
        if(exponenValue < list.tail.exponen) {
            list.addLast(coefValue, exponenValue);  
            return;
        }
        
        do {
            if(exponenValue > tmp.exponen) {
                list.insertBefore(coefValue, exponenValue, tmp.exponen);
                break;
            }
            tmp = tmp.next;
        }while(tmp != null);
    }
    
    
    
    public static void main(String args[]) {
        // TODO code application logic here
        List p1 = new List();
        List p2 = new List();
        
        add(3, 9, p1);
        add(6, 8, p1);
        add(12, 7, p1);
        add(5, 5, p1);
        add(3, 4, p1);
        
        add(3, 2, p2);
        add(5, 3, p2);
        add(9, 1, p2);
        add(3, 5, p2);
        add(2, 4, p2);
        
        
        p1.print();
        p2.print();
//        subtractionPoly(p1, p2);
    }
}
