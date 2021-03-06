package mx.jet.dominio;

public class Bicicleta {

  private String noSerie;
  private String modelo;
  private String color;

  public Bicicleta(String noSerie, String modelo, String color) {
    super();
    this.noSerie = noSerie;
    this.modelo = modelo;
    this.color = color;
  }

  @Override
  public String toString() {
    return "Bicicleta [noSerie=" + noSerie + ", modelo=" + modelo + ", color=" + color + "]";
  }


}
