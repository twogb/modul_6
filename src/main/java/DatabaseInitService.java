import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) throws SQLException {
        String fileContent = null;
        try {
            fileContent = Database.getSQLFromResource("sql/init_db.sql"); // Get file path from input argument
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        Connection conn = Database.getInstance().getConnection();
        Statement statement = conn.createStatement();
        statement.execute(fileContent);
        statement.closeOnCompletion();

    }


}
