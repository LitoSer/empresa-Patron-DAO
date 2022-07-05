

package modelo.entidades;

import java.util.ArrayList;
import java.util.List;

public class EmpresaImpl implements Empresa {
    private String nombre;
    private String CIF;
    private String direccion;
    private List<Producto> producto;

    public EmpresaImpl(String CIF) {
        this(CIF,null,null);
    }

    public EmpresaImpl(String CIF, String nombre, String direccion) {
        this.CIF = CIF;
        this.nombre = nombre;
        this.direccion = direccion;
        this.producto=new ArrayList();
    }


    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addProducto(Producto producto){
        this.producto.add(producto);
    }

    public void removeProducto(Producto producto){
        this.producto.remove(producto);
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpresaImpl other = (EmpresaImpl) obj;
        if ((this.CIF == null) ? (other.CIF != null) : !this.CIF.equals(other.CIF)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.CIF != null ? this.CIF.hashCode() : 0);
        return hash;
    }

    public String toString(){
        return getNombre();
    }



}
