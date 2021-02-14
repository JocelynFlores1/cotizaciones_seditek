package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ModelProveedores {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private String id_proveedor;
    private String nombre_proveedor;
    private int telefono_proveedor;
    private int telefono_contacto;
    private String email_proveedor;
    private String email_contacto;
    private String calle_proveedor;
    private String colonia_proveedor;
    private String municipio_proveedor;
    private String empresa_proveedor;
    private String rfc_proveedor;
    private int cp_proveedor;
    private String u = "";

    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }
    
    public String getId_proveedor() {
        return id_proveedor;
    }


    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }


    public String getNombre_proveedor() {
        return nombre_proveedor;
    }


    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public int getTelefono_proveedor() {
        return telefono_proveedor;
    }


    public void setTelefono_proveedor(int telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }


    public int getTelefono_contacto() {
        return telefono_contacto;
    }


    public void setTelefono_contacto(int telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }


    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }


    public String getEmail_contacto() {
        return email_contacto;
    }


    public void setEmail_contacto(String email_contacto) {
        this.email_contacto = email_contacto;
    }


    public String getCalle_proveedor() {
        return calle_proveedor;
    }


    public void setCalle_proveedor(String calle_proveedor) {
        this.calle_proveedor = calle_proveedor;
    }


    public String getColonia_proveedor() {
        return colonia_proveedor;
    }


    public void setColonia_proveedor(String colonia_proveedor) {
        this.colonia_proveedor = colonia_proveedor;
    }

    public String getMunicipio_proveedor() {
        return municipio_proveedor;
    }


    public void setMunicipio_proveedor(String municipio_proveedor) {
        this.municipio_proveedor = municipio_proveedor;
    }


    public String getEmpresa_proveedor() {
        return empresa_proveedor;
    }


    public void setEmpresa_proveedor(String empresa_proveedor) {
        this.empresa_proveedor = empresa_proveedor;
    }


    public String getRfc_proveedor() {
        return rfc_proveedor;
    }


    public void setRfc_proveedor(String rfc_proveedor) {
        this.rfc_proveedor = rfc_proveedor;
    }


    public int getCp_proveedor() {
        return cp_proveedor;
    }


    public void setCp_proveedor(int cp_proveedor) {
        this.cp_proveedor = cp_proveedor;
    }
    
    
    public void modificarDatos() {
        try {
            System.out.println("modificar datos variables 1 proveedores");
            setId_proveedor(rs.getString(1));
            setNombre_proveedor(rs.getString(2));
            setTelefono_proveedor(rs.getInt(3));
            setTelefono_contacto(rs.getInt(4));
            setEmail_proveedor(rs.getString(5));
            setEmail_contacto(rs.getString(6));
            setCalle_proveedor(rs.getString(7));
            setColonia_proveedor(rs.getString(8));
            setMunicipio_proveedor(rs.getString(9));
            setEmpresa_proveedor(rs.getString(10));
            setRfc_proveedor(rs.getString(11));
            setCp_proveedor(rs.getInt(12));
            
            
        } catch (SQLException e) {
            System.out.println("Error 01: modificar datos" + e);
        }
    }
    
    
    /**
     * Método que realiza las siguietnes acciones: 
     * 1.- Conecta con la base 
     * 2.- Consulta todo los registros .
     **/
    public void conectarDB(ModelConexion proveedorConexion) {
        try {
            System.out.println("consulta 2 proveedores");
            String consultaString = "select * from Proveedor";
            ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();

            if (rs.next()) {
                modificarDatos();
            } else {
                System.out.println("Error de consulta");
            }
        } catch (SQLException e) {
            System.out.println("Error 02: tabla proveedor" + e);
        }
    }
    
    
    /**
     * *
     * Metodo que realiza la insercción de un nuevo usuario en la base de datos,
     * obteniendo las variables que se guardaron en el controller
     *
     */
    public void insertarNuevoProveedor(ModelConexion proveedorConexion) {
        System.out.println("nuevo  3 proveedor");
        String sqlInsertarProveedor = "INSERT into Proveedores(id_proveedor,nombre_proveedor,telefono_proveedor,telefono_contacto,"
                    + "email_proveedor,email_contacto,calle_proveedor,colonia_proveedor,municipio_proveedor,"
                    + "empresa_proveedorr,rfc_proveedor,cp_proveedor) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(sqlInsertarProveedor); //con este comando se podra hacer la modificacion a la tabla en la base de datos
            System.out.println(getId_proveedor());
            ps.setString(1, getId_proveedor());
            ps.setString(2, getNombre_proveedor());
            ps.setInt(3, getTelefono_proveedor());
            ps.setInt(4, getTelefono_contacto());
            ps.setString(5, getEmail_proveedor());
            ps.setString(6, getEmail_contacto());
            ps.setString(7, getCalle_proveedor());
            ps.setString(8, getColonia_proveedor());
            ps.setString(9, getMunicipio_proveedor());
            ps.setString(10, getEmpresa_proveedor());
            ps.setString(11, getRfc_proveedor());
            ps.setInt(12, getCp_proveedor());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 03: Insertar nuevo proveedor" + ex);
        }
    }
    
    
    
        public void modificarDatosProveedor(ModelConexion proveedorConexion) {
            System.out.println("modificar 4 proveedor");
            String sqlModificarProveedor = "UPDATE Proveedores SET nombre_proveedor=?,telefono_proveedor=?,telefono_contacto=?,"
                    + " email_provedor=?,email_contacto=?, calle_proveedor=?,colonia_proveedor=?, "
                    + "municipio_proveedor=?,empresa_proovedor=?, rfc_proveedor=?, cp_proveedor=? WHERE id_proveedores=?;";
            try {

                ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(sqlModificarProveedor);

                System.out.println(getId_proveedor());

                ps.setString(1, getId_proveedor());
                ps.setString(2, getNombre_proveedor());
                ps.setInt(3, getTelefono_proveedor());
                ps.setInt(4, getTelefono_contacto());
                ps.setString(5, getEmail_proveedor());
                ps.setString(6, getEmail_contacto());
                ps.setString(7, getCalle_proveedor());
                ps.setString(8, getColonia_proveedor());
                ps.setString(9, getMunicipio_proveedor());
                ps.setString(10, getEmpresa_proveedor());
                ps.setString(11, getRfc_proveedor());
                ps.setInt(12, getCp_proveedor());

                ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error 04: Modificar datos proveedor" + ex);
        }
    }
    
    
    
    public void borrarDatosProveedor(ModelConexion proveedorConexion) {
        System.out.println("eliminar 5 proveedor");
        String sqlBorrarProveedor = "DELETE FROM Productos WHERE id_proveedor= ?;";
        try {

            ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(sqlBorrarProveedor);
            //Este proceso permite establecer la conexion del objeto creado y enlazar la consulta con la base de datos para poder borrar el producto.
            ps.setString(1, getId_proveedor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 05: Borrar datos proveedor" + ex);
        }
    }
    
    
    /**
     * *
     * Metodo que permite insertar los datos de la tabla de la base de datos en
     * un jTable en java
     */
    public void consultajTableProducto(ModelConexion proveedorConexion) {
        try {
            System.out.println("tabla 6 proveedor");
            String consultaString = "select * from Proveedor";
            ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error 000000: tabla proveedor" + e);
        }
    }
    
    public void consultaGenerarCodigos(ModelConexion proveedorConexion) {
        System.out.println("codigos 7 proveedor");
        String SQL = "select max(id_proveedor) from Proveedor";

        try {
            ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();

            if (rs.next()) {
                u = rs.getString(1);
                System.out.println("madx" + rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }

    }

    public String getU() {
        return u;
    }

    public void setU(String c) {
        this.u= u;
    }
    
    
}
