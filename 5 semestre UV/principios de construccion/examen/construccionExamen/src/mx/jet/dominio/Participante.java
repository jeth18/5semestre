package mx.jet.dominio;

public class Participante {

  private String nombre;
  private String matricula;
  private String carrera;
  private String edad;



  public Participante(String nombre, String matricula, String carrera, String edad) {
    this.nombre = nombre;
    this.matricula = matricula;
    this.carrera = carrera;
    this.edad = edad;
  }

  @Override
  public String toString() {
    return "Participante [nombre=" + nombre + ", matricula=" + matricula + ", carrera=" + carrera
        + ", edad=" + edad + "]";
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  public String getEdad() {
    return edad;
  }

  public void setEdad(String edad) {
    this.edad = edad;
  }



}
