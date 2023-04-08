import java.util.Scanner;

public class Polynomial {
    
    public static class Node {
        public int coef; 
        public int degree; // 0 if constant
        public Node next;
        public Node prev;

        public Node(int coef, int degree){
            this.coef = coef;
            this.degree = degree;
            this.next = null;
            this.prev = null;
        }
    }

    public static class Polynomials {
        Node head, tail;
        int size = 0;

        public Polynomials(){
            head = tail = null;
        }

        boolean isEmpty(){
            return size == 0;
        }

        int length(){
            return size;
        }

        public void addFirst(int coef, int degree){
            Node newNode = new Node(coef, degree);

            if(isEmpty()){
                head = newNode;
                tail = newNode;
            } else {
                head.prev = newNode;
                newNode.next = head;
                newNode.prev = null;
                head = newNode;
            }
            size++;
        }

        public void addLast(int coef, int degree){
            Node newNode = new Node(coef, degree);

            if(isEmpty()){
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.next = null;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        public void insertAfter(int coef, int degree ,int after){
            Node newNode = new Node(coef, degree);
            Node current = head;

            do {
                if (current.degree == after){
                    newNode.next = current.next;
                    current.next = newNode;
                    size++;
                    return;
                }
                current = current.next;
            }
            while(current != null);
            System.out.println(after + " not found in the list.");
        }

        public void insertBefore(int coef, int degree, int before){
            Node newNode = new Node(coef, degree);
            Node current = head;

            do {
                if (current.next.degree == before) {
                    newNode.next = current.next;
                    current.next = newNode;
                    size++;
                    return;
                }
                current = current.next;
            }
            while (current.next != null);
            System.out.println(before + " not found in the list.");
        }

        public static void term(Polynomials p, int coef, int degree){
            Node current = p.head;

            if (p.isEmpty()){
                p.addFirst(coef, degree);
                return;
            }
            if (degree > p.head.degree){
                p.addFirst(coef, degree);
                return;
            }
            if (degree < p.tail.degree){
                p.addLast(coef, degree);
                return;
            }
            do{
                if (degree > current.degree){
                    p.insertBefore(coef, degree, current.degree);
                    break;
                }
                current = current.next;
            } while (current != null);
        }

        public Polynomials sumPoly(Polynomials p1, Polynomials p2){
            int sum;
            Polynomials result = new Polynomials();
            Node node1 = p1.head;
            Node node2 = p2.head;

            // selama p1 & p2 tidak kosong 
            while (node1 != null && node2 != null){
                // jika degree p1 == degree p2 maka coef term (suku) dari polinomial akan ditambahkan
                if (node1.degree == node2.degree){
                    sum = node1.coef + node2.coef;
                    // nilai penambahan dari dua polinomial disimpan ke dalam polinomial baru (result)
                    result.addLast(sum, node1.degree);
                    node1 = node1.next;
                    node2 = node2.next;
                    // jika degree p1 > degree p2
                } else if (node1.degree > node2.degree){
                    // nilai term (suku) ditambahkan ke polinomial baru (result)
                    result.addLast(node1.coef, node1.degree);
                    node1 = node1.next;
                } else { // jika degree p1 < degree p2
                    // nilai term (suku) ditambahkan ke polinomial baru (result)
                    result.addLast(node2.coef, node2.degree);
                    node2 = node2.next;
                }
            }
            // sisa elemen polinomial pertama
            while (node1 != null){
                result.addLast(node1.coef, node1.degree);
                node1 = node1.next;
            }
            // sisa elemen polinomial kedua
            while (node2 != null){
                result.addLast(node2.coef, node2.degree);
                node2 = node2.next;
            }
            return result;
        }

        public Polynomials subPoly(Polynomials p1, Polynomials p2){
            int sub;
            Polynomials result = new Polynomials();
            Node node1 = p1.head;
            Node node2 = p2.head;
        
            // selama p1 & p2 tidak kosong
            while (node1 != null && node2 != null){
                // jika degree p1 == degree p2 maka coef term (suku) dari polinomial akan dikurangkan
                if (node1.degree == node2.degree){
                    sub = node1.coef - node2.coef;
                    // nilai pengurangan dari dua polinomial disimpan ke dalam polinomial baru (result)
                    result.addLast(sub, node1.degree);
                    node1 = node1.next;
                    node2 = node2.next;
                // jika degree p1 > degree p2
                } else if (node1.degree > node2.degree){
                    // nilai term (suku) ditambahkan ke polinomial baru (result)
                    result.addLast(node1.coef, node1.degree);
                    node1 = node1.next;
                } else { // jika degree p1 < degree p2
                    // nilai term (suku) ditambahkan ke polinomial baru (result)

                    result.addLast(-node2.coef, node2.degree);
                    node2 = node2.next;
                }
            }
            // sisa elemen polinomial pertama
            while (node1 != null){
                result.addLast(node1.coef, node1.degree);
                node1 = node1.next;
            }
            // sisa elemen polinomial kedua
            while (node2 != null){
                result.addLast(-node2.coef, node2.degree);
                node2 = node2.next;
            }
            return result;
        }        

        public void print(){
            if (isEmpty()){
                System.out.println("No Polynomial entered.");  
            }
            else{
                Node current = head;
                boolean isFirstTerm = true;
                while (current != null){
                    if (current.coef != 0){
                        if (!isFirstTerm && current.coef > 0){
                            System.out.print(" + ");
                        } 
                        System.out.print(current.coef);
                        if (current.degree > 1){
                            System.out.print("x^" + current.degree);
                        } else if (current.degree == 1){
                            System.out.print("x");
                        } 
                        isFirstTerm = false;
                    }
                    current = current.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        Polynomials poly1 = new Polynomials();
        Polynomials poly2 = new Polynomials();

        Polynomials.term(poly1, 8, 7);
        Polynomials.term(poly1, 6, 8);
        Polynomials.term(poly1, 1, 3);
        Polynomials.term(poly1, 5, 5);
        Polynomials.term(poly1, 15, 0);
        poly1.print();
        System.out.println("");
        Polynomials.term(poly2, 3, 9);
        Polynomials.term(poly2, 4, 7);
        Polynomials.term(poly2, 2, 3);
        Polynomials.term(poly2, 3, 4);
        Polynomials.term(poly2, 2, 2);
        Polynomials.term(poly2, 10, 0);
        poly2.print();

        // Menjumlahkan dua polinomial (poly1 dan poly2) dan menyimpan hasilnya pada polinomial baru
        Polynomials p3 = poly1.sumPoly(poly1, poly2);
        System.out.print("\nP1 + P2 = ");
        p3.print();

        Polynomials p4 = poly1.subPoly(poly1, poly2);
        System.out.print("\nP1 - P2 = ");
        poly1.print(); 
        System.out.print(" - (");
        poly2.print();
        System.out.print(") = ");
        p4.print();
        
        
        // System.out.println("Enter the polynomial");
    }
}