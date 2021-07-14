package todolist;
import javafx.beans.property.SimpleObjectProperty;

import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class Bdconnection {
  // public Connection bdlink;
 private static final String bdName = "bd_poo";
   private static final  String bdUser = "root";
    private static  final String bdPassword = "cisco@2020";
    private static final   String url = "jdbc:mysql://localhost:3306/mysql?autoReconnect=true&useSSl=false";


    public static Connection getConnection() {

        Connection bdlink= null;
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                bdlink = DriverManager.getConnection(Bdconnection.url,Bdconnection.bdUser,Bdconnection.bdPassword);
        }catch (SQLException e){
            System.out.println("Erro nao conectar ao banco de dados" + e);

        }catch (ClassNotFoundException e){
            System.out.println("Nao foi possivel carregar a classe JDBC " + e);

        }catch (Exception e){
            System.out.println("Erro geral " +e);

        }
        return bdlink;
    }
}
