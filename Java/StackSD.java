/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Krista
 */
public class StackSD {
    
    public static class Node{
        private int value;
        private Node next, prev;
        
        public Node(int value){
            this.value = value;
            next = null;
            prev = null;
        }
    }
    
    public static class Stack{
        private int count = 0;
        private Node first, last;
        
        
        public Stack() {
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
            }
            
            last = tmp.prev;
            tmp = null;
            last.next = null;
            
            
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
        Stack stack = new Stack();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        System.out.println("Length: " + stack.length());
        stack.print();
        
        System.out.println();
        
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        
        System.out.println("Length: " + stack.length());
        stack.print();
    }
}
