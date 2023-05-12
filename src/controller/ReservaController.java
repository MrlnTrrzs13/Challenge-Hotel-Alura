package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import dao.ReservaDao;
import factory.Conexion;
import model.Reserva;

/**
 *
 * @author Marlon Torres
 */
public class ReservaController {

    private final ReservaDao reservationDao;

    public ReservaController() {
        Connection connection = new Conexion().connection();
        this.reservationDao = new ReservaDao(connection);
    }

    public void Save(Reserva reserva) {
        this.reservationDao.Save(reserva);
    }

    public List<Reserva> SearchReservation() {
        return this.reservationDao.SearchReservation();
    }

    public List<Reserva> SearchId(int id) {
        return this.reservationDao.SearchId(id);
    }

    public void Update(Date entryDate, Date departureDate, String price,
            String methodPayment, Integer id) {
        this.reservationDao.Update(entryDate, departureDate,
                price, methodPayment, id);
    }
    
    public void UpdateHuesped(Integer id_huesped, Integer id_reserva) {
        this.reservationDao.UpdateHuesped(id_huesped, id_reserva);
    }

    public void Delete(Integer id) {
        this.reservationDao.Delete(id);
    }
}
