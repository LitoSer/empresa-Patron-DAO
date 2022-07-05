

package modelo;

import modelo.persistencia.GenericDAO;
import modelo.persistencia.JDBC.EmpresaDAOJDBC;
import controlador.EmpresaController;
import modelo.entidades.Empresa;


public class EmpresaModelImpl extends AbstractModelImpl<EmpresaController,Empresa,String> implements EmpresaModel{

    protected GenericDAO obtenerImplementacionDAO(){
        return new EmpresaDAOJDBC();
        
    }

}
