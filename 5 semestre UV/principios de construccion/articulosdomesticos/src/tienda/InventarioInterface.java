package tienda;

import java.util.List;

public interface InventarioInterface {
  public void guardar(Producto producto);

  public List<Producto> regresarProductos();
}
