package by.andrew.zenov.data.dao.impl;

import org.springframework.stereotype.Repository;

import by.andrew.zenov.data.dao.AddressDao;
import by.andrew.zenov.data.model.Address;

@Repository(value = "addressDao")
public class AddressDaoImpl extends AbstractDao<Address, Long> implements AddressDao {

	public AddressDaoImpl() {
		setEntityClass(Address.class);
	}
}
