import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {

    public static void main(String[] args) {
        String fileContent = null;
        try {
            fileContent = Database.getSQLFromResource("sql/populate_db.sql"); // Get file path from input argument
            Connection connection = Database.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(fileContent);
            pstmt.execute();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}