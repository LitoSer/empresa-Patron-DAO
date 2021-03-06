
package vista.producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import vista.AbstractViewImpl;
import vista.empresa.EmpresaTableAndComboModel;
import controlador.ProductoController;
import modelo.ProductoModel;
import modelo.entidades.Empresa;
import modelo.entidades.Producto;

public class ProductoViewImpl extends AbstractViewImpl<ProductoController> implements ProductoView {

    //Atributos propios de Swing
    private ProductoTableModel productoTableModel;
    private ProductoViewImplInternal panelProducto;
    private EmpresaTableAndComboModel empresaComboModel;

    /**
     * Creates new form ClienteViewImpl
     */
    public ProductoViewImpl() {
        productoTableModel = new ProductoTableModel();
        //comboModel = new EmpresaTableAndComboModel();
        empresaComboModel = EmpresaTableAndComboModel.create();
        initComponents();

        this.panelProducto = new ProductoViewImplInternal(this);
        this.jPanelFactura.add(this.panelProducto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jPanelFactura = new javax.swing.JPanel();
        jComboBoxEmpresa = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButtonFiltrar = new javax.swing.JButton();
        jButtonQuitarFiltro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        peorImporte = new javax.swing.JLabel();
        mejorImporte = new javax.swing.JLabel();
        importeMedio = new javax.swing.JLabel();

        jTableProductos.setModel(productoTableModel);
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        jPanelFactura.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelFactura.setLayout(new javax.swing.BoxLayout(jPanelFactura, javax.swing.BoxLayout.LINE_AXIS));

        jComboBoxEmpresa.setModel(empresaComboModel);

        jLabel1.setText("Cliente");

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jButtonQuitarFiltro.setText("QuitarFiltro");
        jButtonQuitarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarFiltroActionPerformed(evt);
            }
        });

        jLabel2.setText("Peor importe:");

        jLabel3.setText("Mejor importe:");

        jLabel4.setText("Importe medio:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jButtonFiltrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonQuitarFiltro)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(peorImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(mejorImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(importeMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(peorImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mejorImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importeMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFiltrar)
                            .addComponent(jButtonQuitarFiltro))))
                .addGap(18, 18, 18)
                .addComponent(jPanelFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        ProductoTableModel ctm = (ProductoTableModel) this.jTableProductos.getModel();
        Producto factura = ctm.getRow(this.jTableProductos.getSelectedRow());
        panelProducto.setProducto(factura);
    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        EmpresaTableAndComboModel ccm = (EmpresaTableAndComboModel) this.jComboBoxEmpresa.getModel();
        Empresa cliente = ccm.getRow(this.jComboBoxEmpresa.getSelectedIndex());
        List<Producto> facturas = getController().listarProductoEntidadPorEmpresaGesture(cliente.getCIF());
        productoTableModel.setProducto(facturas);
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonQuitarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarFiltroActionPerformed
        refresh();
    }//GEN-LAST:event_jButtonQuitarFiltroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel importeMedio;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonQuitarFiltro;
    private javax.swing.JComboBox jComboBoxEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelFactura;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JLabel mejorImporte;
    private javax.swing.JLabel peorImporte;
    // End of variables declaration//GEN-END:variables

    protected EmpresaTableAndComboModel getComboModel() {
        return empresaComboModel;
    }

    public void refresh() {
        productoTableModel.setProducto(getController().listaProductoEntidadGesture());//cambia el modelo de JTable(TableModel) por medio de una clase que hemos creado (ContactosTableModel)
        peorImporte.setText("" + fireMinimoProductoGesture());
        mejorImporte.setText("" + fireMaximoProductoGesture());
        importeMedio.setText("" + fireMediaProductoGesture());

    }

    protected void fireNuevaProductoGesture(String identificador, Empresa empresa, String importe) {
        List<Serializable> datos = new ArrayList<Serializable>();
        datos.add(identificador);
        datos.add(empresa);
        datos.add(importe);
        getController().nuevaEntidadGesture(datos);
    }

    protected void fireActualizaFacturaGesture(String identificador, Empresa empresa, String importe) {
        List<Serializable> datos = new ArrayList<Serializable>();
        datos.add(identificador);
        datos.add(empresa);
        datos.add(importe);
        getController().actualizaEntidadGesture(datos);
    }

    protected void fireBorraProductoGesture(String identificador) {
        getController().borraEntidadGesture(identificador);
    }

    protected double fireMinimoProductoGesture() {
        double d = 0;
        return d = getController().minimoEntidadGesture();
    }

    protected double fireMaximoProductoGesture() {
        double d = 0;
        return d = getController().maximoEntidadGesture();
    }

    protected double fireMediaProductoGesture() {
        double d = 0;
        return d = getController().mediaEntidadGesture();
    }
}
