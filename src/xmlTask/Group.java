
package xmlTask;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Group {

    ArrayList<Student> student = new ArrayList<>();

    public Group() {
    }

    public Group(ArrayList<Student> student) {
        this.student = student;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    @XmlElement
    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }


}

