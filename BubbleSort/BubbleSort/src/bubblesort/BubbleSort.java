/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesort;
//Link Video : https://drive.google.com/file/d/12nYmLIbhf4JQVuq__H8meJyraKW2DVbh/view?usp=sharing
/**
 *
 * @author manue
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    static void bubbleSort(int[]angka) {
        for(int i = 0; i < angka.length; i++) {
            for(int j = 0; j < angka.length-1; j++) {
                if(angka[j] > angka[j + 1]) {
                    int temp = angka[j];
                    angka[j] = angka[j+1];
                    angka[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[]angka = {34,67,23,28,98,15,89,67,28,18};
        
        bubbleSort(angka);
        
        for(int i = 0; i < angka.length; i++){
           System.out.print(angka[i]+ " ");
        }
    }
    
}
