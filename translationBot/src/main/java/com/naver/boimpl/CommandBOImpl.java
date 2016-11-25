package com.naver.boimpl;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naver.bo.CommandBO;
import com.naver.dao.CommandDAO;
@Service
public class CommandBOImpl implements CommandBO {

	@Autowired
	private CommandDAO commandDAO;
@Override	
public final  int deleteDateWords(final long id, final int date, 
			final int bottype) {
		return commandDAO.deleteDateWords(id, date, 
					bottype);								
	}
@Override
public final  int deleteWords(final long id, final String word,
			final int bottype) {
		return commandDAO.deleteWords(id, word, bottype);
	}
@Override
public final  ArrayList<HashMap> selectPeriodWords(final long id,
		  final String predate, final String afterdate, final int bottype) {
	  return commandDAO.selectPeriodWords(id, predate, afterdate, bottype);	  
  }
@Override
public final  ArrayList<HashMap> selectWrongWords(final long id, 
		final String predate, final String afterdate, final int bottype) {
	  return commandDAO.selectWrongWords(id, predate, afterdate, bottype);	  
 }
}
