package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Reserva;

/**
 *
 * @author Marlon Torres
 */
public class ReservaDao {

    private final Connection connection;

    public ReservaDao(Connection connection) {
        this.connection = connection;
    }

    public void Save(Reserva reserva) {
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO Reservas (fecha_entrada, fecha_salida, valor, forma_pago, id_huesped) VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            try (pst) {
                pst.setDate(1, reserva.getEntryDate());
                pst.setDate(2, reserva.getDepartureDate());
                pst.setString(3, reserva.getPrice());
                pst.setString(4, reserva.getmethodPayment());
                pst.setInt(5, reserva.getId_huesped());
                pst.executeUpdate();

                try (ResultSet rs = pst.getGeneratedKeys()) {
                    while (rs.next()) {
                        reserva.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Reserva>SearchReservation(){
        List<Reserva> reservations;
        reservations = new ArrayList<>();
        try{
            PreparedStatement pst = connection.prepareStatement(
                "SELECT id_reserva, fecha_entrada, fecha_salida, valor, forma_pago, id_huesped FROM Reservas");
            
            try(pst) {
                pst.execute();
                TransformResultSetInReserva(reservations, pst);
            }
            return reservations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Reserva> SearchId(int id) {
        List<Reserva> reservations = new ArrayList<>();
        
        try {
            PreparedStatement pst = connection.prepareStatement(
                "SELECT id_reserva, fecha_entrada, fecha_salida, valor, forma_pago, id_huesped FROM Reservas WHERE id_reserva = ?");

            try (pst) {
                pst.setInt (1, id);
                pst.execute();

                TransformResultSetInReserva(reservations, pst);
            }
            return reservations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void Delete(Integer id) {
        try (PreparedStatement pst = connection.prepareStatement("DELETE FROM Reservas WHERE id_reserva = ?")) {
            pst.setInt(1, id);
            pst.execute();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void Update(Date entryDate, Date departureDate, String price, String methodPayment, Integer id){
        try (PreparedStatement pst = connection.prepareStatement("UPDATE Reservas SET fecha_entrada = ?," + 
                    " fecha_salida = ?, valor = ?, forma_pago = ? WHERE id_reserva = ?")) {
            pst.setDate(1, entryDate);
            pst.setDate(2, departureDate);
            pst.setString(3, price);
            pst.setString(4, methodPayment);
            pst.setInt(5, id);
            
            pst.execute();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void UpdateHuesped(Integer id_huesped, Integer id_reserva) {
        try (PreparedStatement pst = connection.prepareStatement(
                "UPDATE Reservas SET id_huesped = ? WHERE id_reserva = ?")) {
            pst.setInt(1, id_huesped);
            pst.setInt(2, id_reserva);
            pst.execute();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void TransformResultSetInReserva(List<Reserva> reservations, PreparedStatement pst) throws SQLException {
        try(ResultSet rs = pst.getResultSet()) {
            while(rs.next()) {
                Reserva reservation = new Reserva(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4),
                    rs.getString(5), rs.getInt(6));
                reservations.add(reservation);
            }
        } catch (Exception e) {
        }
    }
}
