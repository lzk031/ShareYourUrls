//Zekun Lyu
//zlyu
//HW9
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.FavoriteDAO;
import model.Model;
import model.UserDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.FavoriteBean;
import databeans.UserBean;
import formbeans.FavoritesForm;


/*
 * Removes a photo.  Given an "id" parameter.
 * Checks to see that id is valid number for a photo and that
 * the logged user is the owner.
 * 
 * Sets up the "userList" and "photoList" request attributes
 * and if successful, forwards back to to "manage.jsp".
 */
public class RemoveAction extends Action {
	private FormBeanFactory<FavoritesForm> formBeanFactory = FormBeanFactory.getInstance(FavoritesForm.class);

	private FavoriteDAO favoriteDAO;
	private UserDAO  userDAO;

    public RemoveAction(Model model) {
    	favoriteDAO = model.getFavoriteDAO();
    	userDAO  = model.getUserDAO();
	}

    public String getName() { return "remove.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

	    	FavoritesForm form = formBeanFactory.create(request);
	    	
	    	String id = request.getParameter("id");
	    	favoriteDAO.delete(Integer.parseInt(id));
	    	
	    	UserBean user = (UserBean) request.getSession().getAttribute("user");

			

    		// Be sure to get the favoriteList after the delete
        	FavoriteBean[] favoriteList = favoriteDAO.getUserFavorites(user.getUserId());
	        request.setAttribute("favoriteList",favoriteList);

	        return "manage.jsp";
		} catch (RollbackException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
		} catch (FormBeanException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
    	}
    }
}
