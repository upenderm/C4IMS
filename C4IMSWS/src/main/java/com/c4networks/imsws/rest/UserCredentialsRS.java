package com.c4networks.imsws.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.c4networks.imsws.services.UserDetailsService;
import com.c4networks.imsws.vo.C4UserObject;
import com.c4networks.imsws.vo.IMSCommonVO;

@Path("/AgentServices")
public class UserCredentialsRS {
	
	@Autowired
	private UserDetailsService userDtlsService;

	@POST
	@Path("/authenticateUserSecurity")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUserSecurity(IMSCommonVO imsCommonVO) {
		System.out.println("In UserCredentialsRS.authenticateUserSecurity....**..");

		C4UserObject c4UserObject = userDtlsService.authenticateUserCredentials(imsCommonVO);
		if(c4UserObject.getUserDetails()!=null && c4UserObject.getUserDetails().getCompanyDetails()!=null) {
			Cookie tokenCookie = new Cookie("C4TOKEN", c4UserObject.getUserDetails().getCompanyDetails().getCompanyOID(), "/", "localhost");
			NewCookie newCookie = new NewCookie(tokenCookie);
			return Response.status(200).entity(imsCommonVO).cookie(newCookie).build();
		}

		return Response.status(200).entity(c4UserObject).build();
	}

}
