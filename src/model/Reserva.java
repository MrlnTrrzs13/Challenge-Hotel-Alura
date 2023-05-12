
package model;

import java.sql.Date;

/**
 *
 * @author Marlon Torres
 */
public class Reserva {

    private Integer id, id_huesped;
    private Date entryDate, departureDate;
    private String price, methodPayment;

    public Reserva(Date entryDate, Date departureDate, String price, String methodPayment, Integer id_huesped) {
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.price = price;
        this.methodPayment = methodPayment;
        this.id_huesped = id_huesped;
    }

    public Reserva(Integer id, Date entryDate, Date departureDate, String price, String methodPayment, Integer id_huesped) {
        this.id = id;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.price = price;
        this.methodPayment = methodPayment;
        this.id_huesped = id_huesped;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEntryDate() {
        return entryDate;
    }
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getPrice() {
        return price;
    }
    public void setPrive(String price) {
        this.price = price;
    }

    public String getmethodPayment() {
        return methodPayment;
    }
    public void setmethodPayment(String methodPayment) {
        this.methodPayment = methodPayment;
    }
    
    public Integer getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(Integer id_huesped) {
        this.id_huesped = id_huesped;
    }
    
}
