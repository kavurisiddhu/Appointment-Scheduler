package com.matrix.codechallenge.springboot.web.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name="t_user")
public class User {
    @Id
    @GeneratedValue
    private Long user_id;

    private String first_name;

    private String last_name;

    private Date dob;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = Appointment.class)
    private Set<Appointment> appointments;

    public User() {
        super();
    }

    public User(Long user_id, String first_name, String last_name, Date dob, Set<Appointment> appointments) {
        super();
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.appointments = appointments;
        this.appointments.forEach(x -> x.setUser(this));
    }

    public User(String first_name, String last_name, Date dob, Set<Appointment> appointments) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.appointments = appointments;
        this.appointments.forEach(x -> x.setUser(this));
    }

    public Long getId() {
        return user_id;
    }

    public User setId(Long user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public User setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public User setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public User setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
        this.appointments.forEach(x -> x.setUser(this));
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob=" + dob +
                ", appointments=" + appointments +
                '}';
    }
}
