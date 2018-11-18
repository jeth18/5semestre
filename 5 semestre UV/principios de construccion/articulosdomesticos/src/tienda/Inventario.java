package tienda;

import java.util.List;
import datos.RepositorioInterface;

public class Inventario implements InventarioInterface {

  private RepositorioInterface repositorio;
  private List<Producto> productos;
  private static Inventario inventario = null;

  private Inventario(RepositorioInterface repositorio) {
    this.repositorio = repositorio;
    productos = this.repositorio.regresarProductos();
  }

  public static Inventario getInstance(RepositorioInterface repositorio) {
    if (Inventario.inventario == null) {
      Inventario.inventario = new Inventario(repositorio);
    }
    return inventario.inventario;
  }


  @Override
  public void guardar(Producto producto) {
    this.productos.add(producto);
    this.repositorio.guardar(producto);
  }

  @Override
  public List<Producto> regresarProductos() {
    this.productos = repositorio.regresarProductos();
    return this.productos;
  }

}
