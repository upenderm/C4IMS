package com.c4networks.imsws.dao;

import java.util.List;

import com.c4networks.imsws.vo.RoleDetails;

public interface RoleDetailsDAO {

	public boolean createRoleDetails(RoleDetails roleDetails);
	
	public boolean createRoleDetails(List<RoleDetails> roleDetails);

}
