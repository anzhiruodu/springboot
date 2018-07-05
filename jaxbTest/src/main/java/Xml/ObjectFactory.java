//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.07.04 时间 12:05:18 PM CST 
//


package Xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Xml package. 
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

    private final static QName _People_QNAME = new QName("", "people");
    private final static QName _TestplmnTest2_QNAME = new QName("", "test2");
    private final static QName _TestplmnTestcase1_QNAME = new QName("", "testcase1");
    private final static QName _TestplmnTest1_QNAME = new QName("", "test1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link World }
     * 
     */
    public World createWorld() {
        return new World();
    }

    /**
     * Create an instance of {@link Testplmn }
     * 
     */
    public Testplmn createTestplmn() {
        return new Testplmn();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "people")
    public JAXBElement<String> createPeople(String value) {
        return new JAXBElement<String>(_People_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "test2", scope = Testplmn.class)
    public JAXBElement<String> createTestplmnTest2(String value) {
        return new JAXBElement<String>(_TestplmnTest2_QNAME, String.class, Testplmn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "testcase1", scope = Testplmn.class)
    public JAXBElement<String> createTestplmnTestcase1(String value) {
        return new JAXBElement<String>(_TestplmnTestcase1_QNAME, String.class, Testplmn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "test1", scope = Testplmn.class)
    public JAXBElement<String> createTestplmnTest1(String value) {
        return new JAXBElement<String>(_TestplmnTest1_QNAME, String.class, Testplmn.class, value);
    }

}
