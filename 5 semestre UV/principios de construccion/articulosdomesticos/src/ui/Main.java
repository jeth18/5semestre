package ui;

import java.util.List;
import java.util.Scanner;
import datos.Repositorio;
import datos.RepositorioInterface;
import tienda.Inventario;
import tienda.InventarioInterface;
import tienda.Producto;

public class Main {
  InventarioInterface inventario;

  public Main(InventarioInterface inventario) {
    this.inventario = inventario;
  }


  private void imprimirMenu() {
    String menuOpciones = "";
    menuOpciones = "      SISTEMA DE MANEJO DE PRODUCTOS DOMÉSTICOS   \n";
    menuOpciones += "Opciones:\n";
    menuOpciones += "1) Guardar Producto";
    menuOpciones += "2) Ver lista de productos";
    menuOpciones += "3) Salir";
    System.out.println(menuOpciones);
  }

  private void guardar() {
    Scanner lector = new Scanner(System.in);
    System.out.println("Especifica nombre del producto:");
    String nombre = lector.nextLine();
    System.out.println("Especifica peso del producto:");
    double peso = lector.nextDouble();
    System.out.println("Especifica precio del producto:");
    double precio = lector.nextDouble();
    System.out.println("Especifica existencias del producto:");
    int existencias = lector.nextInt();
    Producto producto = new Producto(nombre, peso, precio, existencias);
    this.inventario.guardar(producto);
  }

  private void verProductos() {
    List<Producto> productos = this.inventario.regresarProductos();
    for (Producto producto : productos) {
      System.out.println(producto);
    }
  }

  private void salir() {
    System.exit(0);
  }

  public static void main(String[] args) {

    RepositorioInterface repositorio = new Repositorio(args[0]);
    InventarioInterface inventario = Inventario.getInstance(repositorio);
    Main main = new Main(inventario);
    Scanner scanner = new Scanner(System.in);

    int opcion = 0;
    while (true) {
      main.imprimirMenu();
      opcion = scanner.nextInt();
      switch (opcion) {
        case 1:
          main.guardar();
          break;
        case 2:
          main.verProductos();
          break;
        case 3:
          main.salir();
          break;
        default:
          break;
      }
    }

  }

}
