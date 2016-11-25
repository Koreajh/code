package com.naver.translationBot;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.naver.bo.TranslateBO;
import com.naver.dto.TranslateDTO;
import com.naver.translationBot.TranslationController;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.memetix.mst.detect.Detect;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.net.URL;
import java.util.HashMap;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
 ,"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TranslationControllerTest {


 @Autowired
 public TranslateBO translateBO;

 @Autowired
 public TranslationController translationcontroller;

 @Mock
 public TranslateBO translateMockBO;

 @InjectMocks
 public TranslationController translationController=new TranslationController();

 @Autowired
 private WebApplicationContext wac;

 private MockMvc mockMvc;



 @Before
 public void setUp() throws Exception {

 MockitoAnnotations.initMocks(this);
 this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

 }

 @After
 public void tearDown() throws Exception {
 }
//
//
//
//
// //given
//
//
//
//// public void sendproblem(long writerUserNo, int channelNo) throws Exception {
//// HashMap problem = translateBO.sendProblem(writerUserNo); //문제출제
////
//// }
//// public void deleteData(long writerUserNo, int channelNo, String inputMessage) throws Exception{
//// }
////
//// public void showData(long writerUserNo, int channelNo,String inputMessage) throws Exception {
//// {
//// }
//
// @Test
// public void receivemessageTest() throws Exception {
// //given
// TranslateDTO translate=new TranslateDTO();
// translate.setContent("안녕하세요");
// translate.setWriterUserNo(100000043251001L);
// Gson gson=new Gson();
// String json = gson.toJson(translate);
// mockMvc.perform(post("/receivemessage").contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isOk());
// }
//
//// @Test
//// public void controllerTotalTest() throws Exception {
//// long writerUserNo=100000043251001L;
//// int channelNo=494391;
////
////
//// HashMap resultMap=new HashMap();
//// resultMap.put("id", "100000043251001L");
//// resultMap.put("ko", "안녕하세요");
//// resultMap.put("en", "hello");
////
//// doReturn(resultMap).when(translateBO).sendProblem(writerUserNo);
////
//// translationcontroller.sendproblem(writerUserNo, channelNo);
////
//// HashMap problem = translateBO.sendProblem(writerUserNo); //문제출제
//// translateBO.updateIdInfo(writerUserNo, problem.get("KO")
//// .toString(), problem.get("EN").toString());
//// //한,영 여부에 따라서
//// if (translateBO.selectIdInfo(writerUserNo).get("lang")
//// .toString().equals("ko")) {
//// //한글로 '/@한영'를 쳤다면 영문문제
//// } else if (translateBO.selectIdInfo(writerUserNo).get("lang")
//// .toString().equals("en")) {
//// //영어로 '/@영한'를 쳤다면 한글문제
//// }
//// }
//
//
//// @Test
//// public void receivemessageTest() throws Exception {
//// //given
//// TranslateDTO translate=new TranslateDTO();
//// translate.setContent("안녕하세요 Hello");
//// translate.setWriterUserNo(100000043251001L);
//// Gson gson=new Gson();
//// String json = gson.toJson(translate);
//// mockMvc.perform(post("/receivemessage").contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isOk());
//// }
//
//
//
// @Test
// public void addTranslate() {
// String ko = "안녕하세요";
// String en = "hello";
// Long writerUserNo = 100000043251001L;
// int result = translateBO.addTranslate(writerUserNo, ko, en);
// assertEquals(result, 1);
// }
//
// @Test
// public void confirmTranslate() {
// Long writerUserNo = 100000043251001L;
// String lang = "こんにちは";
// int result = translateBO.confirmTranslate(writerUserNo, lang);
// assertEquals(result, 0);
//
// }
//
//// @Test
//// public void sendProblem() {
//// Long writerUserNo = 100000043251001L;
////
////
//// }
//
// @Test
// public void confirmId() {
// Long writerUserNo = 100000043251001L;
// int result = translateBO.confirmId(writerUserNo);
// assertEquals(result, 0);
// }
//
// @Test
// public void updateFlag() {
// Long writerUserNo = 100000043251001L;
// int flag = 2;
// int result = translateBO.updateFlag(writerUserNo, flag);
// assertEquals(result, 1);
// }
//
// @Test
// public void updateLang() {
// Long writerUserNo = 100000043251001L;
// String lang = "en";
// int result = translateBO.updateLang(writerUserNo, lang);
// assertEquals(result, 1);
// }
//
//// @Test
//// public HashMap selectIdInfo(final long id) {
//// return translateDAO.selectIdInfo(id);
//// }
// @Test
// public void updateIdInfo() {
//
// Long writerUserNo = 100000043251001L;
// String ko = "안녕하세요";
// String en = "hello";
// int result = translateBO.updateIdInfo(writerUserNo, ko, en);
// assertEquals(result, 1);
// }
//
// @Test
// public void confirmIdWord() {
//
// Long writerUserNo = 1000000432510022L; //not exist id
// int result = translateBO.confirmIdWord(writerUserNo);
// assertEquals(result, 0);
//
// }
//
// @Test
// public void deleteDateWords() {
// Long writerUserNo = 1000000432510022L; //not exist id
// int date = 30;
// int result = translateBO.deleteDateWords(writerUserNo, date);
// assertEquals(result, 0);
// }
//
// @Test
// public void deleteWords() {
// Long writerUserNo = 100000043251001L;
// String word = "こんにちは"; //not exist exactly
// int result = translateBO.deleteWords(writerUserNo, word);
// assertEquals(result, 0);
// }
//
//// @Test
//// public void deleteDatePeriodWords() {
//// Long writerUserNo = 100000043251001L;
//// String predate = "2017-01-01"; //not exist exactly
//// String afterdate = "2017-01-01"; //not exist exactly
//// int result = translateDAO.deleteDatePeriodWords(writerUserNo, predate, afterdate);
//// assertEquals(result, 0);
//// }
//
//// public ArrayList<HashMap> selectPeriodWords(final long id,
//// final String predate, final String afterdate) {
//// return translateDAO.selectPeriodWords(id,predate, afterdate);
//// }
//
//}

	@Test
	public void receivemessageTest() throws Exception {
		//given	
				TranslateDTO translate=new TranslateDTO();
				translate.setContent("안녕하세요");
				translate.setWriterUserNo(100000043251001L);
				translate.setChannelNo(494391);
				translate.setBotNo(16);
				Gson gson=new Gson();
				String json = gson.toJson(translate);
				mockMvc.perform(post("/receivemessage/ko/en").contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isOk());
	}
}	

