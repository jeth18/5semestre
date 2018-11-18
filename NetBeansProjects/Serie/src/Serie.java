import java.util.Scanner;

public class Serie {

    public static void main(String[] args) {
        int[] array = new int[100];
        int n;
        int j = 0;
        Scanner sc = new Scanner(System.in);
        
        do {
            n = sc.nextInt();
            if (n < 0 || n > 100) {
               
            } else {
                array[j++] = n;
            }
        }while (!(n == -1));
        
        for(int i = 0, a = array.length - 1; i < a; i++) {
            if(i == 10) {
                System.out.println(array[i]);
            }
        }
        
}
    
}
