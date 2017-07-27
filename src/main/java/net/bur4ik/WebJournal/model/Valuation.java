package net.bur4ik.WebJournal.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "valuations")
public class Valuation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valuation")
    private int id;

    @Column(name = "value")
    private int value;

    @Column(name = "presense")
    private boolean presense;

    @Column(name = "date")
    private Date date;

    @Column(name = "id_student")
    private int idStudent;

    @Column(name = "id_subject")
    private int idSubject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getPresense() {
        return presense;
    }

    public void setPresense(boolean presense) {
        this.presense = presense;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    @Override
    public String toString() {
        return "Valuation{" +
                "id=" + id +
                ", value=" + value +
                ", presence=" + presense +
                ", date=" + date +
                ", idStudent=" + idStudent +
                ", idSubject=" + idSubject +
                '}';
    }
}
