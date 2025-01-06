package in.kunal.Entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Councellor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer councellorId;
	private String name;
	private String email;
	private String password;
	private long phone;
	
	@CreationTimestamp
	@Column(name = "CREATED_DATE" , updatable =  false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable =  false)
	private LocalDate updateDate;

	public Integer getCouncellorId() {
		return councellorId;
	}

	public void setCouncellorId(Integer councellorId) {
		this.councellorId = councellorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

}
