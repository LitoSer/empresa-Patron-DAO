

package controlador;

import java.io.Serializable;
import java.util.List;
import modelo.entidades.ProductoImpl;
import modelo.ProductoModel;
import modelo.entidades.Empresa;
import modelo.entidades.Producto;
import vista.producto.ProductoView;


public class ProductoControllerImpl extends AbstractControllerImpl<ProductoModel, ProductoView, Serializable> implements ProductoController{
    
    @Override
    protected Producto generaEntidad(List<Serializable> datos){
        String identificador=(String)datos.get(0);
        Empresa cliente=(Empresa)datos.get(1);
        Double importe=new Double((String)datos.get(2));
        Producto f=new ProductoImpl(identificador,cliente);
        f.setImporte(importe);
        
        return f;

    }
    @Override
    protected Producto generaEntidad(Serializable pk){
        return new ProductoImpl((String)pk);
    }

    @Override
    public List<Producto> listaProductoEntidadGesture() {
        return getModel().listar();
    }

    @Override
    public List<Producto> listarProductoEntidadPorEmpresaGesture(String nombre) {
        return getModel().listarPorEmpresa(nombre);
    }

    @Override
    public double minimoEntidadGesture() {
        return getModel().minimoProducto();
    }

    @Override
    public double mediaEntidadGesture() {
        return getModel().mediaProducto();
    }

    @Override
    public double maximoEntidadGesture() {
        return getModel().maximoProducto();
    }

}
