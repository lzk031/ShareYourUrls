package formbeans;
//Zekun Lyu
//zlyu
//HW9
import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;



public class RegisterForm extends FormBean {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String confirm;
	
    public String getEmail()  { return email; }
    public String getFirstName()  { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPassword()  { return password; }
    public String getConfirm() { return confirm;}
    
    public void setEmail(String s) { email=s.trim();}
    public void setFirstName(String s) {firstName = s.trim();}
    public void setPassword(String s) { password = s.trim();}
    public void setLastName(String s) { lastName = s.trim();}
    public void setConfirm(String s) { confirm = s.trim();}
    
    
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (email == null || email.trim().length() == 0) errors.add("Email address is required");
        if (firstName == null || firstName.trim().length() == 0) errors.add("First name is required");
        if (lastName == null || lastName.trim().length() == 0) errors.add("Last name is required");
        if (password == null || password.trim().length() == 0) errors.add("Password is required");
        if (confirm == null || confirm.trim().length() == 0) errors.add("Confirm password is required");
        
        if (errors.size() > 0) return errors;
        
        if(confirm.equals(password)==false) errors.add("Confirm password and passwords are not the same");

        if (email.matches(".*[<>\"].*")) errors.add("User Name may not contain angle brackets or quotes");
		
        return errors;
    }
}