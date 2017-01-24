package by.andrew.zenov.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pacient", uniqueConstraints = @UniqueConstraint(columnNames = "identity_number") )
public class Pacient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "identity_number", length = 14)
	private String identityNumber;

	@Column(name = "first_name", unique = false, nullable = false, length = 45)
	private String firstName;

	@Column(name = "last_name", unique = false, nullable = false, length = 45)
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Pacient [identityNumber=" + identityNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", department=" + department + ", address=" + address + "]";
	}

}
