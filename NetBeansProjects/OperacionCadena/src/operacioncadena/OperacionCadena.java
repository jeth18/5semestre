
/**
 * <h1> Operaciones Cadena </h1>
 * La OperacionesCadena es un programa que se encarfa de contar cuantas
 * caractere tiene un arreglo.
 *
 * @author Jethran Gómez
 * @version 1.0
 * @since 2018-08-30
 */

public class OperacionCadena {

    private String cadena;

    /**
     * El constructor se encarga de resivir una cadena y guardar en la variable
     * cadena
     *
     * @param cadena unico parametro
     */
    public OperacionCadena(String cadena) {
        this.cadena = cadena;
    }

    /**
     * Este metodo se encarga de contar cuantas veces ser repite un caracter en
     * la cadena
     *
     * @param caracter Unico caracter
     * @return ocurrencias cuantas veces se repitio el caracter
     */
    public int ocurrenciasCaracter(char caracter) {
        char[] caracteres = this.cadena.toCharArray();
        int ocurrencias = 0;
        for (char aux : caracteres) {
            if (aux == caracter) {
                ocurrencias++;
            }
        }
        return ocurrencias;
    }

    /**
     * Este metodo sirve para invetir la cadena de manera recursiva
     *
     * @param palabra resive una cadena
     * @return reverse
     */
    public String reverse(String palabra) {
        if (palabra.length() == 1) {
            return palabra;
        } else {
            return reverse(palabra.substring(1)) + palabra.charAt(0);
        }
    }

    /**
     * Metodo para invetir una cadena
     */
    public void invetirCad() {

        char[] caracteres = this.cadena.toCharArray();
        char[] arregloAp = new char[caracteres.length];

        for (int i = caracteres.length - 1, j = 0; j < caracteres.length; j++, i--) {
            arregloAp[j] = caracteres[i];
        }

        this.cadena = new String(arregloAp);
    }
}
