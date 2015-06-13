
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

    private final static QName _EliminarCliente_QNAME = new QName("http://service.soappet.com.pe/", "eliminarCliente");
    private final static QName _GuardarClienteResponse_QNAME = new QName("http://service.soappet.com.pe/", "guardarClienteResponse");
    private final static QName _ListarClientes_QNAME = new QName("http://service.soappet.com.pe/", "listarClientes");
    private final static QName _ObtenerCliente_QNAME = new QName("http://service.soappet.com.pe/", "obtenerCliente");
    private final static QName _EliminarClienteResponse_QNAME = new QName("http://service.soappet.com.pe/", "eliminarClienteResponse");
    private final static QName _ListarClientesResponse_QNAME = new QName("http://service.soappet.com.pe/", "listarClientesResponse");
    private final static QName _ObtenerClienteResponse_QNAME = new QName("http://service.soappet.com.pe/", "obtenerClienteResponse");
    private final static QName _GuardarCliente_QNAME = new QName("http://service.soappet.com.pe/", "guardarCliente");
    private final static QName _MyException_QNAME = new QName("http://service.soappet.com.pe/", "MyException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.com.soappet.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EliminarClienteResponse }
     * 
     */
    public EliminarClienteResponse createEliminarClienteResponse() {
        return new EliminarClienteResponse();
    }

    /**
     * Create an instance of {@link ObtenerClienteResponse }
     * 
     */
    public ObtenerClienteResponse createObtenerClienteResponse() {
        return new ObtenerClienteResponse();
    }

    /**
     * Create an instance of {@link ListarClientesResponse }
     * 
     */
    public ListarClientesResponse createListarClientesResponse() {
        return new ListarClientesResponse();
    }

    /**
     * Create an instance of {@link ObtenerCliente }
     * 
     */
    public ObtenerCliente createObtenerCliente() {
        return new ObtenerCliente();
    }

    /**
     * Create an instance of {@link ListarClientes }
     * 
     */
    public ListarClientes createListarClientes() {
        return new ListarClientes();
    }

    /**
     * Create an instance of {@link GuardarClienteResponse }
     * 
     */
    public GuardarClienteResponse createGuardarClienteResponse() {
        return new GuardarClienteResponse();
    }

    /**
     * Create an instance of {@link EliminarCliente }
     * 
     */
    public EliminarCliente createEliminarCliente() {
        return new EliminarCliente();
    }

    /**
     * Create an instance of {@link MyExceptionBean }
     * 
     */
    public MyExceptionBean createMyExceptionBean() {
        return new MyExceptionBean();
    }

    /**
     * Create an instance of {@link GuardarCliente }
     * 
     */
    public GuardarCliente createGuardarCliente() {
        return new GuardarCliente();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "eliminarCliente")
    public JAXBElement<EliminarCliente> createEliminarCliente(EliminarCliente value) {
        return new JAXBElement<EliminarCliente>(_EliminarCliente_QNAME, EliminarCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "guardarClienteResponse")
    public JAXBElement<GuardarClienteResponse> createGuardarClienteResponse(GuardarClienteResponse value) {
        return new JAXBElement<GuardarClienteResponse>(_GuardarClienteResponse_QNAME, GuardarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarClientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "listarClientes")
    public JAXBElement<ListarClientes> createListarClientes(ListarClientes value) {
        return new JAXBElement<ListarClientes>(_ListarClientes_QNAME, ListarClientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "obtenerCliente")
    public JAXBElement<ObtenerCliente> createObtenerCliente(ObtenerCliente value) {
        return new JAXBElement<ObtenerCliente>(_ObtenerCliente_QNAME, ObtenerCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "eliminarClienteResponse")
    public JAXBElement<EliminarClienteResponse> createEliminarClienteResponse(EliminarClienteResponse value) {
        return new JAXBElement<EliminarClienteResponse>(_EliminarClienteResponse_QNAME, EliminarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarClientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "listarClientesResponse")
    public JAXBElement<ListarClientesResponse> createListarClientesResponse(ListarClientesResponse value) {
        return new JAXBElement<ListarClientesResponse>(_ListarClientesResponse_QNAME, ListarClientesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "obtenerClienteResponse")
    public JAXBElement<ObtenerClienteResponse> createObtenerClienteResponse(ObtenerClienteResponse value) {
        return new JAXBElement<ObtenerClienteResponse>(_ObtenerClienteResponse_QNAME, ObtenerClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soappet.com.pe/", name = "guardarCliente")
    public JAXBElement<GuardarCliente> createGuardarCliente(GuardarCliente value) {
        return new JAXBElement<GuardarCliente>(_GuardarCliente_QNAME, GuardarCliente.class, null, value);
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
