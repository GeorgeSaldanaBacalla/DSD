/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.dominio;

import javax.ws.rs.ext.Provider;
import javax.xml.ws.WebFault;

/**
 *
 * @author Administrador
 */

public class MyCitaException extends Exception{
    private MyCitaExceptionBean faultBean;
 
    public MyCitaException(String message, MyCitaExceptionBean faultInfo){
        super(message);
        faultBean = faultInfo;
    }
 
    public MyCitaException(String message, MyCitaExceptionBean faultInfo, Throwable cause) {
        super(message, cause);
        faultBean = faultInfo;
    }
 
    public MyCitaExceptionBean getFaultInfo(){
        return faultBean;
    }
}
