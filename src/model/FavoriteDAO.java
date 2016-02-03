package model;
//Zekun Lyu
//zlyu
//HW9
import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.FavoriteBean;


public class FavoriteDAO extends GenericDAO<FavoriteBean> {
	public FavoriteDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(FavoriteBean.class, tableName, cp);
	}
	
	public FavoriteBean [] getUserFavorites(int usrId) throws RollbackException{
		try{
			Transaction.begin();
			FavoriteBean [] beans;
			beans = match(MatchArg.equals("userId", usrId));
			Transaction.commit();
			return beans;
		}
		finally{
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}
	public void create(FavoriteBean bean) throws RollbackException{
		createAutoIncrement(bean);
	}
	public void updateClick(FavoriteBean bean) throws RollbackException{
		try{
			Transaction.begin();
			bean.setClick(bean.getClick()+1);
			update(bean);
			Transaction.commit();
		}finally{
			if (Transaction.isActive())
				Transaction.rollback();
		}
		
	}
}
