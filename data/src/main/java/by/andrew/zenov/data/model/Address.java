package by.andrew.zenov.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "address", uniqueConstraints = @UniqueConstraint(columnNames = "address_id") )
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;

	@Column(name = "city", unique = false, nullable = false, length = 45)
	private String city;

	@Column(name = "street", unique = false, nullable = false, length = 45)
	private String street;

	@Column(name = "house_number", unique = false, nullable = false, length = 5)
	private String houseNumber;

	@Column(name = "room", unique = false, nullable = false, length = 5)
	private String room;

	@Column(name = "phone", unique = false, nullable = false, length = 20)
	private String phone;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", street=" + street + ", houseNumber="
				+ houseNumber + ", room=" + room + ", phone=" + phone + "]";
	}

}
