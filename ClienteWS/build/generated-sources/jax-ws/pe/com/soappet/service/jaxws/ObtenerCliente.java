
package pe.com.soappet.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenerCliente", namespace = "http://service.soappet.com.pe/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerCliente", namespace = "http://service.soappet.com.pe/")
public class ObtenerCliente {

    @XmlElement(name = "dni", namespace = "")
    private String dni;

    /**
     * 
     * @return
     *     returns String
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * 
     * @param dni
     *     the value for the dni property
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

}
