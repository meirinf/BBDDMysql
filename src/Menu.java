import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
/**
 * Created by 53638138e on 08/02/17.
 */
public class Menu {
    public static void main(String[] args) {



        try
        {

            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://172.31.73.192:3306/world", "root", "theking12");
            Statement stmt = conexion.createStatement();

            DatabaseMetaData meta = conexion.getMetaData();
            Tablas tbl = new Tablas();
            Selects sbbdd= new Selects();
            consultas cBBDD = new consultas();
        //Creamos un conexion a la BBDD pasandole la ruta/schema, usuario y password

        int num=1;
        while(num != 9){
            System.out.println("\n");
            System.out.println("------------------------------------------------");
            System.out.println("Seleccione una de la opciones siguientes");
            System.out.println("------------------------------------------------");
            System.out.println("1.Crear la tabla y hacer los inserts");
            System.out.println("2.Ver el contenido de la tabla");
            System.out.println("3.Ver descripcion de la tabla city");
            System.out.println("4.Añadir una nueva columna \"Population\" en la tabla city");


            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();


            switch (num) {
                case  1: tbl.afegirTablasInserts(stmt);//Llamamos al metodo para crear la tabla y los inserts
                    break;
                case  2: sbbdd.selectTabla(conexion);
                    break;
                case  3: cBBDD.descripcion(conexion);
                    break;
                case  4: cBBDD.modificar(conexion);
                    break;
                default:
                    break;
            }
        }

        // Cerramos la conexion a la base de datos.
        conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
