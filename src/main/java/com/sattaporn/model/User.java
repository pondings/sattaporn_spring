package com.sattaporn.model;
// Generated Aug 26, 2017 12:04:35 AM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.sattaporn.dto.PermissionAccessDTO;

/**
 * User generated by hbm2java
 */
@SqlResultSetMapping(name = "permissionDTO", classes = {
		@ConstructorResult(targetClass = PermissionAccessDTO.class, columns = { @ColumnResult(name = "menucode"),
				@ColumnResult(name = "userid"), @ColumnResult(name = "permission"), @ColumnResult(name = "menuname")

		}) })

@Entity
@Table(name = "user", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class User implements java.io.Serializable {

	private int id;
	private Employee employee;
	private String code;
	private String username;
	private String password = "";
	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;
	private Boolean isActive;
	private Boolean isBlocked;
	private Set roles = new HashSet(0);

	public User() {
	}

	public User(Employee employee) {
		this.employee = employee;
	}

	public User(Employee employee, String code, String username, String password, Date createDate, String createBy,
			Date updateDate, String updateBy, Boolean isActive, Boolean isBlocked, Set roles) {
		this.employee = employee;
		this.code = code;
		this.username = username;
		this.password = password;
		this.createDate = createDate;
		this.createBy = createBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.isActive = isActive;
		this.isBlocked = isBlocked;
		this.roles = roles;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "employee"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "code", unique = true, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "username", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Column(name = "is_active")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "is_blocked")
	public Boolean getIsBlocked() {
		return this.isBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = Role.class)
	public Set getRoles() {
		return this.roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

}
