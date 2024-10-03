import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) throws SQLException {
        String fileContent = null;
        try {
            fileContent = Database.getSQLFromResource("sql/populate_db.sql"); // Get file path from input argument

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        Connection connection = Database.getInstance().getConnection();
        Statement statement = connection.createStatement();
        statement.execute(fileContent);
        statement.closeOnCompletion();

    }

}