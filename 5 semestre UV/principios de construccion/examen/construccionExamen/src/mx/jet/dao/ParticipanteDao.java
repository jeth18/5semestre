package mx.jet.dao;

import mx.jet.dominio.Participante;

public class ParticipanteDao implements IparticipanteDao {

  @Override
  public boolean registrarPartcipante(Participante participante) {
    System.out.println("Se agrego participante");
    return true;
  }

}
