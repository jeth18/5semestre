package holaMundo;

public class FuncionesMath {

	public static void main(String[] args) {
		//System.out.println(suma(3.4,4.5));
        
		double array[] = new double[4];
		
		for (int i = 0; i < 4; i++) {
			array[i] = i + 1;
		}
		
		System.out.println(promedio(array,4));
		
	}

	public static double suma(double num1, double num2) {
		return num1 + num2;
	}
	
	public static double promedio(double[] arr,int tam) {
		double total = 0;
		for (double suma : arr) {
			total = total + suma;
		}
		
		return total / tam;
	}
	
}

