package by.andrew.zenov.data;

import java.util.Random;

import org.springframework.stereotype.Service;

import by.andrew.zenov.data.model.Address;
import by.andrew.zenov.data.model.Department;
import by.andrew.zenov.data.model.Pacient;

@Service(value = "testUtil")
public class TestUtil {

	public String getRandomString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	public int getRandomInteger(int low, int high) {
		Random r = new Random();
		int result = r.nextInt(high - low) + low;
		return result;
	}

	public Pacient createPacient(Address address, Department department) {
		Pacient pacient = new Pacient();
		pacient.setFirstName(getRandomString(45));
		pacient.setLastName(getRandomString(45));
		pacient.setIdentityNumber(getRandomString(14));
		pacient.setAddress(address);
		pacient.setDepartment(department);
		return pacient;
	}

	public Address createAddress() {
		Address address = new Address();
		address.setCity(getRandomString(45));
		address.setStreet(getRandomString(45));
		address.setHouseNumber(getRandomString(5));
		address.setRoom(getRandomString(5));
		address.setPhone(getRandomString(20));
		return address;
	}

	public Department createDepartment() {
		Department department = new Department();
		department.setName(getRandomString(80));
		department.setDescription(getRandomString(1000));
		return department;
	}
}
