package tpiprogramacionii.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DataBaseConnection {

    private static final String PROPERTIES_FILE = "tpiprogramacionii/config/db.properties";

    public static Connection getConnection() throws SQLException {
        try {
            Properties props = new Properties();
            try (InputStream in = DataBaseConnection.class
                    .getClassLoader()
                    .getResourceAsStream(PROPERTIES_FILE)) {

                if (in == null) {
                    throw new RuntimeException("No se encontró el archivo " + PROPERTIES_FILE);
                }
                props.load(in);
            }

            String host = props.getProperty("db.host");
            String port = props.getProperty("db.port");
            String db   = props.getProperty("db.database");
            String user = props.getProperty("db.user");
            String pass = props.getProperty("db.password");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + db
                       + "?useSSL=false&serverTimezone=UTC";

            // Cada llamada devuelve una conexión NUEVA
            return DriverManager.getConnection(url, user, pass);

        } catch (IOException e) {
            throw new RuntimeException("Error al leer archivo de propiedades", e);
        }
    }
}
