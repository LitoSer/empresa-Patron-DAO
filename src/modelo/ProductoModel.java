

package modelo;


import java.util.List;
import controlador.ProductoController;
import modelo.entidades.Producto;

public interface ProductoModel extends Model<ProductoController,Producto,String>{
    List<Producto> listarPorEmpresa(String nombre);

    public double minimoProducto();

    public double mediaProducto();

    public double maximoProducto();

}
