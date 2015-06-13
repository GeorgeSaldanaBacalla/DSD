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
public class MyExceptionBean {
    private String mensaje;
    
    public MyExceptionBean(){
        
    }
    
    public MyExceptionBean(String mensaje){
        this.mensaje = mensaje;
    }
    
    public String getMensaje(){
        return mensaje;
    }
}
