package EazyRooM.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Eazy
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String utype;
	private String name;
	private long contno;
	private double rent;
	private String city;
	private int pswd;
	private String gender;
	private String address;
	
	
	
	

	public Eazy(int id, String utype, String name, long contno, double rent, String city, int pswd, String gender,
			String address) {
		super();
		this.id = id;
		this.utype = utype;
		this.name = name;
		this.contno = contno;
		this.rent = rent;
		this.city = city;
		this.pswd = pswd;
		this.gender = gender;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Eazy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContno() {
		return contno;
	}
	public void setContno(long contno) {
		this.contno = contno;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPswd() {
		return pswd;
	}
	public void setPswd(int pswd) {
		this.pswd = pswd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Eazy [id=" + id + ", utype=" + utype + ", name=" + name + ", contno=" + contno + ", rent=" + rent
				+ ", city=" + city + ", pswd=" + pswd + ", gender=" + gender + "]";
	}
	
	
	
}
