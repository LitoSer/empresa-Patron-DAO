
package modelo.entidades;

import java.util.List;


public interface Empresa extends Entidad{

    String getCIF();

    String getDireccion();

    String getNombre();

    void setCIF(String DNI);

    void setDireccion(String direccion);

    void setNombre(String nombre);

    List<Producto> getProducto();

    void setProducto(List<Producto> facturas);

    void addProducto(Producto factura);

    void removeProducto(Producto factura);
}
