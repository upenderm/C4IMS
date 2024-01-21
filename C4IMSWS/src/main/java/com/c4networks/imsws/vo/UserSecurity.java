package com.c4networks.imsws.vo;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSecurity {

	@JsonProperty(required = false)
	private String userOID;

	private String userName;
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

	public final String getUserOID() {
		return userOID;
	}

	public final void setUserOID(String userOID) {
		this.userOID = userOID;
	}

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final String getCreatedBy() {
		return createdBy;
	}

	public final void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public final Date getCreatedDate() {
		return createdDate;
	}

	public final void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public final String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public final void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public final Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public final void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public final Integer getVersion() {
		return version;
	}

	public final void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdBy, createdDate, lastModifiedBy, lastModifiedDate, password, status, userName,
				userOID, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSecurity other = (UserSecurity) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(lastModifiedBy, other.lastModifiedBy)
				&& Objects.equals(lastModifiedDate, other.lastModifiedDate) && Objects.equals(password, other.password)
				&& Objects.equals(status, other.status) && Objects.equals(userName, other.userName)
				&& Objects.equals(userOID, other.userOID) && Objects.equals(version, other.version);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserSecurity [userOID=");
		builder.append(userOID);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", lastModifiedBy=");
		builder.append(lastModifiedBy);
		builder.append(", lastModifiedDate=");
		builder.append(lastModifiedDate);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

	public final String getTempUsername() {
		return tempUsername;
	}

	public final void setTempUsername(String tempUsername) {
		this.tempUsername = tempUsername;
	}

}
