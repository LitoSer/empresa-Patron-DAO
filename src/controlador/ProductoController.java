

package controlador;

import java.io.Serializable;
import java.util.List;
import modelo.ProductoModel;
import modelo.entidades.Producto;
import vista.producto.ProductoView;



public interface ProductoController extends Controller<ProductoModel, ProductoView, Serializable>{
    
    public List<Producto> listaProductoEntidadGesture();
    public List<Producto> listarProductoEntidadPorEmpresaGesture(String nombre);

    public double minimoEntidadGesture();

    public double mediaEntidadGesture();

    public double maximoEntidadGesture();

}
