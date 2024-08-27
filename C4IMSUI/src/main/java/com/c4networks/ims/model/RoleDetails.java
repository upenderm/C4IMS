package com.c4networks.ims.model;

import java.util.Objects;

public class RoleDetails {

	private String roleID;
	private String roleName;
	private CompanyDetails companyDetails;

	public final String getRoleID() {
		return roleID;
	}

	public final void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public final String getRoleName() {
		return roleName;
	}

	public final void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public final CompanyDetails getCompanyDetails() {
		return companyDetails;
	}

	public final void setCompanyDetails(CompanyDetails companyDetails) {
		this.companyDetails = companyDetails;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyDetails, roleID, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleDetails other = (RoleDetails) obj;
		return Objects.equals(companyDetails, other.companyDetails) && Objects.equals(roleID, other.roleID)
				&& Objects.equals(roleName, other.roleName);
	}

}
