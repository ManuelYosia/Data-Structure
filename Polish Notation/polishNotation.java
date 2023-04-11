import java.util.*;

public class polishNotation {
    // Method untuk mengecek apakah karakter adalah operator
    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    // Method untuk mengecek apakah karakter adalah operand (huruf atau angka)
    private static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    // Method untuk mendapatkan nilai prioritas operator
    private static int getOperatorPriority(char op) {
        switch(op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Method untuk mengonversi notasi infix menjadi notasi prefix
    public static String infixToPrefix(String infix) {
        // Membuat objek stack kosong
        Stack<Character> stack = new Stack<>();
        String prefix = "";

        // Membaca notasi infix dari kanan ke kiri
        for (int i = infix.length()-1; i >= 0; i--) {
            char c = infix.charAt(i);

            // Jika karakter adalah operand, tambahkan ke notasi prefix
            if (isOperand(c)) {
                prefix = c + prefix;
            }
            // Jika karakter adalah operator
            else if (isOperator(c)) {
                // Pop stack untuk operator yang memiliki prioritas lebih tinggi atau sama
                while (!stack.isEmpty() && getOperatorPriority(stack.peek()) >= getOperatorPriority(c)) {
                    prefix = stack.pop() + prefix;
                }
                // Push operator ke stack
                stack.push(c);
            }
            // Jika karakter adalah kurung buka, pop stack sampai kurung tutup ditemukan
            else if (c == ')') {
                stack.push(c);
            }
            // Jika karakter adalah kurung tutup, pop stack sampai kurung buka ditemukan
            else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix = stack.pop() + prefix;
                }
                stack.pop();
            }
        }

        // Pop stack sampai kosong dan tambahkan ke notasi prefix
        while (!stack.isEmpty()) {
            prefix = stack.pop() + prefix;
        }

        return prefix;
    }

    // Method untuk mengonversi notasi infix menjadi notasi postfix
    public static String infixToPostfix(String infix) {
        // Membuat objek stack kosong
        Stack<Character> stack = new Stack<>();
        String postfix = "";

        // Membaca notasi infix dari kiri ke kanan
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // Jika karakter adalah operand, tambahkan ke notasi postfix
            if (isOperand(c)) {
                postfix += c;
            }
            // Jika karakter adalah operator
            else if (isOperator(c)) {
                // Pop stack untuk operator yang memiliki prioritas lebih tinggi atau sama
                while (!stack.isEmpty() && getOperatorPriority(stack.peek()) >= getOperatorPriority(c)) {
                    postfix += stack.pop();
                }
                // Push operator ke stack
                stack.push(c);
            }
            // Jika karakter adalah kurung buka, push ke stack
            else if (c == '(') {
                stack.push(c);
            }
            // Jika karakter adalah kurung tutup, pop stack sampai kurung buka ditemukan
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop(); // Hapus kurung buka dari stack
            }
        }

        // Pop stack sampai kosong dan tambahkan ke notasi postfix
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

    // Method untuk mengonversi notasi prefix menjadi notasi infix
    public static String prefixToInfix(String prefix) {
        // Membuat objek stack kosong
        Stack<String> stack = new Stack<>();

        // Membaca notasi prefix dari kanan ke kiri
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            // Jika karakter adalah operator
            if (isOperator(c)) {
                // Pop dua operand dari stack
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                // Buat notasi infix dengan menempatkan operator di antara kedua operand
                String infix = "(" + operand1 + c + operand2 + ")";

                // Push notasi infix ke stack
                stack.push(infix);
            }
            // Jika karakter adalah operand, push ke stack
            else {
                stack.push(Character.toString(c));
            }
        }

        // Notasi infix terakhir di stack adalah hasil konversi
        return stack.pop();
    }

    // Method untuk mengonversi notasi postfix menjadi notasi infix
    public static String postfixToInfix(String postfix) {
        // Membuat objek stack kosong
        Stack<String> stack = new Stack<>();

        // Membaca notasi postfix dari kiri ke kanan
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // Jika karakter adalah operator
            if (isOperator(c)) {
                // Pop dua operand dari stack
                String operand2 = stack.pop();
                String operand1 = stack.pop();

                // Buat notasi infix dengan menempatkan operator di antara kedua operand
                String infix = "(" + operand1 + c + operand2 + ")";

                // Push notasi infix ke stack
                stack.push(infix);
            }
            // Jika karakter adalah operand, push ke stack
            else {
                stack.push(Character.toString(c));
            }
        }

        // Notasi infix terakhir di stack adalah hasil konversi
        return stack.pop();
    }

    // Method untuk mengonversi notasi postfix menjadi notasi prefix
    public static String postfixToPrefix(String postfix) {
        // Membuat objek stack kosong
        Stack<String> stack = new Stack<>();

        // Membaca notasi postfix dari kiri ke kanan
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // Jika karakter adalah operator
            if (isOperator(c)) {
                // Pop dua operand dari stack
                String operand2 = stack.pop();
                String operand1 = stack.pop();

                // Buat notasi prefix dengan menempatkan operator di depan operand
                String prefix = c + operand1 + operand2;

                // Push notasi prefix ke stack
                stack.push(prefix);
            }
            // Jika karakter adalah operand, push ke stack
            else {
                stack.push(Character.toString(c));
            }
        }

        // Notasi prefix terakhir di stack adalah hasil konversi
        return stack.pop();
    }

    // Method untuk mengonversi notasi prefix menjadi notasi postfix
    public static String prefixToPostfix(String prefix) {
        // Membuat objek stack kosong
        Stack<String> stack = new Stack<>();

        // Membaca notasi prefix dari kanan ke kiri
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            // Jika karakter adalah operator
            if (isOperator(c)) {
                // Pop dua operand dari stack
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                // Buat notasi postfix dengan menempatkan operator di belakang operand
                String postfix = operand1 + operand2 + c;

                // Push notasi postfix ke stack
                stack.push(postfix);
            }
            // Jika karakter adalah operand, push ke stack
            else {
                stack.push(Character.toString(c));
            }
        }

        // Notasi postfix terakhir di stack adalah hasil konversi
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            
        while(true) {
            System.out.println("Notasi Polish");
            System.out.println("1. Infix");
            System.out.println("2. Postfix");
            System.out.println("3. Prefix");
            System.out.print("Pilihan anda: ");
            int choice = scanner.nextInt();

            System.out.print("Masukkan ekspresi notasi polish: ");
            scanner.nextLine();
            String expression = scanner.nextLine();                
            switch(choice) {
                case 1:
                    System.out.println("Postfix: " + infixToPostfix(expression));
                    System.out.println("Prefix: " + infixToPrefix(expression));
                    break;
                case 2:
                    System.out.println("Infix: " + postfixToInfix(expression));
                    System.out.println("Prefix: " + postfixToPrefix(expression));
                    break;
                case 3:
                    System.out.println("Infix: " + prefixToInfix(expression));
                    System.out.println("Postfix: " + prefixToPostfix(expression));
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            } 
            System.out.println("Apakah Anda ingin mengonversi lagi? (y/n)");
            String option = scanner.nextLine();
            if(option.equals("N") || option.equals("n")) {
                break;
            }
        }
        scanner.close();
    }
}
