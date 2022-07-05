

package controlador;

import java.util.List;
import modelo.entidades.EmpresaImpl;
import modelo.EmpresaModel;
import modelo.entidades.Empresa;
import vista.empresa.EmpresaView;

public class EmpresaControllerImpl extends AbstractControllerImpl<EmpresaModel, EmpresaView, String> implements EmpresaController{
    
    @Override
    protected Empresa generaEntidad(List<String> datos){
        String CIF=datos.get(0);
        String nombre=datos.get(1);
        String direccion=datos.get(2);
        Empresa c=new EmpresaImpl(CIF);
        c.setNombre(nombre);
        c.setDireccion(direccion);
        return c;

    }
    @Override
    protected Empresa generaEntidad(String pk){
        return new EmpresaImpl(pk);
    }

    @Override
    public List<Empresa> listaEmpresaEntidadGesture (){
        return getModel().listar();
    }
    
}
