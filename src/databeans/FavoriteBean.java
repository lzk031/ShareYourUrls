package databeans;
//Zekun Lyu
//zlyu
//HW9
import org.genericdao.PrimaryKey;

@PrimaryKey("favoriteId")
public class FavoriteBean {
	private int favoriteId;
	private int userId;
	private String favoriteUrl;
	private String comment;
	private int click;
	
	public int getFavoriteId(){
		return favoriteId;
	}
	
	public int getUserId(){
		return userId;
	}
	
	public String getFavoriteUrl(){
		return favoriteUrl;
	}
	
	public String getComment(){
		return comment;
	}
	
	public int getClick(){
		return click;
	}
	
	public void setFavoriteId(int fId){
		favoriteId = fId;		
	}
	
	public void setUserId(int uId){
		userId = uId;
	}
	
	public void setFavoriteUrl(String url){
		favoriteUrl = url;
	}
	
	public void setComment(String comm){
		comment = comm;
	}
	public void setClick(int clickCount){
		click = clickCount;
	}
	
}
