
package main;

import controlador.EmpresaControllerImpl;
import controlador.ProductoControllerImpl;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpresaModelImpl;
import modelo.ProductoModelImpl;
import vista.empresa.EmpresaViewImpl;
import vista.VistaGlobal;
import vista.producto.ProductoViewImpl;
import controlador.EmpresaController;
import controlador.ProductoController;
import modelo.EmpresaModel;
import modelo.ProductoModel;
import vista.empresa.EmpresaView;
import vista.producto.ProductoView;






public class main {


    
    public static void main(String[] args) {

        
        EmpresaModel EmpresaModel = new EmpresaModelImpl();

        
        EmpresaView empresaView1 =new EmpresaViewImpl();
        List<EmpresaView> empresaViews= new ArrayList<EmpresaView>();
        empresaViews.add(empresaView1);


        EmpresaController empresaController = new EmpresaControllerImpl();
        
        empresaController.setup(EmpresaModel, empresaViews);


        
        ProductoModel productoModel = new ProductoModelImpl();


        ProductoView productoView1 =new ProductoViewImpl();
        List<ProductoView> productoViews= new ArrayList<ProductoView>();
        productoViews.add(productoView1);

        ProductoController productoController = new ProductoControllerImpl();

        productoController.setup(productoModel, productoViews);
        

        VistaGlobal vista1=new VistaGlobal(empresaView1,productoView1);
        vista1.display();

    }

}

