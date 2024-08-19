package com.c4networks.imsws.dao;

import java.util.List;

import com.c4networks.imsws.vo.CompanyDetails;

public interface CompanyDetailsDAO {
	
	public boolean createCompanyDetails(CompanyDetails companyDtls);
	
	public List<CompanyDetails> getCompanyDetails(String... companyOID);

}
