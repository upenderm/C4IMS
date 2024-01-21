package com.c4networks.imsws.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;

import com.c4networks.imsws.services.ApplicationContextProviderService;
import com.c4networks.imsws.services.UserDetailsService;
import com.c4networks.imsws.vo.UserDetails;
import com.c4networks.imsws.vo.UserSecurity;

@Path("/AgentServices")
public class UserServicesRS {

	@Autowired
	private UserDetailsService userDtlsService;

	@Autowired
	private ApplicationContextProviderService applicationContext;

	@GET
	@Path("/authenticateUserSecurity")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUserSecurity(@QueryParam(value = "username") final String userName,
			@QueryParam(value = "password") final String password) {
		System.out.println("In UserServicesRS.authenticateUserSecurity....**..");

		UserSecurity userSecurity = userDtlsService.authenticateUserCredentials(userName, password);

		return Response.status(200).entity(userSecurity).build();
	}

	@GET
	@Path("/getAgentsList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> getAvailableAgents() {
		System.out.println("In UserServicesRS.getAvailableAgents....**..");
		printBeans();
		List<UserDetails> availableUsers = new ArrayList<>();
		availableUsers = userDtlsService.getAllUsersList();
		return availableUsers;
	}

	private String[] printBeans() {
		AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getApplicationContext()
				.getAutowireCapableBeanFactory();
		if (autowireCapableBeanFactory instanceof SingletonBeanRegistry) {
			String[] singletonNames = ((SingletonBeanRegistry) autowireCapableBeanFactory).getSingletonNames();
			for (String singleton : singletonNames) {
				System.out.println(singleton);
			}
			return singletonNames;
		}
		return null;
	}
}
