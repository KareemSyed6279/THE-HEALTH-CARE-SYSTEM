import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class PatientDataParser {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("patient_data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            
            doc.getDocumentElement().normalize();
            
            NodeList nodeList = doc.getElementsByTagName("patientData");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String age = element.getElementsByTagName("age").item(0).getTextContent();
                    String gender = element.getElementsByTagName("gender").item(0).getTextContent();
                    
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Gender: " + gender);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
