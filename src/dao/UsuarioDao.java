package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author Marlon Torres
 */
public class UsuarioDao {

    private final Connection connection;

    public UsuarioDao(Connection connection) {
        this.connection = connection;
    }

    public void Save(Usuario user) {
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO Usuarios(nombre_usuario, email, telefono, username,"
                    + " password, tipo_nivel, estatus, registrado_por) VALUES (?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            try (pst) {
                pst.setString(1, user.getName());
                pst.setString(2, user.getEmail());
                pst.setString(3, user.getPhone());
                pst.setString(4, user.getUsername());
                pst.setString(5, user.getPassword());
                pst.setString(6, user.getLevelType());
                pst.setString(7, user.getStatus());
                pst.setString(8, user.getRegister());
                pst.execute();

                try (ResultSet rs = pst.getGeneratedKeys()) {
                    while (rs.next()) {
                        user.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> SearchNameAdmin(String username) {
        List<Usuario> users = new ArrayList<>();
        try {
            String sql = "SELECT nombre_usuario FROM Usuarios WHERE username = ?";

            try (PreparedStatement pst = connection.prepareStatement(sql)) {

                pst.setString(1, username);
                pst.execute();

                try (ResultSet rs = pst.getResultSet()) {
                    if (rs.next()) {
                        String name_user = rs.getString("nombre_usuario");

                        Usuario NameUser;
                        NameUser = new Usuario(username, name_user);
                        users.add(NameUser);
                    }
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> ToListUser() {
        List<Usuario> users = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT id_usuario, nombre_usuario, username, tipo_nivel, estatus FROM Usuarios");

            try (pst) {
                pst.execute();

                try (ResultSet rs = pst.getResultSet()) {
                    while (rs.next()) {
                        Usuario User = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getString(5));
                        users.add(User);
                    }
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> SearchId(Integer id) {
        List<Usuario> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Usuarios WHERE id_usuario = ?";

            try (PreparedStatement pst = connection.prepareStatement(sql)) {
                pst.setInt(1, id);
                pst.execute();

                try (ResultSet rs = pst.getResultSet()) {
                    while (rs.next()) {
                        Usuario user = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                                rs.getString(8), rs.getString(9));
                        users.add(user);
                    }
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> ActiveUser(String username, Integer id) {
        List<Usuario> users = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT username FROM Usuarios WHERE username = ? and not id_usuario = ?");
            try (pst) {
                pst.setString(1, username);
                pst.setInt(2, id);
                pst.execute();

                try (ResultSet rs = pst.getResultSet()) {
                    if (rs.next()) {
                        Usuario NameUser;
                        NameUser = new Usuario(rs.getString(1));
                        users.add(NameUser);
                    }
                }
                return users;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> Validation(String username) {
        List<Usuario> users = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT username FROM Usuarios WHERE username  = ?");
            try (pst) {
                pst.setString(1, username);
                pst.execute();
                try (ResultSet rs = pst.getResultSet()) {
                    if (rs.next()) {
                        Usuario UserName;
                        UserName = new Usuario(rs.getString(1));
                        users.add(UserName);
                    }
                }
                return users;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> SearchUserId(String username, String password) {
        List<Usuario> users = new ArrayList<>();
        try {
            String sql = "SELECT id_usuario, tipo_nivel, estatus FROM Usuarios WHERE username = ? AND password = ?";

            try (PreparedStatement pst = connection.prepareStatement(sql)) {

                pst.setString(1, username);
                pst.setString(2, password);
                pst.execute();

                try (ResultSet rs = pst.getResultSet()) {
                    if (rs.next()) {
                        String levelType = rs.getString("tipo_nivel");
                        String status = rs.getString("estatus");
                        Usuario userNam;
                        userNam = new Usuario(username, password, levelType, status);
                        users.add(userNam);
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos.");
                    }
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Update(String name, String email, String phone, String username,
            String levelType, String status, Integer id) {

        try (PreparedStatement pst = connection.prepareStatement(
                "UPDATE Usuarios SET nombre_usuario = ?,"
                + " email = ?, telefono = ?, username = ?, tipo_nivel = ?,"
                + " estatus = ? WHERE id_usuario = ?")) {
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, phone);
            pst.setString(4, username);
            pst.setString(5, levelType);
            pst.setString(6, status);
            pst.setInt(7, id);
            pst.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void UpdatePassword(String password, int id) {
        try (PreparedStatement pst = connection.prepareStatement(
                "UPDATE Usuarios SET password = ? WHERE id_usuario = ?")) {

            pst.setString(1, password);
            pst.setInt(2, id);
            pst.execute();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void Delete(Integer id) {
        try (PreparedStatement pst = connection.prepareStatement("DELETE FROM Usuarios WHERE id_usuario = ?")) {
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
