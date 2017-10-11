package xmlTask;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        final String xmlIntputLocation = "src/group.xml";
        final String xmlOutputLocation = "src/groupRefabrished.xml";

        File file = new File(xmlIntputLocation);
        try {


            ArrayList<Student> students = convertXmlToObject(file);

            printInConsole(students);
            adjustWrongAverageValues(students);

            Group group = new Group(students);

            convertObjectToXML(xmlOutputLocation, group);


        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    private static void adjustWrongAverageValues(ArrayList<Student> students) {
        double realaverage = 0;
        int numberOfSubjects;

        for (int i = 0; i < students.size(); i++) {


            ArrayList<Subject> subjects = students.get(i).getSubject();

            numberOfSubjects = subjects.size();
            for (int j = 0; j < numberOfSubjects; j++) {
                realaverage += subjects.get(j).mark;
            }
            realaverage /= numberOfSubjects;
            if (realaverage != students.get(i).average) {
                students.get(i).average = realaverage;
            }

            realaverage = 0;
            numberOfSubjects = 0;
        }
    }

    private static void printInConsole(ArrayList<Student> students) {
        System.out.println("Исходный XML\n");
        students.forEach(student -> System.out.println(student.toString()));
        System.out.println();
    }

    private static ArrayList<Student> convertXmlToObject(File file) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Group.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Group group = (Group) jaxbUnmarshaller.unmarshal(file);


        return group.getStudent();
    }

    private static void convertObjectToXML(String xmlOutputLocation, Group group) {
        try {

            File file = new File(xmlOutputLocation);
            JAXBContext jaxbContext = JAXBContext.newInstance(Group.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(group, file);
            System.out.println("результат после корректирования и последующего конвертированя объекта в Xml\n");
            jaxbMarshaller.marshal(group, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}


