

import java.util.Scanner;

public class Picapiedra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int auto;
      int nPiedras;
      
      
      auto = sc.nextInt();
      nPiedras = sc.nextInt();
      
      int[] array = new int[nPiedras];
      
      for(int i = 0; i < nPiedras; i++) {
        array[i] = sc.nextInt();
      }
      
      int aux;
      for (int i = 0; i < nPiedras; i++) {
          for(int j = 1; j < nPiedras; j++) {
              if(array[j] > array[i]) {
                 aux = array[j];
                 array[j] = array[i];
                 array[i] = aux;
              }
          }
      }
      
      int cont = 0;
      int suma = 0;
      int j=0;
      
          while (suma < auto) {
              suma = suma + array[j++];
              cont++;
          }
        System.out.println(cont);
    }
    
}
