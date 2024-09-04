import java.sql.*;

public class DBlogic {

    private String DB = "jdbc:mysql://localhost:3307/piektdiena";
    private String USER = "root";
    private String PASS = "";

    //    String user_email = "hello@hello.lv";
    //    String user_password = "helloamerica";

    // create
    public void register(String user_email, String user_password) {

        String query = "INSERT INTO users (email, password) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, user_email);
            pstmt.setString(2, user_password);

            pstmt.executeUpdate();

            System.out.println("Data inserted...");

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    // delete
    public void delete(int id) {
        try {

            Connection conn = DriverManager.getConnection(DB, USER, PASS);
            Statement stmt = conn.createStatement();

            String query = "DELETE FROM users WHERE id = '" + id + "'";

            stmt.executeUpdate(query);

            System.out.println("Data deleted...");


        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    // update
    public void update(String user_password, int id) {
        try {

            Connection conn = DriverManager.getConnection(DB, USER, PASS);
            Statement stmt = conn.createStatement();

            String query = "UPDATE users SET password = '"+ user_password +"' WHERE id = '"+ id +"'";

            stmt.executeUpdate(query);

            System.out.println("Data updated...");


        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    // select
    public void select() {
        try {

            Connection conn = DriverManager.getConnection(DB, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, email, password FROM users");

            while(rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("email: " + rs.getString("email"));
                System.out.println("password: " + rs.getString("password"));
                System.out.println(" ");
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

}
