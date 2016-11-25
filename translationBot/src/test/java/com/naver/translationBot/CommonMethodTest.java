//package com.naver.translationBot;
//
//
//	import static org.junit.Assert.*;
//	import java.util.ArrayList;
//	import java.util.HashMap;
//	import org.junit.After;
//	import org.junit.Before;
//	import org.junit.Test;
//	import org.junit.runner.RunWith;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.test.context.ContextConfiguration;
//	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//	import org.springframework.test.context.web.WebAppConfiguration;
//
//	import com.naver.bo.CommandBO;
//	import com.naver.bo.TestBO;
//	import com.naver.bo.TranslateBO;
//	import com.naver.dto.TranslateDTO;
//	import com.naver.translationBot.TranslationController;
//
//	import com.google.gson.Gson;
//	import com.google.gson.annotations.SerializedName;
//	import com.memetix.mst.detect.Detect;
//	import com.memetix.mst.language.Language;
//	import com.memetix.mst.translate.Translate;
//
//	import org.junit.Before;
//	import org.junit.Test;
//	import org.junit.runner.RunWith;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//	import static org.junit.Assert.*;
//	import static org.mockito.BDDMockito.*;
//	import org.mockito.InjectMocks;
//	import org.mockito.Mock;
//	import org.mockito.MockitoAnnotations;
//	import org.springframework.http.MediaType;
//	import org.springframework.http.converter.HttpMessageConverter;
//	import org.springframework.mock.web.MockHttpServletRequest;
//	import org.springframework.mock.web.MockHttpServletResponse;
//	import org.springframework.test.context.ContextConfiguration;
//	import org.springframework.test.context.web.WebAppConfiguration;
//	import org.springframework.test.web.servlet.MockMvc;
//	import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//	import org.springframework.web.context.WebApplicationContext;
//	import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
//	import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter; 
//	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//	import java.net.URL;
//	import java.util.HashMap;
//	import static org.junit.Assert.*;
//	import static org.mockito.Mockito.*;
//	import java.util.List;
//
//	import org.junit.After;
//	import org.junit.Before;
//	import org.junit.Test;
//
//	@RunWith(SpringJUnit4ClassRunner.class)
//	@WebAppConfiguration
//	@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
//	        ,"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//	public class CommonMethodTest {
//
//		
//		@Autowired
//		public TranslateBO translateBO;
//		
//		@Autowired
//		public CommandBO commandBO;
//		
//		@Autowired
//		public TestBO testBO;
//		
//		@Autowired
//		public TranslationController translationcontroller;
//		
//		@Mock
//		public TranslateBO translateMockBO;
//		
//		@InjectMocks
//		public TranslationController translationController=new TranslationController();
//
//		@Autowired
//		private WebApplicationContext wac;
//		
//		private MockMvc mockMvc;
//		
//		
//		
//		@Before
//		public void setUp() throws Exception {
//
//			  MockitoAnnotations.initMocks(this);
//	    	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//
//		}
//
//		@After
//		public void tearDown() throws Exception {
//		}
//
//
//}
