package datos;

import java.util.List;
import tienda.Producto;

public interface RepositorioInterface {
  public void guardar(Producto producto);

  public List<Producto> regresarProductos();
}
