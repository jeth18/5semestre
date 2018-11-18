package mx.jet.dao;

import mx.jet.dominio.Corredor;

public class Registro {

  public void verRegistro() {

  }

  /*
   * En este metodo se le asigna una bicicleta al un participante
   * 
   * @param matriculaPar matricula del partcipante
   * 
   * @param noSerieBici numero de serire de bicicleta
   */
  public boolean asignarBicicleta(String matriculaPart, String noSerieBici) {
    boolean asignado = false;
    Corredor corredor = new Corredor(noSerieBici, noSerieBici);

    agregarParticipante(corredor);

    return asignado;
  }


  /*
   * En este metodo agrega el participante
   * 
   * @param corredor es el corredor con la bicicleta ya dada
   */
  public void agregarParticipante(Corredor corredor) {
    // lo agrega a la base de datos
  }
}
