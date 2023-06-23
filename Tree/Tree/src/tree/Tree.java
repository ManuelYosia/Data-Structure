/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tree;
//Link Video : https://drive.google.com/file/d/1BbL21_2bfOjxdtbZfDXC1TxAi1Eqy0lI/view?usp=sharing
/**
 *
 * @author manue
 */
public class Tree {

    public class Node {
        private Node left;
        private Node right;
        private String data;

        public Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public class BinaryTree {
        int size = 0;
        Node root;

        // recursive method untuk menambahkan node baru
        private Node addRecursive(Node current, String data) {
            // jika current = null, maka akan dibuat node baru untuk menyimpan data
            if (current == null) {
                return new Node(data);
            }

            // jika current != 0, maka masuk ke logic di bawah ini
            // membuat method compare result untuk membandingkan String data yang dimasukkan
            // method compareTo -> method bawaan dari java untuk tipe data string yang berfungsi untuk membandingkan urutan leksikografis (berdasarkan abjad / huruf)
            int compareResult = data.compareTo(current.data);
            
            if (compareResult < 0) {
                // jika hasil perbandingan kurang dari 0, maka ditambahkan ke subtree kiri dengan memanggil method addRecursive dan update data
                current.left = addRecursive(current.left, data);
            } else if (compareResult > 0) {
                // jika hasil perbandingan lebih dari 0, maka ditambahkan ke subtree kanan dengan memanggil method addRecursive dan update data
                current.right = addRecursive(current.right, data);
              // 
            } else {
                // data sudah ada dalam tree
                return current;
            }
            return current;
        }

        public void add(String data) {
            root = addRecursive(root, data);
            size++;
        }

        // Method untuk mencari node
        private boolean searchRecursive(Node current, String data) {
            if (current == null) {
                return false;
            }

            int compareResult = data.compareTo(current.data);
            if (compareResult == 0) {
                return true;
            }

            if (compareResult < 0) {
                return searchRecursive(current.left, data);
            } else {
                return searchRecursive(current.right, data);
            }
        }

        public boolean search(String data) {
            return searchRecursive(root, data);
        }

        // method untuk mencari data terkecil
        private String findSmallest(Node root) {
            return root.left == null ? root.data : findSmallest(root.left);
        }

        // Method untuk menghapus node
        private Node deleteRecursive(Node current, String data) {
            if (current == null) {
                return null;
            }

            int compareResult = data.compareTo(current.data);
            if (compareResult == 0) {
                // Kasus 1: Node tidak memiliki anak
                if (current.left == null && current.right == null) {
                    return null;
                }
                // Kasus 2: Node memiliki anak tunggal
                if (current.right == null) {
                    return current.left;
                }
                if (current.left == null) {
                    return current.right;
                }
                // Kasus 3: Node memiliki dua anak
                String smallestValue = findSmallest(current.right);
                current.data = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }

            if (compareResult < 0) {
                current.left = deleteRecursive(current.left, data);
                return current;
            }
            current.right = deleteRecursive(current.right, data);
            return current;
        }

        public void delete(String data) {
            root = deleteRecursive(root, data);
            size--;
        }

        // method transverse pre-order
        public void traversePreOrder(Node node) {
            if (node != null) {
                System.out.print(" " + node.data);
                traversePreOrder(node.left);
                traversePreOrder(node.right);
            }
        }

        // method transverse in-order
        public void traverseInOrder(Node node) {
            if (node != null) {
                traverseInOrder(node.left);
                System.out.print(" " + node.data);
                traverseInOrder(node.right);
            }
        }

        // method transverse post-order
        public void traversePostOrder(Node node) {
            if (node != null) {
                traversePostOrder(node.left);
                traversePostOrder(node.right);
                System.out.print(" " + node.data);
            }
        }

        // private void printTree(Node node, String prefix, boolean isLeft) {
        // if (node == null) {
        // return;
        // }

        // String nodeString = "(" + node.data + ")";
        // String lineString = "----------";

        // System.out.println(prefix + nodeString);
        // System.out.println(prefix + (isLeft ? "| " : " ") + "|");
        // System.out.println(prefix + (isLeft ? "| " : " ") + lineString);

        // printTree(node.left, prefix + (isLeft ? "| " : " "), true);
        // printTree(node.right, prefix + (isLeft ? "| " : " "), false);
        // }

        // public void print() {
        // printTree(root, "", false);
        // }

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        BinaryTree t = tree.new BinaryTree();

        t.add("A"); // Menambahkan root node "A"
        t.root.left = tree.new Node("B"); 
        t.root.left.left = tree.new Node("Z"); 
        t.root.left.right = tree.new Node("C"); 
        t.root.right = tree.new Node("U");
        t.root.right.left = tree.new Node("G"); 
        t.root.right.right = tree.new Node("F"); 
        t.root.right.left.left = tree.new Node("P"); 
        t.root.right.left.right = tree.new Node("O"); 

        System.out.println("Binary Tree");

        System.out.print("Pre-order traversal:");
        t.traversePreOrder(t.root);
        System.out.println();

        System.out.print("In-order traversal:");
        t.traverseInOrder(t.root);
        System.out.println();

        System.out.print("Post-order traversal:");
        t.traversePostOrder(t.root);
        System.out.println();

    }
}

