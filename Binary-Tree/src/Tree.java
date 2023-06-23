public class Tree {

    public class Node {
        private Node left;
        private Node right;
        private Node middle;
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

            // membuat variabel compareResult untuk membandingkan String data yang
            // dimasukkan
            // metode compareTo() adalah metode bawaan dari Java untuk membandingkan urutan
            // leksikografis (berdasarkan abjad/huruf) antara dua string
            int compareResult = data.compareTo(current.data);

            if (compareResult < 0) {
                // jika hasil perbandingan kurang dari 0, maka ditambahkan ke subtree kiri
                // dengan memanggil metode addRecursive dan mengupdate anak kiri
                current.left = addRecursive(current.left, data);
            } else if (compareResult > 0) {
                // jika hasil perbandingan lebih dari 0, maka ditambahkan ke subtree kanan
                // dengan memanggil metode addRecursive dan mengupdate anak kanan
                current.right = addRecursive(current.right, data);
            } else {
                // data sudah ada dalam tree
                current.middle = addRecursive(current.middle, data);
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

        private void printTree(Node node, String prefix, boolean isLeft) {
            if (node == null) {
                return;
            }

            String nodeString = "(" + node.data + ")";
            String lineString = "----------";

            System.out.println(prefix + nodeString);
            System.out.println(prefix + (isLeft ? "| " : " ") + "|");
            System.out.println(prefix + (isLeft ? "| " : " ") + lineString);

            printTree(node.left, prefix + (isLeft ? "| " : " "), true);
            printTree(node.right, prefix + (isLeft ? "| " : " "), false);
        }

        public void print() {
            printTree(root, "", false);
        }

    }

    public static void main(String[] args) {
        // menginisialisasi tree baru
        Tree tree = new Tree();
        BinaryTree t = tree.new BinaryTree();

        t.add("40");
        t.add("30");
        t.add("65");
        t.add("50");
        t.add("25");
        t.add("35");
        t.add("10");
        t.add("26");
        t.add("29");
        t.add("33");
        t.add("34");

        // menampilkan isi tree yang sudah diinisialisasi
        System.out.println("Tree awal yang diinisialisasi:");
        t.print();

        t.delete("30");

        // menampilkan isi tree sesudah menghapus data '30'
        System.out.println("\nTree sesudah menghapus data '30':");
        t.print();
    }
}
