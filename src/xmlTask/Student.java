package xmlTask;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class Student {
    String firstname;
    String lastname;
    int groupnumber;
    ArrayList<Subject> subject = new ArrayList<>();
    double average;

    public int getGroupnumber() {
        return groupnumber;
    }

    @XmlAttribute
    public void setGroupnumber(int groupnumber) {
        this.groupnumber = groupnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    @XmlAttribute
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @XmlAttribute
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getAverage() {
        return average;
    }

    @XmlElement
    public void setAverage(double average) {
        this.average = average;
    }

    public ArrayList<Subject> getSubject() {
        return subject;
    }


    @XmlElement
    public void setSubject(ArrayList<Subject> subject) {
        this.subject = subject;

    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", groupnumber=" + groupnumber +
                ", subject=" + subject +
                ", average=" + average +
                '}';
    }
}
