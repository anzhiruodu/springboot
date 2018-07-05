//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.07.04 时间 12:05:18 PM CST 
//


package Xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import com.sun.xml.internal.bind.Locatable;
import com.sun.xml.internal.bind.annotation.XmlLocation;
import org.xml.sax.Locator;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}people"/>
 *         &lt;element ref="{}testplmn"/>
 *         &lt;element name="plant" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Inanimate_body" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" default="描述世界万物" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "people",
    "testplmn",
    "plant",
    "inanimateBody"
})
@XmlRootElement(name = "world")
public class World
    implements Locatable
{

    @XmlElement(required = true)
    protected String people;
    @XmlElement(required = true)
    protected Testplmn testplmn;
    @XmlElement(required = true)
    protected String plant;
    @XmlElement(name = "Inanimate_body", required = true)
    protected String inanimateBody;
    @XmlAttribute(name = "desc")
    @XmlSchemaType(name = "anySimpleType")
    protected String desc;
    @XmlLocation
    @XmlTransient
    protected Locator locator;

    /**
     * 获取people属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeople() {
        return people;
    }

    /**
     * 设置people属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeople(String value) {
        this.people = value;
    }

    /**
     * 获取testplmn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Testplmn }
     *     
     */
    public Testplmn getTestplmn() {
        return testplmn;
    }

    /**
     * 设置testplmn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Testplmn }
     *     
     */
    public void setTestplmn(Testplmn value) {
        this.testplmn = value;
    }

    /**
     * 获取plant属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlant() {
        return plant;
    }

    /**
     * 设置plant属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlant(String value) {
        this.plant = value;
    }

    /**
     * 获取inanimateBody属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInanimateBody() {
        return inanimateBody;
    }

    /**
     * 设置inanimateBody属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInanimateBody(String value) {
        this.inanimateBody = value;
    }

    /**
     * 获取desc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        if (desc == null) {
            return "\u63cf\u8ff0\u4e16\u754c\u4e07\u7269";
        } else {
            return desc;
        }
    }

    /**
     * 设置desc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    public Locator sourceLocation() {
        return locator;
    }

    public void setSourceLocation(Locator newLocator) {
        locator = newLocator;
    }

}
