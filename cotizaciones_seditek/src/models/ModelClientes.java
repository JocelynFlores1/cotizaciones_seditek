/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelClientes {

    
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
    
    private String id_cliente;
    private String nombre_cliente;
    private String apellido_paterno;
    private String apellido_materno;
    private String telefono_cliente;
    private String telefono_empresa;
    private String email_cliente;
    private String rfc_cliente;
    private String calle_cliente;
    private String colonia_cliente;
    private String municipio_cliente;
    private String empresa_cliente;
    private int cp_cliente;
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
    
    
  
    public String getId_cliente() {
        return id_cliente;
    }


    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }


    public String getNombre_cliente() {
        return nombre_cliente;
    }


    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }


    public String getApellido_paterno() {
        return apellido_paterno;
    }


    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }


    public String getApellido_materno() {
        return apellido_materno;
    }


    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }


    public String getTelefono_cliente() {
        return telefono_cliente;
    }


    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }


    public String getTelefono_empresa() {
        return telefono_empresa;
    }


    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }


    public String getEmail_cliente() {
        return email_cliente;
    }


    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }


    public String getRfc_cliente() {
        return rfc_cliente;
    }


    public void setRfc_cliente(String rfc_cliente) {
        this.rfc_cliente = rfc_cliente;
    }

    public String getCalle_cliente() {
        return calle_cliente;
    }


    public void setCalle_cliente(String calle_cliente) {
        this.calle_cliente = calle_cliente;
    }


    public String getColonia_cliente() {
        return colonia_cliente;
    }


    public void setColonia_cliente(String colonia_cliente) {
        this.colonia_cliente = colonia_cliente;
    }


    public String getMunicipio_cliente() {
        return municipio_cliente;
    }


    public void setMunicipio_cliente(String municipio_cliente) {
        this.municipio_cliente = municipio_cliente;
    }

    
    public String getEmpresa_cliente() {
        return empresa_cliente;
    }

    
    public void setEmpresa_cliente(String empresa_cliente) {
        this.empresa_cliente = empresa_cliente;
    }

    
    public int getCp_cliente() {
        return cp_cliente;
    }

   
    public void setCp_cliente(int cp_cliente) {
        this.cp_cliente = cp_cliente;
    }
    
    
    
    
    public void modificarDatos() {
        try {
            System.out.println("modificar datos variables 1 clientes");
            setId_cliente(rs.getString(1));
            setNombre_cliente(rs.getString(2));
            setApellido_paterno(rs.getString(3));
            setApellido_materno(rs.getString(4));
            setTelefono_cliente(rs.getString(5));
            setTelefono_empresa(rs.getString(6));
            setEmail_cliente(rs.getString(7));
            setRfc_cliente(rs.getString(8));
            setCalle_cliente(rs.getString(9));
            setColonia_cliente(rs.getString(10));
            setMunicipio_cliente(rs.getString(11));
            setEmpresa_cliente(rs.getString(12));
            setCp_cliente(rs.getInt(13));
            
            
        } catch (SQLException e) {
            System.out.println("Error 01: modificar datos" + e);
        }
    }
    
    
    /**
     * Método que realiza las siguietnes acciones: 
     * 1.- Conecta con la base 
     * 2.- Consulta todo los registros .
     **/
    public void conectarDB(ModelConexion clienteConexion) {
        try {
            System.out.println("Conexion exitosa");
            String consultaString = "select * from Clientes";
            ps = (PreparedStatement) clienteConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();

            if (rs.next()) {
                modificarDatos();
            } else {
                System.out.println("Error de consulta");
            }
        } catch (SQLException e) {
            System.out.println("Error 02: tabla Clientes" + e);
        }
    }
    
    
    public void insertarNuevoCliente(ModelConexion clienteConexion) {
        System.out.println("nuevo  3 Clientes");
        String sqlInsertarCliente = "INSERT into Clientes(id_cliente,nombre_cliente,apellido_paterno,apellido_materno,"
                + "telefono_cliente,telefono_empresa,email_cliente,rfc_cliente,calle_cliente,colonia_cliente,municipio_cliente,"
                + "empresa_cliente,cp_cliente) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            ps = (PreparedStatement) clienteConexion.getConexion().prepareStatement(sqlInsertarCliente); //con este comando se podra hacer la modificacion a la tabla en la base de datos
            System.out.println(getId_cliente());
            
            ps.setString(1, getId_cliente());
            
            ps.setString(2, getNombre_cliente());
            ps.setString(3, getApellido_paterno());
            ps.setString(4, getApellido_materno());
            ps.setString(5, getTelefono_cliente());
            ps.setString(6, getTelefono_empresa());
            ps.setString(7, getEmail_cliente());
            ps.setString(8, getRfc_cliente());
            ps.setString(9, getCalle_cliente());
            ps.setString(10, getColonia_cliente());
            ps.setString(11, getMunicipio_cliente());
            ps.setString(12,getEmpresa_cliente());
            ps.setInt(13,getCp_cliente());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 03: Insertar nuevo cliente" + ex);
        }
    }
    
    
    
    public void modificarDatosCliente(ModelConexion clienteConexion) {
        System.out.println("modificar 4 cliente");
        String sqlModificarCliente = "UPDATE Clientes SET nombre_cliente=?, apellido_paterno=?, apellido_materno=?, telefono_cliente=?, telefono_empresa=?, "
                    + "email_cliente=?, rfc_cliente=?, calle_cliente=?, colonia_cliente=?, municipio_cliente=?,"
                + "empresa_cliente=?, cp_cliente=? WHERE id_cliente=?;";
        try {

            ps = (PreparedStatement) clienteConexion.getConexion().prepareStatement(sqlModificarCliente);

            System.out.println(getId_cliente());
            
            
            ps.setString(1, getNombre_cliente());
            ps.setString(2, getApellido_paterno());
            ps.setString(3, getApellido_materno());
            ps.setString(4, getTelefono_cliente());
            ps.setString(5, getTelefono_empresa());
            ps.setString(6, getEmail_cliente());
            ps.setString(7, getRfc_cliente());
            ps.setString(8, getCalle_cliente());
            ps.setString(9, getColonia_cliente());
            ps.setString(10, getMunicipio_cliente());
            ps.setString(11,getEmpresa_cliente());
            ps.setInt(12,getCp_cliente());
            ps.setString(13, getId_cliente());
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error 04: Modificar datos cliente" + ex);
        }
    }
    
    
    public void borrarDatosCliente(ModelConexion clienteConexion) {
        System.out.println("eliminar 5 cliente");
        String sqlBorrarCliente = "DELETE FROM Clientes WHERE id_cliente= ?;";
        try {

            ps = (PreparedStatement) clienteConexion.getConexion().prepareStatement(sqlBorrarCliente);
            //Este proceso permite establecer la conexion del objeto creado y enlazar la consulta con la base de datos para poder borrar el producto.
            ps.setString(1, getId_cliente());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 05: Borrar datos cliente" + ex);
        }
    }
    
    
    /**
     * *
     * Metodo que permite insertar los datos de la tabla de la base de datos en
     * un jTable en java
     */
    public void consultajTableCliente(ModelConexion clienteConexion) {
        try {
            System.out.println("tabla 6 cliente");
            String consultaString = "select * from Clientes";
            ps = (PreparedStatement) clienteConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error 000000: tabla cliente" + e);
        }
    }
    
    
    
        public void consultaGenerarCodigos(ModelConexion productoConexion) {
        System.out.println("codigos 7 cliente");
        String SQL = "select max(id_cliente) from Clientes";

        try {
            ps = (PreparedStatement) productoConexion.getConexion().prepareStatement(SQL);
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
