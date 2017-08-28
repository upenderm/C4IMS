package com.c4networks.ims.dao;

import com.c4networks.ims.model.UserDetailsBean;

public interface UserDetailsDao {

	public Integer registerNewUser(Integer seqId, UserDetailsBean userBean);

	public Integer processUserLogin(String userName, String password);

}
