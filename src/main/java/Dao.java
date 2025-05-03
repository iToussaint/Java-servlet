import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class Dao {
	private final String SELECT_ALL_USERS = "SELECT * FROM users;";
	private final String INSERT_USER = "INSERT INTO users ( first_name, last_name, gender, date_of_birth ) VALUES ( ?, ?, ?, ? );";
	private final String DELETE_USER = "DELETE FROM users WHERE id = ?;";
	private final String UPDATE_USER = "UPDATE users SET first_name = ?, last_name = ?, gender = ?, date_of_birth = ? WHERE id = ?;";
	private final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?;";
	private final String SELECT_USERS_BY_GENDER = "SELECT * FROM users WHERE gender = ?;";
	



    public Connection connector(){
        String JDBCDriver = "com.mysql.cj.jdbc.Driver";
        String dbPassword = "Toussaint@250";
        String dbUsername = "root";
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/servlet_lab";

        Connection connection = null;
        try {

            Class.forName(JDBCDriver);

            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

        return connection;


    }


    public List<User> getAllUsers(String column, String value){

       List<User> users = new ArrayList<>();

       try {

    	   PreparedStatement preparedStatement = connector().prepareStatement("SELECT * FROM users WHERE " + column +" LIKE ?");
   		preparedStatement.setString(1, value + "%");
   		
   		ResultSet resultSet = preparedStatement.executeQuery();

           

           while (resultSet.next()) {
               users.add(new User(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("gender"), resultSet.getString("date_of_birth"), resultSet.getString("created_at")));
           }
       }
       catch (Exception exception){
           exception.printStackTrace();
       }

       return users;


    }
    
    public List<User> getAllUsers(){

        List<User> users = new ArrayList<>();

        try {

     	   Statement statement = connector().createStatement();
    		
    		
    		ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);

            

            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("gender"), resultSet.getString("date_of_birth"), resultSet.getString("created_at")));
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

        return users;


     }
    
    
    public void insertUser(User user) {
    	
    	try {
			PreparedStatement preparedStatement = connector().prepareStatement(INSERT_USER);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getGender());
			preparedStatement.setString(4, user.getDateOfBirth());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    }
    
    public void deleteUser(int id) {
    	
    	try {
			PreparedStatement preparedStatement = connector().prepareStatement(DELETE_USER);
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
public void deleteUsers(String[] ids) {
	
	for(String id : ids) {
		try {
			PreparedStatement preparedStatement = connector().prepareStatement(DELETE_USER);
			preparedStatement.setInt(1, Integer.parseInt(id));
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	}
		
    	
    	
    
    public void updateUser(User user, int id) {
    	try {
			PreparedStatement preparedStatement = connector().prepareStatement(UPDATE_USER);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getGender());
			preparedStatement.setString(4, user.getDateOfBirth());
			preparedStatement.setInt(5, id);
			
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public User getUserById(int id) {
    	
    	User user = null;
    	
    	try {
			PreparedStatement preparedStatement = connector().prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				user = new User(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("gender"), resultSet.getString("date_of_birth"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return user;
    	
    	
    }
    
public List<User> getUsersByGender(String gender) {
	
	List<User> users = new ArrayList<>();
    	
 
    	
    	try {
			PreparedStatement preparedStatement = connector().prepareStatement(SELECT_USERS_BY_GENDER);
			preparedStatement.setString(1, gender);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				users.add(new User(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("gender"), resultSet.getString("date_of_birth"), resultSet.getString("created_at")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return users;
    	
    	
    }

	public List<User> searchUserBy(String column, String value){
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users WHERE " + column +" LIKE '?%'";
		
		try {
		PreparedStatement preparedStatement = connector().prepareStatement(query);
		preparedStatement.setString(1, value);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			users.add(new User(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("gender"), resultSet.getString("date_of_birth"), resultSet.getString("created_at")));

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return users;
		
		
	}
    
    
    
    
    
    public void testConnection() {
        try (Connection conn = connector()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Connection to the database was successful!");
            } else {
                System.out.println("❌ Connection failed or is closed.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error while connecting to the database:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Dao().testConnection();
    }


}
