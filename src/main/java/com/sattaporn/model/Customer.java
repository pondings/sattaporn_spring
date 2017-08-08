package com.sattaporn.model;
// Generated Aug 7, 2017 6:15:03 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", schema = "public")
public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String name;
	protected String lname;
	protected String address;
	protected String workAddress;
	protected String sirName;
	protected String fullName;
	protected Date createDate;
	protected String createBy;
	protected String code;
	protected String phone;
	protected Date updateDate;
	protected String updateBy;
	protected byte[] document1;
	protected Set<Object> documentations = new HashSet<Object>(0);

	public Customer() {
	}

	public Customer(int id) {
		this.id = id;
	}

	public Customer(int id, String name, String lname, String address, String workAddress, String sirName,
			String fullName, Date createDate, String createBy, String code, String phone, Date updateDate,
			String updateBy, byte[] document1, Set<Object> documentations) {
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.address = address;
		this.workAddress = workAddress;
		this.sirName = sirName;
		this.fullName = fullName;
		this.createDate = createDate;
		this.createBy = createBy;
		this.code = code;
		this.phone = phone;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.document1 = document1;
		this.documentations = documentations;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "lname")
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "work_address")
	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	@Column(name = "sir_name", length = 20)
	public String getSirName() {
		return this.sirName;
	}

	public void setSirName(String sirName) {
		this.sirName = sirName;
	}

	@Column(name = "full_name")
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", length = 13)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "create_by")
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "code", length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "phone", length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "update_date", length = 13)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "update_by")
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "document1")
	public byte[] getDocument1() {
		return this.document1;
	}

	public void setDocument1(byte[] document1) {
		this.document1 = document1;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", targetEntity = Documentation.class)
	public Set<Object> getDocumentations() {
		return this.documentations;
	}

	public void setDocumentations(Set<Object> documentations) {
		this.documentations = documentations;
	}

}
