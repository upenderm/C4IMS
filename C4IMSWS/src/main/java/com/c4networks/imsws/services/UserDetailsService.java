package com.c4networks.imsws.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.imsws.dao.CompanyDetailsDAO;
import com.c4networks.imsws.dao.ProductDetailsDAO;
import com.c4networks.imsws.dao.UserDetailsDAO;
import com.c4networks.imsws.dao.UserSecurityDAO;
import com.c4networks.imsws.vo.C4UserObject;
import com.c4networks.imsws.vo.CompanyDetails;
import com.c4networks.imsws.vo.ProductDetails;
import com.c4networks.imsws.vo.UserDetails;
import com.c4networks.imsws.vo.UserSecurity;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsDAO userDtlsDAO;

	@Autowired
	private UserSecurityDAO userSecurityDAO;

	@Autowired
	private CompanyDetailsDAO companyDetailsDAO;

	@Autowired
	private ProductDetailsDAO productDetailsDAO;

	public List<UserDetails> getAllUsersList() {

		return userDtlsDAO.getAllUsersList();
	}

	public C4UserObject authenticateUserCredentials(String username, String password) {
		C4UserObject c4UserObject = new C4UserObject();
		UserSecurity userSecurity = userSecurityDAO.authenticateUserSecurity(username, password);
		if (null != userSecurity) {
			c4UserObject.setUserSecurity(userSecurity);
			String[] userArr = { userSecurity.getUserOID() };
			List<UserDetails> userDetails = userDtlsDAO.getUserDetailsById(userArr);
			if (!userDetails.isEmpty() && null != userDetails.get(0)) {
				c4UserObject.setUserDetails(userDetails.get(0));
				String[] companyArr = { userDetails.get(0).getCompanyDetails().getCompanyOID() };
				List<CompanyDetails> companyDetails = companyDetailsDAO.getCompanyDetails(companyArr);
				if (!companyDetails.isEmpty()) {
					String[] productArr = { companyDetails.get(0).getProductDetails().getProductID() };
					List<ProductDetails> productDetails = productDetailsDAO.getProductDetails(productArr);
					Map<String, String> productMap = new HashMap<>();
					productMap.put(productDetails.get(0).getProductID(), productDetails.get(0).getProductPath());
					c4UserObject.setProductTypes(productMap);
				}
			}
		}
		return c4UserObject;
	}

	public boolean isUsernameAvailable(String email) {
		UserSecurity userSecurity = userSecurityDAO.findUserByUsername(email);
		return (null == userSecurity);
	}

}
