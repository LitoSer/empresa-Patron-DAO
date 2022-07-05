
package modelo;

import java.util.List;
import modelo.persistencia.GenericDAO;
import modelo.persistencia.JDBC.ProductoDAOJDBC;
import controlador.ProductoController;
import modelo.entidades.Producto;
import modelo.persistencia.ProductoDAO;


public class ProductoModelImpl extends AbstractModelImpl<ProductoController, Producto, String> implements ProductoModel {

    //Aqui es donde tendria que añadir los nuevos metodos que quisiera como la peor venta, mejor venta y el importe medio
    protected GenericDAO obtenerImplementacionDAO() {
        return new ProductoDAOJDBC();
       
    }

    public List<Producto> listarPorEmpresa(String nombre) {
        ProductoDAO dao = (ProductoDAO) obtenerImplementacionDAO();
        return dao.listByEmpresa(nombre);
    }

    @Override
    public double minimoProducto() {
        ProductoDAO dao = (ProductoDAO) obtenerImplementacionDAO();
        return dao.getMinProducto();
    }

    @Override
    public double mediaProducto() {
        ProductoDAO dao = (ProductoDAO) obtenerImplementacionDAO();
        return dao.getMediaProducto();
    }

    @Override
    public double maximoProducto() {
        ProductoDAO dao = (ProductoDAO) obtenerImplementacionDAO();
        return dao.getMaxProducto();
    }

}
