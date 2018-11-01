package ifpb.dac.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Amanda
 */
public class ConnectionBD {
    public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/dac";
        String user = "postgres";
        String password = "123";
        return DriverManager.getConnection(url, user, password);
    }
}
