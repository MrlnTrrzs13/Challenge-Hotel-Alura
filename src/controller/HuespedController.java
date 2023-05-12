package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import dao.HuespedDao;
import factory.Conexion;
import model.Huesped;

/**
 *
 * @author Marlon Torres
 */
public class HuespedController {

    private final HuespedDao guestDao;

    public HuespedController() {
        Connection connection = new Conexion().connection();
        this.guestDao = new HuespedDao(connection);
    }

    public void Save(Huesped guests) {
        this.guestDao.Save(guests);
    }

    public List<Huesped> ToListGuest() {
        return this.guestDao.ToListGuest();
    }

    public List<Huesped> SearchId(int id) {
        return this.guestDao.SearchId(id);
    }
    
    public List<Huesped> SearchIdReservation(int idReservation) {
        return this.guestDao.SearchIdReservation(idReservation);
    }

    public void Update(Date birthDate, String name, String lastName, String phone,
            String nationality, Integer id) {
        this.guestDao.Update(birthDate, name, lastName, phone, nationality, id);
    }
    
    public void UpdateReservation(Integer id_reservation, Integer id) {
        this.guestDao.UpdateReservation(id_reservation, id);
    }

    public void Delete(Integer id) {
        this.guestDao.Delete(id);
    }
}
