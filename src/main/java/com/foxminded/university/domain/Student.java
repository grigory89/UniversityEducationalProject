package com.foxminded.university.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="students")
public class Student extends Person {
    @Column(name="id_card")
    private Integer idCard;

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return idCard.equals(student.idCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idCard);
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                ", idCard=" + idCard +
                "}";
    }
}
