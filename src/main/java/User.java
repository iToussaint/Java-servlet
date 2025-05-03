
public class User {

	
	
	private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String createdAt;
    
    


	public User(int id, String firstName, String lastName, String gender, String dateOfBirth, String createdAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.createdAt = createdAt;
	}

	



	public User(String firstName, String lastName, String gender, String dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}





	public int getId() {
		return id;
	}



	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getDateOfBirth() {
		return dateOfBirth;
	}




	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}




	public String getCreatedAt() {
		return createdAt;
	}




	
}
