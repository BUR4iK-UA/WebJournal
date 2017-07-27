package net.bur4ik.WebJournal.model;
import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {// доробити  інфа на листку потім це стерти
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_teacher")
    private int idTeacher;

    @Column(name = "id_group")
    private int idGroup;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idTeacher=" + idTeacher +
                ", idGroup=" + idGroup +
                '}';
    }
}
