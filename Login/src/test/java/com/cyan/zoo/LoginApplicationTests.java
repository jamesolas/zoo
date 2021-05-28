package com.cyan.zoo;




import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.app.controller.LoginController;
import com.app.model.Client;
import com.app.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration("LoginApplication.class")
@AutoConfigureMockMvc
@SpringBootTest(classes = LoginController.class)
class LoginApplicationTests {

	private Client mockClient;
	private ObjectMapper mapper;
	private MediaType APPLICATION_JSON_VALUE;
	private String requestJson;
	private JSONObject json;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired MockMvc mockMvc;
	
	@MockBean
	private LoginService loginService;
	
	@BeforeEach
	public void setup() {
		mockClient = new Client(1,"Tom","Ham","tom@gmail.com","password");
	}
	
	@Test
	void testCreateAccount() throws Exception {
//		APPLICATION_JSON_VALUE = new MediaType(MediaType.APPLICATION_JSON.getType()),
//				MediaType.APPLICATION_JSON.getSubtype());
		
//		JSONObject actual = new JSONObject();
//		actual.put("id", 1);
//		actual.put("firstName", "Tom");
//		actual.put("lastName", "Ham");
//		actual.put("email", "tom@gmail.com");
//		actual.put("password", "password");
//		
//		JSONAssert.assertEquals("{id:1,firstName:Tom, lastName:Ham, email:tom@gmail.com, password:password}", actual, false);
		
		APPLICATION_JSON_VALUE = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype());
		mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		requestJson= ow.writeValueAsString(json);
		
		Mockito.when(loginService.createAccount(mockClient)).thenReturn(mockClient);
		MvcResult result = mockMvc.perform(get("/login/create")
				.contentType(APPLICATION_JSON_VALUE).content(requestJson)).andReturn();
				
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andReturn();
		
		assertNotNull(result.getResponse());
		
	}
	
	@Test
	void testLogin() throws Exception {
		APPLICATION_JSON_VALUE = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype());
		mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		requestJson= ow.writeValueAsString(json);
		
		String email = "tom@gmail.com";
		String password = "password";
		HttpServletRequest request = null;
		
		Mockito.when(loginService.login(email, password, request)).thenReturn(mockClient);
		MvcResult result = mockMvc.perform(get("/login/create")
				.contentType(APPLICATION_JSON_VALUE).content(requestJson)).andReturn();
				
		assertNotNull(result.getResponse());
		
	}
	

}
