package com.c4networks.imsws.vo;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {

	@JsonProperty(required = false)
	private String c4UserOID;

	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private String mobile;

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
	private RoleDetails roleDetails;

	@JsonProperty(required = false)
	private CompanyDetails companyDetails;

	public final String getC4UserOID() {
		return c4UserOID;
	}

	public final void setC4UserOID(String c4UserOID) {
		this.c4UserOID = c4UserOID;
	}

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final String getMobile() {
		return mobile;
	}

	public final void setMobile(String mobile) {
		this.mobile = mobile;
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

	public final RoleDetails getRoleDetails() {
		return roleDetails;
	}

	public final void setRoleDetails(RoleDetails roleDetails) {
		this.roleDetails = roleDetails;
	}

	public final CompanyDetails getCompanyDetails() {
		return companyDetails;
	}

	public final void setCompanyDetails(CompanyDetails companyDetails) {
		this.companyDetails = companyDetails;
	}

	@Override
	public int hashCode() {
		return Objects.hash(c4UserOID, companyDetails, createdBy, createdDate, email, firstName, lastModifiedBy,
				lastModifiedDate, lastName, mobile, roleDetails, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		return Objects.equals(c4UserOID, other.c4UserOID) && Objects.equals(companyDetails, other.companyDetails)
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastModifiedBy, other.lastModifiedBy)
				&& Objects.equals(lastModifiedDate, other.lastModifiedDate) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(mobile, other.mobile) && Objects.equals(roleDetails, other.roleDetails)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetails [c4UserOID=");
		builder.append(c4UserOID);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", lastModifiedBy=");
		builder.append(lastModifiedBy);
		builder.append(", lastModifiedDate=");
		builder.append(lastModifiedDate);
		builder.append(", roleDetails=");
		builder.append(roleDetails);
		builder.append(", companyDetails=");
		builder.append(companyDetails);
		builder.append("]");
		return builder.toString();
	}

}
