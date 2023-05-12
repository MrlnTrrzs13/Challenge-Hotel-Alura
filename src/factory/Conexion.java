package factory;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Conexion {

    public DataSource dataSource;

    public Conexion() {

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(
                "jdbc:mysql://localhost/registro_hotel?useTimeZone=true&serverTimeZone=UTC");
        cpds.setUser("root");
        cpds.setPassword("");

        this.dataSource = cpds;
    }

    public Connection connection() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
