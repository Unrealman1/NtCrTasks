
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;


public class Main {
    public static void main(String[] args) {

        try {

            File fXmlFile = new File("src/group.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();


            NodeList nList = doc.getElementsByTagName("student");
            double realAverageValue;
            double averageValue;

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                realAverageValue = 0;

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("firstname : " + eElement.getAttribute("firstname"));

                    int countOfSubjects = eElement.getElementsByTagName("subject").getLength();
                    for (int i = 0; i < countOfSubjects; i++) {
                        System.out.println("subject : " + eElement.getElementsByTagName("subject").item(i).getAttributes().getNamedItem("mark").getNodeValue());
                        realAverageValue += Double.parseDouble(eElement.getElementsByTagName("subject").item(i).getAttributes().getNamedItem("mark").getNodeValue());
                    }
                    averageValue = Double.parseDouble(eElement.getElementsByTagName("average").item(0).getTextContent());
                    System.out.println("average : " + averageValue);
                    realAverageValue /= countOfSubjects;
                    System.out.println("real average " + realAverageValue);
                    if (realAverageValue != averageValue) {
                        eElement.getElementsByTagName("average").item(0).setTextContent((Double.toString(realAverageValue)));
                    }
                }

            }
            File fXmlFile1 = new File("src/main/java/mastefTasks/group1.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
