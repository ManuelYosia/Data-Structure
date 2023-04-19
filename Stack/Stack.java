/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.strukturdata.task.stack;

/**
 *
 * @author Friska
 */

// untuk video running dapat dilihat di link berikut:
// https://drive.google.com/drive/folders/1c4wfqj9OkVVF4XmcnEzLTILFaYckNwNX?usp=sharing

public class Stack {

    public static class Node{
        private int value;
        private Node next, prev;
        
        public Node(int value){
            this.value = value;
            next = null;
            prev = null;
        }
    }
    
    public static class Stacks{
        private int count = 0;
        private Node first, last;
        
        
        public Stacks() {
            first = last = null;
        }
        
        public void push(int value){
            Node node = new Node(value);
            
            if(isEmpty()){
                first = node;
                last = node;
            } else {
                last.next = node;
                node.prev = last;
                last = node;
            }
            count++;
        }
        
        public int pop(){
            Node tmp = last;
            
            int value = tmp.value;
            if(isEmpty()){
                System.out.println("No data");
                return 0;
            }else if(tmp.prev != null){
                last = tmp.prev;
                last.next = null;
                count--;
            }else{
                first = last = null;
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
            Node tmp = first;
            
            if (first == null){
                System.out.print("No data entered on stack.");
            } else {
                while(tmp != null){
                    System.out.print(tmp.value + " ");
                    tmp = tmp.next;
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Stacks stack = new Stacks();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.print();
        System.out.println("\nLength: " + stack.length());
        
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        stack.print();
        System.out.println("\nLength: " + stack.length());
    }
}
