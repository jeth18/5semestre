package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tienda.Producto;

public class Repositorio implements RepositorioInterface {

  private static final String SEPARADOR_REGISTRO = "\n";
  private static final String SEPARADOR_CAMPO = ":";
  private static final int NUMERO_CAMPOS = 4;
  private String pathRegistros;


  public Repositorio(String pathRegistros) {
    this.pathRegistros = pathRegistros;
  }


  private File abrirArchivo() {
    File resultado = null;
    try {
      resultado = new File(this.pathRegistros);
    } catch (NullPointerException excepcion) {
      excepcion.printStackTrace();
    }
    return resultado;

  }

  @Override
  public void guardar(Producto producto) {
    File archivo = abrirArchivo();
    try {
      FileWriter escritor = new FileWriter(archivo, true);
      BufferedWriter bufferEscritor = new BufferedWriter(escritor);
      String productoString = "";
      productoString += producto.getNombre() + Repositorio.SEPARADOR_CAMPO;
      productoString += producto.getPeso() + Repositorio.SEPARADOR_CAMPO;
      productoString += producto.getPrecio() + Repositorio.SEPARADOR_CAMPO;
      productoString += producto.getExistencias() + Repositorio.SEPARADOR_CAMPO;
      productoString += Repositorio.SEPARADOR_REGISTRO;
      bufferEscritor.write(productoString);
      bufferEscritor.close();

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  private String contenidoArchivo(File archivoTexto) {
    if (archivoTexto == null) {
      return "";
    }
    String resultado = "";
    FileReader lector;
    BufferedReader bufferLector = null;
    try {
      lector = new FileReader(archivoTexto);
      bufferLector = new BufferedReader(lector);
      String lineaActual = bufferLector.readLine();
      while (lineaActual != null) {
        resultado += lineaActual + "\n";
        lineaActual = bufferLector.readLine();
      }

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      return "";
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if (bufferLector != null) {
          bufferLector.close();
        }
      } catch (IOException e) {

        e.printStackTrace();
      }
    }

    return resultado;
  }

  @Override
  public List<Producto> regresarProductos() {
    List<Producto> productos = new ArrayList<Producto>();
    File archivoProductos = abrirArchivo();
    String contenido = contenidoArchivo(archivoProductos);
    if (contenido.equals("")) {
      return productos;
    }
    String[] productosString = contenido.split(Repositorio.SEPARADOR_REGISTRO);
    for (String productoString : productosString) {
      String[] campos = productoString.split(Repositorio.SEPARADOR_CAMPO);
      if (campos.length != Repositorio.NUMERO_CAMPOS) { // al guardar archivos es posible que quede
                                                        // basura al final
        break;
      }
      String nombre = campos[0];
      double peso = Double.parseDouble(campos[1]);
      double precio = Double.parseDouble(campos[2]);
      int existencias = Integer.parseInt(campos[3]);
      Producto producto = new Producto(nombre, peso, precio, existencias);
      productos.add(producto);
    }
    return productos;
  }

}
