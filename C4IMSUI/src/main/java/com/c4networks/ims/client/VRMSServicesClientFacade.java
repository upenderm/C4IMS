package com.c4networks.ims.client;

import java.util.Arrays;

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

@Component
public class VRMSServicesClientFacade {

	private String VRMS_SERVICES_CONTEXT_URL = "http://localhost:8080/C4IMSWS/rest";
	private String VRMS_SERVICES_AGENT_AUTHENTICATION_CONTEXT = "/AgentServices";
	private String VRMS_SERVICES_AGENT_AUTHENTICATION = "/authenticateUserSecurity";
	private String VRMS_SERVICES_AGENT_REGISTERATION_CONTEXT = "/AgentRegisterServices";
	private String VRMS_SERVICES_AGENT_REGISTERATION = "/registerUser";

	@Autowired
	private RestTemplate restTemplate;

	public C4UserObject processUserLogin(String userName, String password) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(VRMS_SERVICES_CONTEXT_URL
				+ VRMS_SERVICES_AGENT_AUTHENTICATION_CONTEXT + VRMS_SERVICES_AGENT_AUTHENTICATION);
		uriBuilder.queryParam("username", userName);
		uriBuilder.queryParam("password", password);

		return restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, C4UserObject.class).getBody();
	}

	public boolean processUserRegisteration(C4UserObject c4UserObject) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<C4UserObject> entity = new HttpEntity<C4UserObject>(c4UserObject, headers);

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(VRMS_SERVICES_CONTEXT_URL
				+ VRMS_SERVICES_AGENT_REGISTERATION_CONTEXT + VRMS_SERVICES_AGENT_REGISTERATION);

		ResponseEntity<C4UserObject> response = restTemplate.postForEntity(uriBuilder.toUriString(), entity, C4UserObject.class);
		if(response.getStatusCode() == HttpStatus.CREATED) {
			c4UserObject.setProductTypes(response.getBody().getProductTypes());
		}
		return (response.getStatusCode() == HttpStatus.CREATED);
	}

}
