//Zekun Lyu
//zlyu
//HW9
package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;

import databeans.FavoriteBean;
import databeans.UserBean;

public class Model {
	private FavoriteDAO favoriteDAO;
	private UserDAO  userDAO;

	public Model(ServletConfig config) throws ServletException, RollbackException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL    = config.getInitParameter("jdbcURL");
			
			ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
			userDAO  = new UserDAO(pool, "zlyu_user");
			favoriteDAO = new FavoriteDAO( pool, "zlyu_favorite");
			
			if (userDAO.getCount()==0){
				UserBean usr1 = new UserBean();
				usr1.setEmail("lzk031@gmail.com");
				usr1.setFirstName("Zekun");
				usr1.setLastName("Lyu");
				usr1.setPassword("123");
				userDAO.create(usr1);
				
				FavoriteBean f1 = new FavoriteBean();
				f1.setFavoriteUrl("www.baidu.com");
				f1.setClick(0);
				f1.setComment("Search tool");
				f1.setUserId(usr1.getUserId());
				favoriteDAO.create(f1);
				// more users to be created
			}
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
	
	public FavoriteDAO getFavoriteDAO() { return favoriteDAO; }
	public UserDAO  getUserDAO()  { return userDAO;  }
}
