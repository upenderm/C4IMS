package com.c4networks.imsws.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.c4networks.imsws.dao.CompanyDetailsDAO;
import com.c4networks.imsws.dao.RoleDetailsDAO;
import com.c4networks.imsws.dao.UserDetailsDAO;
import com.c4networks.imsws.dao.UserSecurityDAO;
import com.c4networks.imsws.utils.AlphaNumericRandomGenerator;
import com.c4networks.imsws.utils.ProductEnum;
import com.c4networks.imsws.vo.CompanyDetails;
import com.c4networks.imsws.vo.ProductDetails;
import com.c4networks.imsws.vo.RoleDetails;
import com.c4networks.imsws.vo.UserDetails;
import com.c4networks.imsws.vo.UserSecurity;

@Service
public class UserCreationService {

	@Autowired
	private CompanyDetailsDAO companyDtlsDAO;

	@Autowired
	private RoleDetailsDAO roleDtlsDAO;

	@Autowired
	private UserDetailsDAO userDtlsDAO;

	@Autowired
	private UserSecurityDAO userSecurityDAO;

	private final String DUMMY_COMPANY_NAME = "DUMMY";
	private final String SYSTEM_ADMIN_COMPANY = "FFFFFFFFFFFFFFFF";
	private final String SYSTEM_ADMIN_AGENT = "AAAAAAAAAAAAAAAA";
	private final String ACTIVE_USER = "ACTIVE";
	private final int version = 1;

	@Transactional
	public void createNewUser(UserDetails usrDtls, UserSecurity usrSec, ProductEnum pEnum) {

		Date date = new Date();

		CompanyDetails companyDtls = new CompanyDetails();
		if (null != usrDtls.getCompanyDetails()) {
			companyDtls.setCompanyOID(usrDtls.getCompanyDetails().getCompanyOID());
			companyDtls.setCompanyID(usrDtls.getCompanyDetails().getCompanyID());
			companyDtls.setCompanyName(usrDtls.getCompanyDetails().getCompanyName());
			companyDtls.setCreatedBy(usrDtls.getCreatedBy());
			companyDtls.setCreatedDate(usrDtls.getCreatedDate());
			companyDtls.setLastModifiedBy(usrDtls.getLastModifiedBy());
			companyDtls.setLastModifiedDate(usrDtls.getLastModifiedDate());
			companyDtls.setPhone(usrDtls.getMobile());
		} else {
			companyDtls.setCompanyOID(AlphaNumericRandomGenerator.generateCompanyObjectIdentifier());
			companyDtls.setCompanyID(AlphaNumericRandomGenerator.generateCompanyIdentifier());
			companyDtls.setCompanyName(DUMMY_COMPANY_NAME);
			companyDtls.setCreatedBy(SYSTEM_ADMIN_COMPANY);
			companyDtls.setCreatedDate(date);
			companyDtls.setLastModifiedBy(SYSTEM_ADMIN_COMPANY);
			companyDtls.setLastModifiedDate(date);
			companyDtls.setPhone(null);
			ProductDetails productDtls = new ProductDetails();
			productDtls.setProductID(pEnum.getProductID());
			productDtls.setProductName(pEnum.getProductName());
			productDtls.setProductDescription(pEnum.getProductDesc());
			productDtls.setProductPath(pEnum.getProductPath());
			companyDtls.setProductDetails(productDtls);
		}
		companyDtlsDAO.createCompanyDetails(companyDtls);

		ProductDetails productDtls = new ProductDetails();
		productDtls.setProductID(pEnum.getProductID());
		productDtls.setProductName(pEnum.getProductName());
		productDtls.setProductDescription(pEnum.getProductDesc());
		productDtls.setProductPath(pEnum.getProductPath());
//		productDtlsDAO.createProductDetails(productDtls);

		RoleDetails rDtls = new RoleDetails();
		rDtls.setCompanyDetails(companyDtls);
		rDtls.setRoleID(AlphaNumericRandomGenerator.generateRoleIdentifier());
		rDtls.setRoleName("STANDARD_AGENT");

		RoleDetails rDtls2 = new RoleDetails();
		rDtls2.setCompanyDetails(companyDtls);
		rDtls2.setRoleID(AlphaNumericRandomGenerator.generateRoleIdentifier());
		rDtls2.setRoleName("STANDARD_AGENT_CUSTOMER");
		List<RoleDetails> rDtlsList = new ArrayList<>();
		rDtlsList.add(rDtls);
		rDtlsList.add(rDtls2);
		roleDtlsDAO.createRoleDetails(rDtlsList);

		UserDetails userDtls = new UserDetails();
		userDtls.setC4UserOID(AlphaNumericRandomGenerator.generateUserIdentifier());
		userDtls.setUserName(usrDtls.getUserName());
		userDtls.setEmail(usrDtls.getEmail());
		userDtls.setFirstName(usrDtls.getFirstName());
		userDtls.setLastName(usrDtls.getLastName());
		userDtls.setMobile(usrDtls.getMobile());
		userDtls.setCreatedBy(SYSTEM_ADMIN_AGENT);
		userDtls.setCreatedDate(date);
		userDtls.setLastModifiedBy(SYSTEM_ADMIN_AGENT);
		userDtls.setLastModifiedDate(date);
		userDtls.setRoleDetails(rDtls);
		userDtls.setCompanyDetails(companyDtls);
		userDtlsDAO.createUserDetails(userDtls);

		UserSecurity userSec = new UserSecurity();
		userSec.setUserOID(userDtls.getC4UserOID());
		userSec.setUserName(usrSec.getUserName());
		userSec.setPassword(usrSec.getPassword());
		userSec.setTempUsername(null);
		userSec.setStatus(ACTIVE_USER);
		userSec.setVersion(version);
		userSec.setCreatedBy(SYSTEM_ADMIN_AGENT);
		userSec.setCreatedDate(date);
		userSec.setLastModifiedBy(SYSTEM_ADMIN_AGENT);
		userSec.setLastModifiedDate(date);
		userSecurityDAO.createUserSecurity(userSec);
	}

}
