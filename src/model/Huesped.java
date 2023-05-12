package model;

import java.sql.Date;

/**
 *
 * @author Marlon Torres
 */
public class Huesped {

    private Integer id, idReservation;
    private String name, lastName, phone, nationality;
    private Date birthdate;

    public Huesped(String name, String lastName, String phone, Date birthDate, String nationality, Integer idReservation) {

        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.birthdate = birthDate;
        this.nationality = nationality;
        this.idReservation = idReservation;
    }

    public Huesped(Integer id, String name, String lastName, String phone, Date birthDate, String nationality, Integer idReservation) {

        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.birthdate = birthDate;
        this.nationality = nationality;
        this.idReservation = idReservation;
    }

    public Huesped(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getbirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
}
