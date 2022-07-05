
package vista.producto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.entidades.Producto;


public class ProductoTableModel implements TableModel {

    private List<Producto> producto = new ArrayList<Producto>();
    private List<TableModelListener> tableListeners = new ArrayList<TableModelListener>();
    private static final int IVA = 10;

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedTableModel();
    }
    //--------------- MÉTODOS PROPIOS DE TableModel -------------------------

    public Producto getRow(int indexRow) {
        return producto.get(indexRow);
    }

    public int getRowCount() {
        return producto.size();
    }

    public int getColumnCount() {
        return 3; //ya que tendremos tres valores a mostrar por contacto
    }

    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "Identificador";
                break;
            case 1:
                name = "Empresa";
                break;
            case 2:
                name = "Importe";
                break;

        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        Class c = null;
        switch (columnIndex) {
            case 0:
                c = String.class;
                break;
            case 1:
                c = String.class;//pondré sólo el nombre del cliente
                break;
            case 2:
                c = Double.class;
                break;
        }
        return c;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No permito editar celdas
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto productos = producto.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = productos.getIdentificador();
                break;
            case 1:
                value = productos.getEmpresa().getCIF();
                break;
            case 2:
                value = productos.getImporte();
                break;
        }
        return value;

    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTableModelListener(TableModelListener l) {
        tableListeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
        tableListeners.remove(l);
    }

    protected void fireContentsChangedTableModel() {

        TableModelEvent event = new TableModelEvent(this, 0, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (TableModelListener listener : tableListeners) {
            listener.tableChanged(event);
        }
    }

}
