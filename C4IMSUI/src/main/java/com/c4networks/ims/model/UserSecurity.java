package com.c4networks.ims.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSecurity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty(required = false)
	private String userOID;

	@JsonProperty(required = false)
	private String userName;

	@JsonProperty(required = false)
	private String password;

	@JsonProperty(required = false)
	private String status;

	@JsonProperty(required = false)
	private String createdBy;

	@JsonProperty(required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;

	@JsonProperty(required = false)
	private String lastModifiedBy;

	@JsonProperty(required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date lastModifiedDate;

	@JsonProperty(required = false)
	private Integer version;

	@JsonProperty(required = false)
	private String tempUsername;

	private String path;

	public String getUserOID() {
		return userOID;
	}

	public void setUserOID(String userOID) {
		this.userOID = userOID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(createdBy, createdDate, lastModifiedBy, lastModifiedDate, password, status, userName,
//				userOID, version);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		UserSecurity other = (UserSecurity) obj;
//		return Objects.equals(createdBy, other.createdBy) && Objects.equals(createdDate, other.createdDate)
//				&& Objects.equals(lastModifiedBy, other.lastModifiedBy)
//				&& Objects.equals(lastModifiedDate, other.lastModifiedDate) && Objects.equals(password, other.password)
//				&& Objects.equals(status, other.status) && Objects.equals(userName, other.userName)
//				&& Objects.equals(userOID, other.userOID) && Objects.equals(version, other.version);
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("UserSecurity [userOID=");
//		builder.append(userOID);
//		builder.append(", userName=");
//		builder.append(userName);
//		builder.append(", password=");
//		builder.append(password);
//		builder.append(", status=");
//		builder.append(status);
//		builder.append(", createdBy=");
//		builder.append(createdBy);
//		builder.append(", createdDate=");
//		builder.append(createdDate);
//		builder.append(", lastModifiedBy=");
//		builder.append(lastModifiedBy);
//		builder.append(", lastModifiedDate=");
//		builder.append(lastModifiedDate);
//		builder.append(", version=");
//		builder.append(version);
//		builder.append("]");
//		return builder.toString();
//	}

	public String getTempUsername() {
		return tempUsername;
	}

	public void setTempUsername(String tempUsername) {
		this.tempUsername = tempUsername;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
