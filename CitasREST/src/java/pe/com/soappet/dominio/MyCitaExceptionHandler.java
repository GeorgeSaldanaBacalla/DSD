/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.dominio;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Administrador
 */
@Provider
public class MyCitaExceptionHandler implements ExceptionMapper<MyCitaException>{

    @Override
    public Response toResponse(MyCitaException e) {
        return Response.status(Status.OK).entity(e.getFaultInfo().getMensaje()).build();
    }

}
