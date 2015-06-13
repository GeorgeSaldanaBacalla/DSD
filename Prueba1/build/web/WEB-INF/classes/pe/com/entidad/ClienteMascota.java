/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ClienteMascota {
    private Cliente cliente;
    private List<Mascota> listaMascotas = new ArrayList<>();

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
     * @return the mascota
     */
    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    /**
     * @param mascota the mascota to set
     */
    public void setListaMascotas(List<Mascota> mascota) {
        this.listaMascotas = mascota;
    }

  
}
