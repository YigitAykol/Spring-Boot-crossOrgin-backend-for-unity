package com.yiit.trying.Media;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class media {
    @Id
    @SequenceGenerator(
            name = "media_sequence",
            sequenceName = "media_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "media_sequence"
    )
    private Long id;
    private String name;
    private String descJanr;
    private LocalDate dob;
    private int point;

    public media(String name, String descJanr, LocalDate dob, int point) {//for database
        this.name = name;
        this.descJanr = descJanr;
        this.dob = dob;
        this.point = point;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescJanr() {
        return descJanr;
    }

    public void setDescJanr(String descJanr) {
        this.descJanr = descJanr;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public media(){

    }
    public media(Long id, String name, String descJanr, LocalDate dob, int point) {
        this.id = id;
        this.name = name;
        this.descJanr = descJanr;
        this.dob = dob;
        this.point = point;
    }

    @Override
    public String toString() {
        return "media{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descJanr='" + descJanr + '\'' +
                ", dob=" + dob +
                ", point=" + point +
                '}';
    }
}
