
package vista.empresa;

import vista.AbstractViewImpl;
import java.util.ArrayList;
import java.util.List;
import controlador.EmpresaController;
import modelo.EmpresaModel;
import modelo.entidades.Empresa;


public class EmpresaViewImpl extends AbstractViewImpl<EmpresaController> implements EmpresaView {

    
    private EmpresaTableAndComboModel tableModel;
    private EmpresaViewImplInternal panelCliente;

    
    public EmpresaViewImpl() {
        
        tableModel = EmpresaTableAndComboModel.create();
        initComponents();

        this.panelCliente = new EmpresaViewImplInternal(this);
        this.jPanelCliente.add(this.panelCliente);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jPanelCliente = new javax.swing.JPanel();

        jTableClientes.setModel(tableModel);
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jPanelCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCliente.setLayout(new javax.swing.BoxLayout(jPanelCliente, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        EmpresaTableAndComboModel ctm = (EmpresaTableAndComboModel) this.jTableClientes.getModel();
        Empresa contacto = ctm.getRow(this.jTableClientes.getSelectedRow());
        panelCliente.setContacto(contacto);
    }//GEN-LAST:event_jTableClientesMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration//GEN-END:variables

    public void refresh() {
        tableModel.setEmpresa(getController().listaEmpresaEntidadGesture());//cambia el modelo de JTable(TableModel) por medio de una clase que hemos creado (ContactosTableModel)
    }

    protected void fireNuevoEmpresaGesture(String CIF, String nombre, String direccion) {
        List<String> datos = new ArrayList<String>();
        datos.add(CIF);
        datos.add(nombre);
        datos.add(direccion);
        getController().nuevaEntidadGesture(datos);
    }

    protected void fireActualizaEmpresaGesture(String CIF, String nombre, String direccion) {
        List<String> datos = new ArrayList<String>();
        datos.add(CIF);
        datos.add(nombre);
        datos.add(direccion);
        getController().actualizaEntidadGesture(datos);        
    }

    protected void fireBorraEmpresaGesture(String nombre) {
        getController().borraEntidadGesture(nombre);
    }
}
