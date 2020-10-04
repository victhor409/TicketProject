package model.dao;

import java.util.List;

import entities.Ticket;

public interface TicketDao {

	void insert(Ticket obj);
	void update(Ticket obj);
	void deleteById(Integer id);
	Ticket findById(Integer id);
	List<Ticket> findAll();
}
