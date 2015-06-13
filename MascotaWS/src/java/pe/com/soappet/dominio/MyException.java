/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.dominio;

import javax.xml.ws.WebFault;

/**
 *
 * @author Administrador
 */
@WebFault(name = "MyException")
public class MyException extends Exception{
    private MyExceptionBean faultBean;
 
    public MyException(String message, MyExceptionBean faultInfo){
        super(message);
        faultBean = faultInfo;
    }
 
    public MyException(String message, MyExceptionBean faultInfo, Throwable cause) {
        super(message, cause);
        faultBean = faultInfo;
    }
 
    public MyExceptionBean getFaultInfo(){
        return faultBean;
    }
}
