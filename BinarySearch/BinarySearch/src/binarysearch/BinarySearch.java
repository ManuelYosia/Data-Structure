/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearch;

// Link Video : https://drive.google.com/file/d/1bEI32LzNjnmduqNd5OffaPzsQSQ5wEgJ/view?usp=sharing
/**
 *
 * @author manue
 */
public class BinarySearch {

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
    
    static int binarySearch(int[]angka, int cari, int i, int j){
        int tengah;
        while(i<=j){
            tengah = (i+j)/2;
            if(cari == angka[tengah]) return tengah;
            else if(cari<angka[tengah]) j=tengah-1;
            else i=tengah+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[]angka = {34,67,23,28,98,15,89,67,28,18};
        
        bubbleSort(angka);
        
        for(int i = 0; i < angka.length; i++){
            System.out.print(angka[i]+ " ");
        }
        
        int cari = 2;
        
        int hasil = binarySearch(angka, cari, 0, angka.length-1);
        
        if(hasil>=0) System.out.println("Angka ketemu " +hasil);
        else System.out.println("Angka tidak ada");
    }
    
}
