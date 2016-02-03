package model;
//Zekun Lyu

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.UserBean;



public class UserDAO extends GenericDAO<UserBean> {
	public UserDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(UserBean.class, tableName, cp);
	}
	public UserBean read(String emailAddress) throws RollbackException 
	{
		try{
			Transaction.begin();
			UserBean usrBean;
			UserBean [] bean = match(MatchArg.equals("email", emailAddress));
			if (bean.length==0){
				usrBean = null;
			}else{
				usrBean = bean[0];
			}
			Transaction.commit();
			return usrBean;
		}
		finally{
			if (Transaction.isActive()){
				Transaction.rollback();
			}
		}
	}
	public void create(UserBean usrBean) throws RollbackException{
		createAutoIncrement(usrBean);		
	}
	
	public UserBean[] getUsers() throws RollbackException {
		UserBean[] users = match();
		return users;
	}
}

