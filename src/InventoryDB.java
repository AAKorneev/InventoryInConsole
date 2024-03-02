import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InventoryDB {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "admin";

    public static Statement statement;
    public static Connection connection;

    public static void createTable(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Создаем таблицу
            statement = connection.createStatement();
            String sql = "CREATE TABLE INVENTORY " +
                    "(ID SERIAL PRIMARY KEY     NOT NULL," +
                    " FRUIT          TEXT    NOT NULL, " +
                    " COLOR          TEXT    NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        }catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }

    public static void insert(Apple apple){
        try {
            // Добавляем данные в таблицу
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sql = "INSERT INTO INVENTORY (FRUIT,COLOR) "
                    + "VALUES ('" + apple.getName() + "', '" + apple.getColor() + "');";
            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
            connection.close();

        }catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }

    public static int count(){
        int output = 0;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM INVENTORY;");
            resultSet.next();
            output = Integer.parseInt(resultSet.getString(1));

            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return output;
    }

    public static void delete(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            connection.setAutoCommit(false);
            statement = connection.createStatement();

            String sql = "DELETE FROM INVENTORY WHERE ID = (SELECT id FROM INVENTORY ORDER BY id DESC LIMIT 1)";
            statement.executeUpdate(sql);

            statement.close();
            connection.commit();
            connection.close();
        }catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }

    public static void show(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM INVENTORY;");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " | "
                                    + resultSet.getString(2) + " | "
                                    + resultSet.getString(3));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}
