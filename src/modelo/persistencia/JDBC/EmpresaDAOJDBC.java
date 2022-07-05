
package modelo.persistencia.JDBC;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.EmpresaImpl;
import modelo.entidades.Empresa;
import modelo.persistencia.EmpresaDAO;

public class EmpresaDAOJDBC implements EmpresaDAO {

    public void create(Empresa entidad) {

        String sql = "insert into empresa(cif,nombre,direccion) values (?,?,?)";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getCIF());
            stm.setString(2, entidad.getNombre());
            stm.setString(3, entidad.getDireccion());

            stm.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Empresa read(String pk) {
        Empresa c = null;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM empresa where CIF=" + pk);
            String cif, nombre, direccion;
            if (res.next()) {
                cif = res.getString("CIF");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                c = new EmpresaImpl(cif, nombre, direccion);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return c;
    }

    public void update(Empresa entidad) {
        String sql = "update empresa set nombre=?, direccion=? where CIF like ?";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getNombre());
            stm.setString(2, entidad.getDireccion());
            stm.setString(3, entidad.getCIF());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void delete(Empresa entidad) {
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            stmt.executeUpdate("DELETE FROM empresa where CIF='" + entidad.getCIF()+"'");



        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public List<Empresa> list() {
        List<Empresa> contactos = new ArrayList<Empresa>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM empresa ");
            String cif, nombre, direccion;
            while (res.next()) {

                cif = res.getString("CIF");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                contactos.add(new EmpresaImpl(cif, nombre, direccion));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return contactos;
    }
}
