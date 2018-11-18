
import java.util.Scanner;

public class Ulam {
    public static void main(String[] args) {
       
      Scanner sc = new Scanner(System.in);
      int n;
      
      n = sc.nextInt();
      
      int[] array = new int[30];
     
      int j = 0;
      int aux;
      
      if (n <= 1 || n >= 1800) {
      } else {
          array[0] = n;
          while (array[j] != 1) {
              aux = array[j];
              if((array[j] % 2) == 0) {
                  j++;
                  array[j] = aux / 2; 
              } else {
                  j++;
                  array[j] = ((aux * 3) + 1);
              }
          }
      }
        
      for (int ar = array.length - 1; ar > 0; ar--) {
        if (array[ar] != 0) {
          System.out.println(array[ar]);
          }
      }    
    }    
}
