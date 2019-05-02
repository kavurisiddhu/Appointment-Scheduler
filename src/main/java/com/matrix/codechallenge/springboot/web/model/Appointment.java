package com.matrix.codechallenge.springboot.web.model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;
    private Timestamp appointment_date;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Appointment() {
        super();
    }

    public Appointment(Long id, Timestamp appointment_date, User user) {
        super();
        this.id = id;
        this.appointment_date = appointment_date;
        this.user = user;
    }

    public Appointment(Timestamp appointment_date, User user) {
        super();
        this.appointment_date = appointment_date;
        this.user = user;
    }

    public Appointment(Timestamp appointment_date) {
        super();
        this.appointment_date = appointment_date;
    }

    public Long getAppointment_id() {
        return id;
    }

    public void setAppointment_id(Long appointment_id) {
        this.id = appointment_id;
    }

    public Timestamp getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Timestamp appointment_date) {
        this.appointment_date = appointment_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appointment_date=" + appointment_date +
                ", user=" + user +
                '}';
    }

}
