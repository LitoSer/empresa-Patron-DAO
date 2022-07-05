package modelo.persistencia;


import java.util.List;
import modelo.entidades.Producto;

public interface ProductoDAO extends GenericDAO<Producto, String> {

    List<Producto> listByEmpresa(String nombre);
      double getMinProducto();
      double getMaxProducto();
      double getMediaProducto();
}
