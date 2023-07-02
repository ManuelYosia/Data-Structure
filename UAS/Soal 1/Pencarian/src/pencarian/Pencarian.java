/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pencarian;

/**
 *
 * @author manue
 */
public class Pencarian {
    public static class Node {
        private String npm, nama;
        private Node next;

        public Node(String npm, String nama) {
        this.npm = npm;
        this.nama = nama;
        this.next = null;
        }
    }
    public static class LinkedList {
        private Node head, tail;//head node digunakan untuk menahan list
        private int size = 0;
    
        


        public void inisialisasi() {
            head = tail = null;
        }

        public void addFirst(String npm, String nama) {
            Node node = new Node(npm, nama); 
            if(isEmpty()) {
                head = node;
                tail = node;
            }else {
                node.next = head; //untuk mengarahkan ke alamat head node
                head = node; //alamat baru head
            }

            size++;
        }

        public void addLast(String npm, String nama) {
            Node node = new Node(npm, nama); 
                
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
                    System.out.print(p.npm + "->" + p.nama);
                    System.out.print(" ");
                    System.out.println();
                    p = p.next;
                }
            }
    }
    // Fungsi ini akan mencari lalu menampilkan nama mahasiswa sesuai dengan npm yang diinput   
    public static void search(LinkedList list, String npm) {
        Node temp = list.head;
        
        while(true){
            if(temp == null){
                System.out.println("Mahasiswa Tidak Ada");
                break;
            }
            if(temp.npm == npm){
               System.out.println("NPM yang dicari: "+npm);
               System.out.println("Nama Mahasiswa: "+temp.nama);
               break; 
            }
            temp = temp.next;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList mahasiswa = new LinkedList();
        
        mahasiswa.addFirst("22120066", "Manuel Yosia");
        mahasiswa.addLast("22120081", "Friska Adhisti");
        System.out.println(mahasiswa.isEmpty());
        mahasiswa.print();
        search(mahasiswa, "22120081");
    }
    
}
