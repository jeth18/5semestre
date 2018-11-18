package tienda;

public class Producto {
  private String nombre;
  private double peso;
  private double precio;
  private int existencias;



  public Producto(String nombre, double peso, double precio, int existencias) {
    this.nombre = nombre;
    this.peso = peso;
    this.precio = precio;
    this.existencias = existencias;
  }


  @Override
  public String toString() {
    return "Producto [nombre=" + nombre + ", peso=" + peso + ", precio=" + precio + ", existencias="
        + existencias + "]";
  }


  public String getNombre() {
    return nombre;
  }


  public double getPeso() {
    return peso;
  }


  public double getPrecio() {
    return precio;
  }


  public int getExistencias() {
    return existencias;
  }



}
