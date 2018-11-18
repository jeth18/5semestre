package application;

public class Producto {
  
  private String nombre;
  private String peso;
  private String precio;
  private String existencias;
  private String marca;
  
  Producto (String nombre,String peso,String precio,String existencias, String marca) {
    this.nombre = nombre;
    this.peso = peso;
    this.precio = precio;
    this.existencias = existencias;
    this.marca = marca;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPeso() {
    return peso;
  }

  public void setPeso(String peso) {
    this.peso = peso;
  }

  public String getPrecio() {
    return precio;
  }

  public void setPrecio(String precio) {
    this.precio = precio;
  }

  public String getExistencias() {
    return existencias;
  }

  public void setExistencias(String existencia) {
    this.existencias = existencia;
  }
  
  public String getMarca() {
    return marca;
  }
  
  public void setMarca(String marca) {
    this.marca = marca;
  }
  
}
