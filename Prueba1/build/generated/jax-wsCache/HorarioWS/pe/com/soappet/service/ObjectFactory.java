
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

    private final static QName _ObtenerHorario_QNAME = new QName("http://service.soappet.com.pe/", "obtenerHorario");
    private final static QName _MyException_QNAME = new QName("http://service.soappet.com.pe/", "MyException");
    private final static QName _RegistrarHorario_QNAME = new QName("http://service.soappet.com.pe/", "RegistrarHorario");
    private final static QName _ObtenerHorarioResponse_QNAME = new QName("http://service.soappet.com.pe/", "obtenerHorarioResponse");
    private final static QName _RegistrarHorarioResponse_QNAME = new QName("http://service.soappet.com.pe/", "RegistrarHorarioResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.com.soappet.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistrarHorario }
     * 
     */
    public RegistrarHorario createRegistrarHorario() {
        return new RegistrarHorario();
    }

    /**
     * Create an instance of {@link MyExceptionBean }
     * 
     */
    public MyExceptionBean createMyExceptionBean() {
        return new MyExceptionBean();
    }

    /**
     * Create an instance of {@link RegistrarHorarioResponse }
     * 
     */
    public RegistrarHorarioResponse createRegistrarHorarioResponse() {
        return new RegistrarHorarioResponse();
    }

    /**
     * Create an instance of {@link ObtenerHorarioResponse }
     * 
     */
    public ObtenerHorarioResponse createObtenerHorarioResponse() {
        return new ObtenerHorarioResponse();
    }

    /**
     * Create an instance of {@link ObtenerHorario }
     * 
     */
    public ObtenerHorario createObtenerHorario() {
        return new ObtenerHorario();
    }

    /**
     * Create an instance of {@link HorarioDoctor }
     * 
     */
    public HorarioDoctor createHorarioDoctor() {
        return new HorarioDoctor();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerHorario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "obtenerHorario")
    public JAXBElement<ObtenerHorario> createObtenerHorario(ObtenerHorario value) {
        return new JAXBElement<ObtenerHorario>(_ObtenerHorario_QNAME, ObtenerHorario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyExceptionBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "MyException")
    public JAXBElement<MyExceptionBean> createMyException(MyExceptionBean value) {
        return new JAXBElement<MyExceptionBean>(_MyException_QNAME, MyExceptionBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarHorario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "RegistrarHorario")
    public JAXBElement<RegistrarHorario> createRegistrarHorario(RegistrarHorario value) {
        return new JAXBElement<RegistrarHorario>(_RegistrarHorario_QNAME, RegistrarHorario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerHorarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "obtenerHorarioResponse")
    public JAXBElement<ObtenerHorarioResponse> createObtenerHorarioResponse(ObtenerHorarioResponse value) {
        return new JAXBElement<ObtenerHorarioResponse>(_ObtenerHorarioResponse_QNAME, ObtenerHorarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarHorarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "RegistrarHorarioResponse")
    public JAXBElement<RegistrarHorarioResponse> createRegistrarHorarioResponse(RegistrarHorarioResponse value) {
        return new JAXBElement<RegistrarHorarioResponse>(_RegistrarHorarioResponse_QNAME, RegistrarHorarioResponse.class, null, value);
    }

}
