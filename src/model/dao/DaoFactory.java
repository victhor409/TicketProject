package model.dao;

import db.DB;
import model.dao.impl.TicketDaoJDBC;

public class DaoFactory {

	public static TicketDao createTicketDao() {
		return new TicketDaoJDBC(DB.getConnection());
	}
}
