
package models;

/**
 *
 * @author Carina
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelCotizaciones {
    
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private String id_cotizacion;
    private String numero_cotizacion;
    private String id_usuario;
    private String id_cliente;
    private int telefono;
    private String validez_oferta;
    private String promocion_especial;
    private String condiciones_comerciles;
    private Float fecha_cotizacion;
    
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
     


    public String getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(String id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    public String getNumero_cotizacion() {
        return numero_cotizacion;
    }

    public void setNumero_cotizacion(String numero_cotizacion) {
        this.numero_cotizacion = numero_cotizacion;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getValidez_oferta() {
        return validez_oferta;
    }

    public void setValidez_oferta(String validez_oferta) {
        this.validez_oferta = validez_oferta;
    }

    public String getPromocion_especial() {
        return promocion_especial;
    }

    public void setPromocion_especial(String promocion_especial) {
        this.promocion_especial = promocion_especial;
    }

    public String getCondiciones_comerciles() {
        return condiciones_comerciles;
    }

    public void setCondiciones_comerciles(String condiciones_comerciles) {
        this.condiciones_comerciles = condiciones_comerciles;
    }

    public Float getFecha_cotizacion() {
        return fecha_cotizacion;
    }

    public void setFecha_cotizacion(Float fecha_cotizacion) {
        this.fecha_cotizacion = fecha_cotizacion;
    }
    
    
    
}
