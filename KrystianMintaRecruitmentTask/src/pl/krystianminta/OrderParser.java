package pl.krystianminta;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import pl.krystianminta.factory.AbstractFactoryImpl;

import javax.xml.parsers.*;
import java.io.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class OrderParser {

    private static volatile OrderParser instance = null;

    private OrderParser()
    {

    }

    public static OrderParser getInstance() {
        if(instance == null) {
            synchronized (OrderParser.class) {
                if(instance == null) {
                    instance = new OrderParser();
                }
            }
        }
        return instance;
    }

    public Queue<String> parseOrderXML(String fileName) throws ParserConfigurationException, SAXException, IOException
    {
        Queue<String> order = new LinkedBlockingQueue<>();
        String vehicleType;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(fileName));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("item");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;

                vehicleType = eElement.getAttribute("type");

                order.add(vehicleType);
            }
        }
        return order;
    }

}
