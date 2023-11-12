package week4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ProjectOne {
		private static final String URL= "jdbc:mysql://localhost:3306/your_database";
	       private static final String USER = "root";
	       private static final String PASSWORD = "Bienvenu6676@";

        // Method 1: createTable
        public void createTable() {
            // Using try-with-resources to automatically close resources
            try (
                    // Establish a connection to the database
                    Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
                    // Create a statement
                    Statement statement = connection.createStatement()
            ) {
                // SQL query to create the table
                String createTableSQL = "CREATE TABLE IF NOT EXISTS ProjectTable (Name TEXT,Email TEXT,Age INTEGER,Location TEXT,Designation TEXT)";
                // Execute the query
                statement.execute(createTableSQL);
                System.out.println("Table created successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Method 2: populateTable
        public int populateTable() {
            int count = 0;
            try (
                    // Establish a connection to the database
                    Connection connection = DriverManager.getConnectionalhost(URL,USER,PASSWORD);
                    // Create a prepared statement
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ProjectTable (Name, Email, Age, Location, Designation) VALUES (?, ?, ?, ?, ?)");
                    // Create a Scanner for user input
                    Scanner scanner = new Scanner(System.in)
            ) {
                // Loop to populate the database ten times
                for (int i = 0; i < 10; i++) {
                    System.out.println("Enter Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter Age:");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // This is newline character
                    System.out.println("Enter Location:");
                    String location = scanner.nextLine();
                    System.out.println("Enter Designation:");
                    String designation = scanner.nextLine();
                    // Set parameters and execute the prepared statement
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, email);
                    preparedStatement.setInt(3, age);
                    preparedStatement.setString(4, location);
                    preparedStatement.setString(5, designation);
                   // rowsEffect = preparedStatement.executeUpdate();
		   preparedStatement.execute();
                    count++;
                }
                System.out.println("Table populated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return count;
        }

    public static void main(String[] args) {
        ProjectOne project = new ProjectOne();
        project.createTable();
        project.populateTable();
    }


}
