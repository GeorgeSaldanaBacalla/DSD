
package pe.com.soappet.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import pe.com.soappet.dominio.Cliente;

@XmlRootElement(name = "obtenerClienteResponse", namespace = "http://service.soappet.com.pe/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerClienteResponse", namespace = "http://service.soappet.com.pe/")
public class ObtenerClienteResponse {

    @XmlElement(name = "return", namespace = "")
    private Cliente _return;

    /**
     * 
     * @return
     *     returns Cliente
     */
    public Cliente getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Cliente _return) {
        this._return = _return;
    }

}
