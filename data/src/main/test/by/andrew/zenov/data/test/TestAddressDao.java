package by.andrew.zenov.data.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import by.andrew.zenov.data.TestUtil;
import by.andrew.zenov.data.dao.AddressDao;
import by.andrew.zenov.data.model.Address;

@ContextConfiguration(locations = "classpath:data-spring-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAddressDao {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private TestUtil testUtil;

	@Test
	@Transactional
	@Rollback(true)
	public void testInsertAddress() {
		Address address = testUtil.createAddress();

		int startCount = addressDao.getAll().size();
		addressDao.insert(address);
		int endCount = addressDao.getAll().size();

		Assert.assertEquals(1, endCount - startCount);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetById() {
		Address address = testUtil.createAddress();
		addressDao.insert(address);
		Address addressDb = addressDao.getAll().get(0);
		Long id = addressDb.getAddressId();

		Assert.assertEquals(addressDb, addressDao.get(id));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetAll() {

		Set<Address> addressSet = new HashSet<>();
		int size = testUtil.getRandomInteger(0, 100);

		Address address;
		for (int i = 0; i < size; i++) {
			address = testUtil.createAddress();
			addressSet.add(address);
			addressDao.insert(address);
		}

		Assert.assertEquals(addressSet.size(), addressDao.getAll().size());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateAddress() {
		Address address = testUtil.createAddress();
		addressDao.insert(address);

		String city = testUtil.getRandomString(45);
		String street = testUtil.getRandomString(45);
		String houseNumber = testUtil.getRandomString(5);
		String room = testUtil.getRandomString(5);
		String phone = testUtil.getRandomString(20);

		Address addressDb = addressDao.getAll().get(0);
		addressDb.setHouseNumber(houseNumber);
		address.setCity(city);
		address.setStreet(street);
		address.setRoom(room);
		address.setPhone(phone);
		addressDao.update(addressDb);

		Address addressDb2 = addressDao.getAll().get(0);

		Assert.assertEquals(addressDb, addressDb2);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteAddress() {
		Address address = testUtil.createAddress();
		addressDao.insert(address);
		int size = addressDao.getAll().size();
		Address addressDb = addressDao.getAll().get(0);
		addressDao.delete(addressDb.getAddressId());

		Assert.assertEquals(size - 1, addressDao.getAll().size());
	}

}
