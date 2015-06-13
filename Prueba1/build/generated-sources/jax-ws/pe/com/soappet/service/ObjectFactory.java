
package pe.com.soappet.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.com.soappet.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ObtenerListadoMascotas_QNAME = new QName("http://service.soappet.com.pe/", "obtenerListadoMascotas");
    private final static QName _EliminarMascota_QNAME = new QName("http://service.soappet.com.pe/", "eliminarMascota");
    private final static QName _GuardarMascotaResponse_QNAME = new QName("http://service.soappet.com.pe/", "guardarMascotaResponse");
    private final static QName _ObtenerListadoMascotasResponse_QNAME = new QName("http://service.soappet.com.pe/", "obtenerListadoMascotasResponse");
    private final static QName _GuardarMascota_QNAME = new QName("http://service.soappet.com.pe/", "guardarMascota");
    private final static QName _EliminarMascotaResponse_QNAME = new QName("http://service.soappet.com.pe/", "eliminarMascotaResponse");
    private final static QName _MyException_QNAME = new QName("http://service.soappet.com.pe/", "MyException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.com.soappet.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerListadoMascotasResponse }
     * 
     */
    public ObtenerListadoMascotasResponse createObtenerListadoMascotasResponse() {
        return new ObtenerListadoMascotasResponse();
    }

    /**
     * Create an instance of {@link GuardarMascotaResponse }
     * 
     */
    public GuardarMascotaResponse createGuardarMascotaResponse() {
        return new GuardarMascotaResponse();
    }

    /**
     * Create an instance of {@link ObtenerListadoMascotas }
     * 
     */
    public ObtenerListadoMascotas createObtenerListadoMascotas() {
        return new ObtenerListadoMascotas();
    }

    /**
     * Create an instance of {@link EliminarMascota }
     * 
     */
    public EliminarMascota createEliminarMascota() {
        return new EliminarMascota();
    }

    /**
     * Create an instance of {@link MyExceptionBean }
     * 
     */
    public MyExceptionBean createMyExceptionBean() {
        return new MyExceptionBean();
    }

    /**
     * Create an instance of {@link GuardarMascota }
     * 
     */
    public GuardarMascota createGuardarMascota() {
        return new GuardarMascota();
    }

    /**
     * Create an instance of {@link EliminarMascotaResponse }
     * 
     */
    public EliminarMascotaResponse createEliminarMascotaResponse() {
        return new EliminarMascotaResponse();
    }

    /**
     * Create an instance of {@link Mascota }
     * 
     */
    public Mascota createMascota() {
        return new Mascota();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerListadoMascotas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "obtenerListadoMascotas")
    public JAXBElement<ObtenerListadoMascotas> createObtenerListadoMascotas(ObtenerListadoMascotas value) {
        return new JAXBElement<ObtenerListadoMascotas>(_ObtenerListadoMascotas_QNAME, ObtenerListadoMascotas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarMascota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "eliminarMascota")
    public JAXBElement<EliminarMascota> createEliminarMascota(EliminarMascota value) {
        return new JAXBElement<EliminarMascota>(_EliminarMascota_QNAME, EliminarMascota.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarMascotaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "guardarMascotaResponse")
    public JAXBElement<GuardarMascotaResponse> createGuardarMascotaResponse(GuardarMascotaResponse value) {
        return new JAXBElement<GuardarMascotaResponse>(_GuardarMascotaResponse_QNAME, GuardarMascotaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerListadoMascotasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "obtenerListadoMascotasResponse")
    public JAXBElement<ObtenerListadoMascotasResponse> createObtenerListadoMascotasResponse(ObtenerListadoMascotasResponse value) {
        return new JAXBElement<ObtenerListadoMascotasResponse>(_ObtenerListadoMascotasResponse_QNAME, ObtenerListadoMascotasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarMascota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "guardarMascota")
    public JAXBElement<GuardarMascota> createGuardarMascota(GuardarMascota value) {
        return new JAXBElement<GuardarMascota>(_GuardarMascota_QNAME, GuardarMascota.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarMascotaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "eliminarMascotaResponse")
    public JAXBElement<EliminarMascotaResponse> createEliminarMascotaResponse(EliminarMascotaResponse value) {
        return new JAXBElement<EliminarMascotaResponse>(_EliminarMascotaResponse_QNAME, EliminarMascotaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyExceptionBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "MyException")
    public JAXBElement<MyExceptionBean> createMyException(MyExceptionBean value) {
        return new JAXBElement<MyExceptionBean>(_MyException_QNAME, MyExceptionBean.class, null, value);
    }

}
