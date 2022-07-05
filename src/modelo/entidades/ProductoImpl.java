

package modelo.entidades;


public class ProductoImpl implements Producto {
    private String identifiador;
    private Empresa empresa;
    private Double importe;

    public ProductoImpl(String identificador) {
        this(identificador,null,null);
    }


    public ProductoImpl(String identifiador, Empresa empresa) {
        this(identifiador,empresa,null);
    }

    public ProductoImpl(String identifiador, Empresa empresa, Double importe) {
        this.identifiador = identifiador;
        this.empresa = empresa;
        this.importe = importe;
    }


    public Empresa getEmpresa() {
        return empresa;
    }

    public String getIdentificador() {
        return identifiador;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    
      
    
    

}
