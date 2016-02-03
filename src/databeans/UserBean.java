package databeans;
//Zekun Lyu
//zlyu
//HW9
import org.genericdao.PrimaryKey;

@PrimaryKey("userId")
public class UserBean {
	private int userId;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	
	public String getPassword() {
		return password;
	}

	public int getUserId() {
		return userId;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getEmail(){
		return email;
	}

	public void setPassword(String s) {
		password = s;
	}

	public void setUserId(int id) {
		userId = id;
	}
	
	public void setFirstName(String fn){
		firstName = fn;
	}
	
	public void setLastName(String ln){
		lastName = ln;
	}
	
	public void setEmail(String em){
		email = em;
	}
}
