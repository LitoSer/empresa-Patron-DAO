

package controlador;

import java.util.List;
import modelo.EmpresaModel;
import modelo.entidades.Empresa;
import vista.empresa.EmpresaView;



public interface EmpresaController extends Controller<EmpresaModel, EmpresaView, String>{
    
    public List<Empresa> listaEmpresaEntidadGesture ();
}
