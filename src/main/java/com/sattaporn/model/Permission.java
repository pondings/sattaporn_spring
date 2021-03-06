package com.sattaporn.model;
// Generated Aug 25, 2017 11:51:08 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Permission generated by hbm2java
 */
@Entity
@Table(name = "permission", schema = "public")
public class Permission implements java.io.Serializable {

	private int id;
	private MenuPermission menuPermission;
	private String code;
	private String name;
	private String description;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;

	public Permission() {
	}

	public Permission(int id, String code) {
		this.id = id;
		this.code = code;
	}

	public Permission(int id, MenuPermission menuPermission, String code, String name, String description,
			String createBy, Date createDate, String updateBy, Date updateDate) {
		this.id = id;
		this.menuPermission = menuPermission;
		this.code = code;
		this.name = name;
		this.description = description;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_permission_code")
	public MenuPermission getMenuPermission() {
		return this.menuPermission;
	}

	public void setMenuPermission(MenuPermission menuPermission) {
		this.menuPermission = menuPermission;
	}

	@Column(name = "code", nullable = false)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

}
