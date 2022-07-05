

package modelo.entidades;


public interface Producto extends Entidad{

    Empresa getEmpresa();

    String getIdentificador();

    Double getImporte();

    void setImporte(Double importe);



}
