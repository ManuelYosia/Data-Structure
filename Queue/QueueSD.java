/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.strukturdata.task.queue;

/**
 *
 * @author Friska
 */

// untuk video running dapat dilihat disini:
 // https://drive.google.com/drive/folders/1Pnyo11HNhW6JC0qyBqE783UVEMXx8mMv?usp=sharing

public class QueueSD {

    public static class Node{
        private int value;
        private Node next;
        private Node prev;
        
        public Node(int value){
            this.value = value;
            next = prev = null;
        }
    }
    
    public static class Queue{
        private Node front, rear;
        private int count = 0;
        
        public Queue(){
            front = rear = null;
        }
        
        public void queue(int value){
            Node node = new Node(value);
            
            if(isEmpty()){
                front = rear = node;
            } else {
                rear.next = node;
                node.prev = rear;
                rear = node;
            }
            count++;    
        }
        
        public int dequeue(){
            
            int value = front.value;
            
            if(isEmpty()){
                System.out.println("No data");
                return 0;
                
            }else if(front.next != null){
                front = front.next;
                front.prev = null;
                
                count--;
                
            }else{
                front = rear = null;
                count--;
            }
            
            
            
            return value;
        }
        
        public boolean isEmpty(){
            return count == 0;
        }
        
        public int length(){
            return count;
        }
        
        public void print(){
            Node tmp = front;
            
            while(tmp != null){
                System.out.print(tmp.value + " ");
                
                tmp = tmp.next;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
        Queue q = new Queue();
        
        q.queue(1);
        q.queue(2);
        q.queue(3);
        q.queue(4);
        q.queue(5);
        q.queue(6);
        
        System.out.println("\nLength: " + q.length());
        q.print();
        System.out.println();
        
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        q.print();
        System.out.println("\nLength: " + q.length());
    }
}