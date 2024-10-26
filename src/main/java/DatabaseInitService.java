import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseInitService {
    public static void main(String[] args){
        String fileContent = null;
        try {
            fileContent = Database.getSQLFromResource("sql/init_db.sql"); // Get file path from input argument
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(fileContent);
            preparedStatement.execute();
        } catch (IOException | URISyntaxException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
