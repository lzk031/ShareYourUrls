package formbeans;
//Zekun Lyu
//zlyu
//HW9
import java.util.ArrayList;
import java.util.List;


import org.mybeans.form.FormBean;


public class LoginForm extends FormBean {
	private String email;
	private String password;
    public String getEmail()  { return email; }
    public String getPassword()  { return password; }

    public void setEmail(String s) { email = s.trim();}
	public void setPassword(String s)  { password = s.trim(); }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (email == null || email.trim().length() == 0) errors.add("Email address is required");
        if (password == null || password.trim().length() == 0) errors.add("Password is required");
        if (errors.size() > 0) return errors;

        if (email.matches(".*[<>\"].*")) errors.add("User Name may not contain angle brackets or quotes");
		
        return errors;
    }
}
