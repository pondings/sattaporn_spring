package com.sattaporn.model;
// Generated Aug 25, 2017 11:51:08 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MenuPermission generated by hbm2java
 */
@Entity
@Table(name = "menu_permission", schema = "public")
public class MenuPermission implements java.io.Serializable {

	private String code;
	private Menu menu;
	private String name;
	private String description;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	private Set permissions = new HashSet(0);

	public MenuPermission() {
	}

	public MenuPermission(String code) {
		this.code = code;
	}

	public MenuPermission(String code, Menu menu, String name, String description, String createBy, Date createDate,
			String updateBy, Date updateDate, Set permissions) {
		this.code = code;
		this.menu = menu;
		this.name = name;
		this.description = description;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
		this.permissions = permissions;
	}

	@Id

	@Column(name = "code", unique = true, nullable = false)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_code")
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "create_by")
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", length = 13)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "update_by")
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "update_date", length = 13)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menuPermission", targetEntity=Permission.class)
	public Set getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Set permissions) {
		this.permissions = permissions;
	}

}
