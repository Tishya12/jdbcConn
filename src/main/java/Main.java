import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {

        try{
           String fullHtml= Files.readString(Path.of("/home/tishyagoyal/htmlTemplate/index.html"));
            Class.forName("com.mysql.jdbc.Driver");
//Connection conn = DriverManager.getConnection("jdbc:mysql://paymentslink-database.cf7rvqel9ppr.ap-south-1.rds.amazonaws.com:3306/?user=admin?characterEncoding=utf8", "admin", "adminadmin");
            Connection conn = DriverManager.getConnection("jdbc:mysql://paymentslink-database.cf7rvqel9ppr.ap-south-1.rds.amazonaws.com:3306/paymentslink?" +  "user=admin&password=adminadmin&characterEncoding=utf8");
            PreparedStatement pstmt =
                    conn.prepareStatement("insert into template (name,html) values (?,?)");
            pstmt.setString(1, "simple");
            pstmt.setString(2, fullHtml); // this is your html string from step #1
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }catch(Exception e){
            System.out.println("exception is " + e);

        }
    }
}
