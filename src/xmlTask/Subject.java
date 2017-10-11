package xmlTask;


import javax.xml.bind.annotation.XmlAttribute;

public class Subject {
    String title;
    double mark;

    public Subject(String title, double mark) {
        this.title = title;
        this.mark = mark;
    }

    public Subject() {
    }

    public String getTitle() {
        return title;
    }
@XmlAttribute
    public void setTitle(String title) {
        this.title = title;
    }

    public double getMark() {
        return mark;
    }
@XmlAttribute
    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", mark=" + mark +
                '}';
    }
}