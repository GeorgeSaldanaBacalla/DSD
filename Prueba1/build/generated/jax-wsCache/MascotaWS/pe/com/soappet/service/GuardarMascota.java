
package pe.com.soappet.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para guardarMascota complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="guardarMascota">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mascota" type="{http://service.soappet.com.pe/}mascota" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guardarMascota", propOrder = {
    "mascota"
})
public class GuardarMascota {

    protected Mascota mascota;

    /**
     * Obtiene el valor de la propiedad mascota.
     * 
     * @return
     *     possible object is
     *     {@link Mascota }
     *     
     */
    public Mascota getMascota() {
        return mascota;
    }

    /**
     * Define el valor de la propiedad mascota.
     * 
     * @param value
     *     allowed object is
     *     {@link Mascota }
     *     
     */
    public void setMascota(Mascota value) {
        this.mascota = value;
    }

}
