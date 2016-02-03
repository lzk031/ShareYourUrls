package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FavoriteDAO;
import model.Model;
import model.UserDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.FavoriteBean;
import databeans.UserBean;
import formbeans.FavoritesForm;


public class AddFavoriteAction extends Action {
	private FormBeanFactory<FavoritesForm> formBeanFactory = FormBeanFactory.getInstance(FavoritesForm.class);

	private UserDAO userDAO;
	private FavoriteDAO favoriteDAO;
	public AddFavoriteAction(Model model){
    	favoriteDAO = model.getFavoriteDAO();
    	userDAO  = model.getUserDAO();
		
	}
	public String getName() {
		// TODO Auto-generated method stub
		return "addFavorite.do";
	}

	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
		try {
			request.setAttribute("userList",userDAO.getUsers());

	    	FavoritesForm form = formBeanFactory.create(request);
	    	request.setAttribute("form",form);
	    	HttpSession session = request.getSession(true);
	    	UserBean userBean = (UserBean) session.getAttribute("user");
	    	
	        
	    	if (!form.isPresent()) {
	            return "manage.jsp";
	        }

	    	errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {

		    	FavoriteBean[] beans = favoriteDAO.getUserFavorites(userBean.getUserId());
		        request.setAttribute("favoriteList",beans);
				return "manage.jsp";
			}

			FavoriteBean favoriteBean = new FavoriteBean();
			favoriteBean.setUserId(userBean.getUserId());
			favoriteBean.setFavoriteUrl(form.getFavoriteUrl());
			favoriteBean.setComment(form.getComment());
			favoriteBean.setClick(0);

			favoriteDAO.create(favoriteBean);

			
        	FavoriteBean[] favoriteBeans = favoriteDAO.getUserFavorites(userBean.getUserId());
	        request.setAttribute("favoriteList",favoriteBeans);
	        
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
