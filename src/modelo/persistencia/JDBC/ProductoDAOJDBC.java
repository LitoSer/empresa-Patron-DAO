
package modelo.persistencia.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.EmpresaImpl;
import modelo.entidades.ProductoImpl;
import modelo.entidades.Empresa;
import modelo.entidades.Producto;
import modelo.persistencia.ProductoDAO;


public class ProductoDAOJDBC implements ProductoDAO {

    public List<Producto> listByEmpresa(String cif) {
        List<Producto> producto = new ArrayList<Producto>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM vproducto where CIF=" + cif);
            String nombre, direccion, id_factura;
            Double importe;
            while (res.next()) {
                
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                id_factura = res.getString("identificador");
                importe = res.getDouble("importe");

                
                Empresa empresa = new EmpresaImpl(cif, nombre, direccion);
                
                producto.add(new ProductoImpl(id_factura, empresa, importe));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return producto;
    }

    public void create(Producto entidad) {
        String sql = "insert into producto(identificador,id_empresa,importe) values (?,?,?)";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getIdentificador());
            stm.setString(2, entidad.getEmpresa().getCIF());
            stm.setDouble(3, entidad.getImporte());

            stm.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Producto read(String pk) {
        Producto f = null;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM producto where identificador=" + pk);
            String identificador, id_empresa;
            Double importe;
            if (res.next()) {
                identificador = res.getString("identificador");
                id_empresa = res.getString("id_empresa");
                importe = res.getDouble("importe");
                
                Empresa empresa = (new EmpresaDAOJDBC()).read(id_empresa);
                
                f = new ProductoImpl(identificador, empresa, importe);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return f;
    }

    public void update(Producto entidad) {
        String sql = "update producto set id_empresa=?, importe=? where identificador like ?";

        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(3, entidad.getIdentificador());
            stm.setString(1, entidad.getEmpresa().getCIF());
            stm.setDouble(2, entidad.getImporte());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void delete(Producto entidad) {
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            stmt.executeUpdate("DELETE FROM producto where identificador=" + entidad.getIdentificador());

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public List<Producto> list() {
        List<Producto> producto = new ArrayList<Producto>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM vproducto");
            String CIF, nombre, direccion, id_producto;
            Double importe;
            while (res.next()) {
                CIF = res.getString("DNI");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                id_producto = res.getString("identificador");
                importe = res.getDouble("importe");

                
                Empresa empresa = new EmpresaImpl(CIF, nombre, direccion);
                
                producto.add(new ProductoImpl(id_producto, empresa, importe));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return producto;
    }

    @Override
    public double getMinProducto() {
        double d = 0;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT min(importe) FROM producto");

            res.next();
            d = res.getDouble(1);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return d;

    }
    @Override
    public double getMaxProducto() {
        double d = 0;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT max(importe) FROM producto");

            res.next();
            d = res.getDouble(1);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return d;

    }
    @Override
    public double getMediaProducto() {
        double d = 0;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT AVG(importe) FROM producto");

            res.next();
            d = res.getDouble(1);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return d;

    }
}
