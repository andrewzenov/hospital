package by.andrew.zenov.data.dao.impl;

import org.springframework.stereotype.Repository;

import by.andrew.zenov.data.dao.PacientDao;
import by.andrew.zenov.data.model.Pacient;

@Repository(value = "pacientDao")
public class PacientDaoImpl extends AbstractDao<Pacient, String> implements PacientDao {

	public PacientDaoImpl() {
		setEntityClass(Pacient.class);
	}
}
