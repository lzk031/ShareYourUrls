package formbeans;
//Zekun Lyu
//zlyu
//HW9
import java.util.ArrayList;
import java.util.List;
import org.mybeans.form.FormBean;


public class FavoritesForm extends FormBean {
	private String favoriteUrl;
	private String comment;
	//private String button;

    public String getFavoriteUrl()  { return favoriteUrl; }
    public String getComment()  { return comment; }
    
    public void setFavoriteUrl(String s) { favoriteUrl = s.trim();}
    public void setComment(String s) { comment = s.trim();}
    

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (favoriteUrl == null || favoriteUrl.trim().length() == 0) errors.add("URL is required");
        //if (comment == null || comment.length() == 0) errors.add("Comments is required");

        if (errors.size() > 0) return errors;
        return errors;
    }
}