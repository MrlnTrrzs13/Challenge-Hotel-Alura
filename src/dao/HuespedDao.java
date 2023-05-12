package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Huesped;

/**
 *
 * @author Marlon Torres
 */
public class HuespedDao {

    private final Connection connection;

    public HuespedDao(Connection connection) {
        this.connection = connection;
    }

    public void Save(Huesped huesped) {
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO Huesped(nombre_huesped, apellido_huesped, telefono, fecha_nacimiento, "
                    + "nacionalidad, id_reserva) VALUES (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            try (pst) {
                pst.setString(1, huesped.getName());
                pst.setString(2, huesped.getLastName());
                pst.setString(3, huesped.getPhone());
                pst.setDate(4, huesped.getbirthdate());
                pst.setString(5, huesped.getNationality());
                pst.setInt(6, huesped.getIdReservation());
                pst.execute();

                try (ResultSet rs = pst.getGeneratedKeys()) {
                    while (rs.next()) {
                        huesped.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Huesped> ToListGuest() {
        List<Huesped> guests = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT id_huesped, nombre_huesped, apellido_huesped, telefono,"
                    + " fecha_nacimiento, nacionalidad, id_reserva FROM Huesped");

            try (pst) {
                pst.execute();

                TransformResultSetInGuest(guests, pst);
            }
            return guests;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Huesped> SearchId(int id) {
        List<Huesped> guests = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT id_huesped, nombre_huesped, apellido_huesped, telefono, fecha_nacimiento,"
                    + " nacionalidad, id_reserva FROM Huesped WHERE id_huesped = ?");

            try (pst) {
                pst.setInt(1, id);
                pst.execute();

                TransformResultSetInGuest(guests, pst);
            }
            return guests;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Huesped> SearchIdReservation(int idReservation) {
        List<Huesped> guest = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT nombre_huesped, apellido_huesped "
                    + " FROM Huesped WHERE id_reserva = ?");

            try (pst) {
                pst.setInt(1, idReservation);
                pst.execute();

                try (ResultSet rs = pst.getResultSet()) {
                    while (rs.next()) {
                        Huesped guests = new Huesped(rs.getString(1), rs.getString(2));
                        guest.add(guests);
            }
        }
            }
            return guest;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Update(Date birthDate, String name, String lastName, String phone,
            String nationality, Integer id) {

        try (PreparedStatement pst = connection.prepareStatement(
                "UPDATE Huesped SET nombre_huesped = ?, apellido_huesped = ?,"
                + " telefono = ?, fecha_nacimiento = ?, nacionalidad = ?"
                + " WHERE id_huesped = ?")) {
            pst.setString(1, name);
            pst.setString(2, lastName);
            pst.setString(3, phone);
            pst.setDate(4, birthDate);
            pst.setString(5, nationality);
            pst.setInt(6, id);
            pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void UpdateReservation(Integer id_reservation, Integer id) {
        try (PreparedStatement pst = connection.prepareStatement(
                "UPDATE Huesped SET id_reserva = ? WHERE id_huesped = ?")) {
            pst.setInt(1, id_reservation);
            pst.setInt(2, id);
            pst.execute();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Delete(Integer id) {
        try (PreparedStatement pst = connection.prepareStatement(
                "DELETE FROM Huesped WHERE id_huesped = ?")) {
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void TransformResultSetInGuest(List<Huesped> reservation, PreparedStatement pst) throws SQLException {
        try (ResultSet rs = pst.getResultSet()) {
            while (rs.next()) {
                Huesped guests = new Huesped(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getDate(5),
                        rs.getString(6), rs.getInt(7));
                reservation.add(guests);
            }
        }
    }
}
