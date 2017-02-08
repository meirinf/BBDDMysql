import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by 53638138e on 08/02/17.
 */
public class Tablas {
    public void afegirTablasInserts(Statement statement) throws IOException, SQLException {

        Statement stmt = statement;

        String s;
        StringBuffer sb = new StringBuffer();//usamos StringBuffer para que nos lo vaya añadiendo Strings, usando el append se añade  sin tener que usar =+
        FileReader f1 = new FileReader(new File("world.sql"));//Ponemos la ruta del fitxero a leer
        BufferedReader br = new BufferedReader(f1);//Creamos un objeto bufferedReader para poder leer el fitxero
        System.out.println(br.readLine());
        while ((s = br.readLine()) != null) {//hacemos que el string se igual a la linia leida y si no es null la añadimos al Stringbuffered
            sb.append(s);
        }
        br.close();//Cerramos la coneccion a BufferedReader

        String[] inst = sb.toString().split(";");
        for (int i = 0; i < inst.length; i++) {
            //Nos asseguramos que no haya alguna linia en blanco y las ejecutamos con el statment
            if (!inst[i].trim().equals("")) {
                stmt.executeUpdate(inst[i] + ";");
            }
        }
    }
}
