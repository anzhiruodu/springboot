package test;

import Xml.World;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;

public class JAXBTest {

    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = JAXBTest.class.getClassLoader().getResourceAsStream("test.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(World.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        //在解组类unmarshaller中放入一个schema，用SchemaFactory工程，指定W3C_XML_SCHEMA_NS_URI和原始文件xsd
        unmarshaller.setSchema(SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(JAXBTest.class.getClassLoader().getResource("world.xsd")));

        //拦截解析xml时候出现的异常
        unmarshaller.setEventHandler(new ValidationEventHandler() {
            @Override
            public boolean handleEvent(ValidationEvent event) {
                ValidationEventLocator locator = event.getLocator();
                System.out.println(String.format("XML解析出错！%d行%d列：%s", locator.getLineNumber(), locator.getColumnNumber(), event.getMessage()));
                return false;
            }
        });

        //结果，，
        World world =(World)unmarshaller.unmarshal(resourceAsStream);
        String plant = world.getPlant();
        System.out.println(world);

    }
}
