/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tree;

/**
 *
 * @author manue
 */
public class Tree {
    public static class Node {
        String nama;
        Node right, left;
                
        public Node(String nama) {
            this.nama = nama;
            this.right = null;
            this.left = null;
        }
    }
    
    //Breadth First Search
    
    //Depth First Search
    
    // method transverse pre-order
    public static void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.nama);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

        // method transverse in-order
        public void traverseInOrder(Node node) {
            if (node != null) {
                traverseInOrder(node.left);
                System.out.print(" " + node.nama);
                traverseInOrder(node.right);
            }
        }

        // method transverse post-order
        public void traversePostOrder(Node node) {
            if (node != null) {
                traversePostOrder(node.left);
                traversePostOrder(node.right);
                System.out.print(" " + node.nama);
            }
        }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        //Keturunan 0
        Node grandFather = new Node("Peter");
        //Keturunan 1
        Node child1 = new Node("Ben");
        Node child2 = new Node("Mike");
        //Keturunan 2
        Node grandChild1 = new Node("Miles");
        Node grandChild2 = new Node("Miguel");
        Node grandChild3 = new Node("Gwen");
        //Keturunan 3
        Node grandGrandChild1 = new Node("Parker");
        Node grandGrandChild2 = new Node("James");
        Node grandGrandChild3 = new Node("Krista");
        
        //keturunan 1
        grandFather.left = child1;
        grandFather.right = child2;
        
        //keturunan 2
        child1.left = grandChild1;
        child1.right = grandChild2;
        child2.left = grandChild3;
        
        //keturunan 3
        grandChild1.left = grandGrandChild1;
        grandChild2.left = grandGrandChild2;
        grandChild3.left = grandGrandChild3;
        
        traversePreOrder(grandFather);
        System.out.println();
        
    }
    
}
