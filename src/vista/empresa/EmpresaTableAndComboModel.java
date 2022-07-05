
package vista.empresa;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.entidades.Empresa;


public class EmpresaTableAndComboModel implements TableModel, ComboBoxModel {


    private List<Empresa> empresa = new ArrayList<Empresa>();
    private List<TableModelListener> tableListeners = new ArrayList<TableModelListener>();
    private List<ListDataListener> dataListeners = new ArrayList<ListDataListener>();

    //Implementacion Singleton
    private static EmpresaTableAndComboModel model=null;

    private EmpresaTableAndComboModel(){}

    public static EmpresaTableAndComboModel create(){
        if(model==null)
            model=new EmpresaTableAndComboModel();
        return model;
    }

    public List<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<Empresa> empresa) {
        this.empresa = empresa;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedTableModel();
        fireContentsChangedListData();
    }
    //--------------- MÉTODOS PROPIOS DE TableModel -------------------------

    public Empresa getRow(int indexRow) {
        return empresa.get(indexRow);
    }

    public int getRowCount() {
        return empresa.size();
    }

    public int getColumnCount() {
        return 3; //ya que tendremos tres valores a mostrar por contacto
    }

    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "CIF";
                break;
            case 1:
                name = "Nombre";
                break;
            case 2:
                name = "Direccion";
                break;
        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class; //Todos los valores de contacto son un String
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No permito editar celdas
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Empresa contacto = empresa.get(rowIndex);
        String value = null;
        switch (columnIndex) {
            case 0:
                value = contacto.getCIF();
                break;
            case 1:
                value = contacto.getNombre();
                break;
            case 2:
                value = contacto.getDireccion();
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
    //--------------- MÉTODOS PROPIOS DE ComboBoxModel -------------------------
    private Empresa empresaSelected = null;

    public void setSelectedItem(Object anItem) {
        if (anItem != null) {
            empresaSelected = (Empresa) anItem;
            fireContentsChangedListData();
        }
    }

    public Object getSelectedItem() {
        return empresaSelected;
    }

    public int getSize() {
        return empresa.size();
    }

    public Object getElementAt(int index) {
        return empresa.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }

    protected void fireContentsChangedListData() {
        ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, empresa.size());
        for (ListDataListener l : dataListeners) {
            l.contentsChanged(e);
        }
    }
}
