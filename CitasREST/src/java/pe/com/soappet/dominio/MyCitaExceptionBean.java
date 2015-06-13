/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.dominio;

/**
 *
 * @author Administrador
 */
public class MyCitaExceptionBean {
    private String mensaje;
    
    public MyCitaExceptionBean(){
        
    }
    
    public MyCitaExceptionBean(String mensaje){
        this.mensaje = mensaje;
    }
    
    public String getMensaje(){
        return mensaje;
    }
}
