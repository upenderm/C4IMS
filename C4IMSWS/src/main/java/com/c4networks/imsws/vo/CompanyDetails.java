package com.c4networks.imsws.vo;

import java.util.Date;
import java.util.Objects;

public class CompanyDetails {

	private String companyOID;
	private String companyID;
	private String companyName;
	private String phone;
	private String createdBy;
	private Date createdDate;
	private String lastModifiedBy;
	private Date lastModifiedDate;

	public final String getCompanyOID() {
		return companyOID;
	}

	public final void setCompanyOID(String companyOID) {
		this.companyOID = companyOID;
	}

	public final String getCompanyID() {
		return companyID;
	}

	public final void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public final String getCompanyName() {
		return companyName;
	}

	public final void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
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

	@Override
	public int hashCode() {
		return Objects.hash(companyID, companyName, companyOID, createdBy, createdDate, lastModifiedBy,
				lastModifiedDate, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyDetails other = (CompanyDetails) obj;
		return Objects.equals(companyID, other.companyID) && Objects.equals(companyName, other.companyName)
				&& Objects.equals(companyOID, other.companyOID) && Objects.equals(createdBy, other.createdBy)
				&& Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(lastModifiedBy, other.lastModifiedBy)
				&& Objects.equals(lastModifiedDate, other.lastModifiedDate) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyDetails [companyOID=");
		builder.append(companyOID);
		builder.append(", companyID=");
		builder.append(companyID);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", lastModifiedBy=");
		builder.append(lastModifiedBy);
		builder.append(", lastModifiedDate=");
		builder.append(lastModifiedDate);
		builder.append("]");
		return builder.toString();
	}

}
