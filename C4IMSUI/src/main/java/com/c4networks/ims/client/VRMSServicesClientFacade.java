package com.c4networks.ims.client;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.c4networks.ims.model.C4UserObject;
import com.c4networks.ims.model.Department;
import com.c4networks.ims.model.Employee;
import com.c4networks.ims.model.IMSCommonVO;

@Component
public class VRMSServicesClientFacade {

	private String VRMS_SERVICES_CONTEXT_URL = "http://localhost:8080/C4IMSWS/rest";
	private String VRMS_SERVICES_AGENT_AUTHENTICATION_CONTEXT = "/AgentServices";
	private String VRMS_SERVICES_AGENT_AUTHENTICATION = "/authenticateUserSecurity";
	private String VRMS_SERVICES_AGENT_REGISTERATION_CONTEXT = "/AgentRegisterServices";
	private String VRMS_SERVICES_AGENT_REGISTERATION = "/registerUser";

	@Autowired
	private RestTemplate restTemplate;

	public IMSCommonVO processUserLogin(IMSCommonVO imsCommonVO, HttpServletResponse httpResponse) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<IMSCommonVO> entity = new HttpEntity<>(imsCommonVO, headers);

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(VRMS_SERVICES_CONTEXT_URL
				+ VRMS_SERVICES_AGENT_AUTHENTICATION_CONTEXT + VRMS_SERVICES_AGENT_AUTHENTICATION);
		
		ResponseEntity<IMSCommonVO> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.POST, entity, IMSCommonVO.class);
		if(response.getStatusCode().equals(HttpStatus.OK)) {
			imsCommonVO = response.getBody();
			readCookiesFromAPIResponse(httpResponse, response);
		}

		return imsCommonVO;
	}

	public IMSCommonVO processUserRegisteration(IMSCommonVO imsCommonVO, HttpServletResponse httpResponse) {
		IMSCommonVO responseVO = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<IMSCommonVO> entity = new HttpEntity<>(imsCommonVO, headers);

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(VRMS_SERVICES_CONTEXT_URL
				+ VRMS_SERVICES_AGENT_REGISTERATION_CONTEXT + VRMS_SERVICES_AGENT_REGISTERATION);

		ResponseEntity<IMSCommonVO> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.POST, entity, IMSCommonVO.class);
		System.out.println(">>----response status code------->" + response.getStatusCode());
		System.out.println(">>----response body------->" + response.getBody());
		System.out.println(">>----response headers------->" + response.getHeaders());
		if (response.getStatusCode().equals(HttpStatus.CREATED)) {
			System.out.println("******Client facade received successfully created message***************");
			responseVO = response.getBody();
			readCookiesFromAPIResponse(httpResponse, response);
		} else if (response.getStatusCode().equals(HttpStatus.OK)) {
			responseVO = response.getBody();
		} else {
			responseVO = imsCommonVO;
		}
		return responseVO;
	}

	private void readCookiesFromAPIResponse(HttpServletResponse httpResponse, ResponseEntity<IMSCommonVO> response) {
		String cookieInResponse = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
		String[] split = cookieInResponse.split(";");
		Cookie cookie = new Cookie(split[0].split(("="))[0], split[0].split(("="))[1]);
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		cookie.setVersion(Integer.valueOf(split[1].split(("="))[1]));
		cookie.setDomain(split[2].split(("="))[1]);
		cookie.setPath(split[3].split(("="))[1]);
		httpResponse.addCookie(cookie);
	}

	public void testDummy() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		Employee emp = new Employee();
		emp.setEmpID(5555);
		emp.setEmpName("Upender");
		Department d = new Department();
		d.setDeptId(100);
		d.setDeptName("Police");
		emp.setDepartment(d);

		HttpEntity<Employee> httpEntity = new HttpEntity<>(emp, headers);
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromHttpUrl(VRMS_SERVICES_CONTEXT_URL + VRMS_SERVICES_AGENT_REGISTERATION_CONTEXT + "/registerDummy");
		ResponseEntity<Employee> emp2 = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.POST, httpEntity,
				Employee.class);
		if (null != emp2 && null != emp2.getBody()) {
			System.out.println("-------------" + emp2.getBody().getEmpDtls());
			System.out.println("-----***********--------" + emp2.getBody().getDepartment().getDeptDetails());
		}
	}

}
