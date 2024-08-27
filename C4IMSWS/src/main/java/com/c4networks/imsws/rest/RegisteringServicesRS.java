package com.c4networks.imsws.rest;

import java.time.Instant;
import java.util.Objects;
import java.util.stream.Stream;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.c4networks.imsws.services.UserCreationService;
import com.c4networks.imsws.services.UserDetailsService;
import com.c4networks.imsws.utils.ProductEnum;
import com.c4networks.imsws.vo.Employee;
import com.c4networks.imsws.vo.IMSCommonVO;
import com.c4networks.imsws.vo.IMSErrorMessage;

@Path("/AgentRegisterServices")
public class RegisteringServicesRS {

	@Autowired
	private UserCreationService userCreationService;

	@Autowired
	private UserDetailsService userDtlsService;

	@POST
	@Path("/registerDummy")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerDummy(Employee employee) {
		if (null != employee) {
			if (null != employee.getEmpID() && null != employee.getEmpName()) {
				employee.setEmpDtls(employee.getEmpID() + " - " + employee.getEmpName());
			}
			if (null != employee.getDepartment()) {
				employee.getDepartment()
						.setDeptDetails(employee.getDepartment().getDeptId() + employee.getDepartment().getDeptName());
			}
		}
		return Response.status(Status.OK).entity(employee).build();

	}

	@POST
	@Path("/registerUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerNewUser(IMSCommonVO imsCommonVO) {
		Instant startTime = Instant.now();
		System.out.println("In registerNewUser2 of RegisterationService");
		ResponseBuilder responseBuilder = Response.ok();
		boolean isValidUserObject = validateUserObject(imsCommonVO);
		if (!isValidUserObject) {
			System.out.println("Oops!.. Bad request received");
			return responseBuilder.status(Status.BAD_REQUEST).build();
		}
		boolean isUsernameAvailable = userDtlsService.isUsernameAvailable(imsCommonVO.getEmail());
		if (!isUsernameAvailable) {
			imsCommonVO.setImsErrorMsg(new IMSErrorMessage("IMS001",
					"The Email address already exists in our records. Please try another."));
			imsCommonVO.setClientTarget("");
			return responseBuilder.status(Status.OK).entity(imsCommonVO).build();
		}
		String key = imsCommonVO.getClientTarget();
		userCreationService.createNewUser2(imsCommonVO, ProductEnum.valueOf(key));
		imsCommonVO.setClientTarget(ProductEnum.valueOf(key).getProductPath());

		Instant endTime = Instant.now();
		System.out.println("Time taken to process request is :" + endTime.compareTo(startTime) + " seconds");

		Cookie tokenCookie = new Cookie("C4TOKEN2", "C4NetworkToken2", "/", "localhost");
		NewCookie newCookie = new NewCookie(tokenCookie);
		responseBuilder.cookie(newCookie);
		return responseBuilder.status(Status.CREATED).entity(imsCommonVO).build();
	}

	private boolean validateUserObject(IMSCommonVO imsCommonVO) {
		return (!Stream
				.of(imsCommonVO, imsCommonVO.getEmail(), imsCommonVO.getFirstName(), imsCommonVO.getLastName(),
						imsCommonVO.getMobile(), imsCommonVO.getPassword(), imsCommonVO.getClientTarget())
				.anyMatch(Objects::isNull));
	}

}
