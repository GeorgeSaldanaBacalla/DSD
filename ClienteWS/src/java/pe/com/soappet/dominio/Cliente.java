package pe.com.soappet.dominio;
// Generated 10/06/2015 11:51:45 PM by Hibernate Tools 4.3.1



/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int idcliente;
     private String nombre;
     private String apePaterno;
     private String apeMaterno;
     private String telefono;
     private String celular;
     private String correo;
     private String direccion;
     private String dni;
     private int estado;

    public Cliente() {
    }

	
    public Cliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public Cliente(int idcliente, String nombre, String apePaterno, String apeMaterno, String telefono, String celular, String correo, String direccion) {
       this.idcliente = idcliente;
       this.nombre = nombre;
       this.apePaterno = apePaterno;
       this.apeMaterno = apeMaterno;
       this.telefono = telefono;
       this.celular = celular;
       this.correo = correo;
       this.direccion = direccion;
    }
   
    public int getIdcliente() {
        return this.idcliente;
    }
    
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApePaterno() {
        return this.apePaterno;
    }
    
    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }
    public String getApeMaterno() {
        return this.apeMaterno;
    }
    
    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }




}


