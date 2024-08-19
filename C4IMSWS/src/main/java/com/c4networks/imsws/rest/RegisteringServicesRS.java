package com.c4networks.imsws.rest;

import java.time.Instant;
import java.util.Objects;
import java.util.stream.Stream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.c4networks.imsws.services.UserCreationService;
import com.c4networks.imsws.services.UserDetailsService;
import com.c4networks.imsws.utils.ProductEnum;
import com.c4networks.imsws.vo.C4UserObject;

@Path("/AgentRegisterServices")
public class RegisteringServicesRS {

	@Autowired
	private UserCreationService userCreationService;

	@Autowired
	private UserDetailsService userDtlsService;

	@POST
	@Path("/registerUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerNewUser(C4UserObject c4UserObject) {
		Instant startTime = Instant.now();
		System.out.println("In registerNewUser of RegisterationService");
		Response response = Response.ok().build();
		boolean isValidUserObject = validateUserObject(c4UserObject);

		boolean isUsernameAvailable = userDtlsService.isUsernameAvailable(c4UserObject.getUserDetails().getEmail());

		if (!isValidUserObject) {
			System.out.println("Oops!.. Bad request received");
			response = Response.status(Status.BAD_REQUEST).build();
		} else if (!isUsernameAvailable) {
			response = Response.status(Status.CONFLICT).entity("Data already exists in our records").build();
		} else {
			String key = c4UserObject.getProductTypes().entrySet().iterator().next().getKey();
			userCreationService.createNewUser(c4UserObject.getUserDetails(), c4UserObject.getUserSecurity(),
					ProductEnum.valueOf(key));
			c4UserObject.getProductTypes().put(key, ProductEnum.valueOf(key).getProductPath());
			response = Response.status(Status.CREATED).entity(c4UserObject).build();
		}
		Instant endTime = Instant.now();
		System.out.println("Time taken to process request is :" + endTime.compareTo(startTime) + " seconds");
		return response;
	}

	private boolean validateUserObject(C4UserObject c4UserObject) {
		return (!Stream.of(c4UserObject.getUserDetails(), c4UserObject.getUserSecurity(),
//				c4UserObject.getUserDetails().getCompanyDetails(),
//				c4UserObject.getUserDetails().getCompanyDetails().getCompanyID(),
//				c4UserObject.getUserDetails().getCompanyDetails().getCompanyName(),
//				c4UserObject.getUserDetails().getCompanyDetails().getCompanyOID(),
//				c4UserObject.getUserDetails().getCompanyDetails().getCreatedBy(),
//				c4UserObject.getUserDetails().getCompanyDetails().getCreatedDate(),
//				c4UserObject.getUserDetails().getCompanyDetails().getLastModifiedBy(),
//				c4UserObject.getUserDetails().getCompanyDetails().getLastModifiedDate(),
//				c4UserObject.getUserDetails().getCompanyDetails().getPhone(),
//				c4UserObject.getUserDetails().getRoleDetails(),
//				c4UserObject.getUserDetails().getRoleDetails().getRoleID(),
//				c4UserObject.getUserDetails().getRoleDetails().getRoleName(),
//				c4UserObject.getUserDetails().getC4UserOID(), 
				c4UserObject.getUserDetails().getUserName(), c4UserObject.getUserDetails().getEmail(),
				c4UserObject.getUserDetails().getFirstName(), c4UserObject.getUserDetails().getLastName(),
				c4UserObject.getUserDetails().getMobile(),
//				c4UserObject.getUserDetails().getCreatedBy(), c4UserObject.getUserDetails().getCreatedDate(),
//				c4UserObject.getUserDetails().getLastModifiedBy(), c4UserObject.getUserDetails().getLastModifiedDate(),
				c4UserObject.getUserSecurity().getUserName(), c4UserObject.getUserSecurity().getPassword(),
//				c4UserObject.getUserSecurity().getUserOID(), c4UserObject.getUserSecurity().getTempUsername(),
//				c4UserObject.getUserSecurity().getCreatedBy(), c4UserObject.getUserSecurity().getCreatedDate(),
//				c4UserObject.getUserSecurity().getLastModifiedBy(),
//				c4UserObject.getUserSecurity().getLastModifiedDate(), c4UserObject.getUserSecurity().getStatus(),
//				c4UserObject.getUserSecurity().getVersion()
				c4UserObject.getProductTypes().entrySet().iterator().next().getKey()
				).anyMatch(Objects::isNull)
				&& c4UserObject.getUserDetails().getEmail().equals(c4UserObject.getUserSecurity().getUserName())
				&& c4UserObject.getUserDetails().getEmail().equals(c4UserObject.getUserDetails().getUserName()));
	}

}
