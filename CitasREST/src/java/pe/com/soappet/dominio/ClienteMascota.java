/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.dominio;

import java.io.Serializable;
import java.util.List;
import pe.com.soappet.service.Cliente;
import pe.com.soappet.service.Mascota;

/**
 *
 * @author Administrador
 */
public class ClienteMascota implements Serializable{
    private Cliente cliente;
    private List<Mascota> listaMascotas;

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the listaMascotas
     */
    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    /**
     * @param listaMascotas the listaMascotas to set
     */
    public void setListaMascotas(List<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }
}
