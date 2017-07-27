package net.bur4ik.WebJournal.model;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "id_group")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_create")
    private String dateCreate;

    @Column(name = "id_curator")
    private int idCurator;

    @Column(name = "students_count")
    private int studentsCount;

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

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getIdCurator() {
        return idCurator;
    }

    public void setIdCurator(int idCurator) {
        this.idCurator = idCurator;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                ", idCurator=" + idCurator +
                ", studentsCount=" + studentsCount +
                '}';
    }
}
