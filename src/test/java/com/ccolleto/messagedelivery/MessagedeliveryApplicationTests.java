package com.ccolleto.messagedelivery;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.ccolleto.messagedelivery.controller.MessageController;

@WebMvcTest(controllers = MessageController.class)
class MessagedeliveryApplicationTests {

//	@Autowired
//	private MockMvc mockMVC;
//
//	@MockBean
//	private MessageService service;
//
//	@Test
//	public void addShouldReturnValidationError() throws Exception {
//		this.mockMVC.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(new Message())))
//				.andDo(print()).andExpect(status().isBadRequest());
//	}
//
//	private static String asJsonString(final Object obj) {
//		try {
//			return new ObjectMapper().writeValueAsString(obj);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

}
