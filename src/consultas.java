import java.sql.*;
/**
 * Created by 53638138e on 08/02/17.
 */
public class consultas {


    public void descripcion(Connection conexion) throws SQLException, ClassNotFoundException {
        Connection c = conexion;
        Statement stmt = c.createStatement();

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("");

        ResultSet resultSet = stmt.executeQuery("SELECT * FROM city;");
        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println("La tabla contiene " + metaData.getColumnCount() + " columnas");
        System.out.println("Descripcion de la tabla \"city\"");
        for (int i = 1; i < metaData.getColumnCount(); i++) {
            System.out.println("\t" + metaData.getColumnName(i) + " " + metaData.getColumnTypeName(i));
        }
     }

     public void modificar(Connection conexion) throws SQLException, ClassNotFoundException {

            Connection c = conexion;
            Statement stmt = c.createStatement();

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("");
            stmt.executeUpdate("Alter table city add Population CHAR ;");

        }
}
