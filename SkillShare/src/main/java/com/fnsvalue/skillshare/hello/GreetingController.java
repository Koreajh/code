package com.fnsvalue.skillshare.hello;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fnsvalue.skillshare.bo.ChatBO;
import com.fnsvalue.skillshare.bo.NotifyBO;
import com.fnsvalue.skillshare.bo.ReportNotifyBO;

@Controller
public class GreetingController {
	
	@Autowired
	private ChatBO chatBO;
	
	@Autowired
	private NotifyBO notifyBO;
	
	@Autowired
	private ReportNotifyBO reportnotifyBO;
	
	ArrayList<String> result =new ArrayList<String>() ;
	
	
//	@MessageMapping("/reportnotifyload")
//    @SendTo("/topic/reportnotifyloadings")
//    public ReportNotifyLoading reportnotifyloading(ReportNotifyMessage message) throws Exception {
//    	
//		
//		ArrayList<HashMap> loadlist=notifyBO.notifyview(message.getTo_id());
//    	
//        return new ReportNotifyLoading(loadlist);
// 
//    }
	@MessageMapping("/reportnotify")
    @SendTo("/topic/reportnotifyings")
    public ReportNotifying reportnoticing(ReportNotifyMessage message) throws Exception {
    	System.out.println("값을 받는가 = "+message.getTo()+" / "+ message.getBoard_no()+" / "+ message.getBoard_user()+" / "+ message.getCnt()+" / "+ message.getDt());
		reportnotifyBO.reportnotifyadd(message.getTo(), message.getBoard_no(), message.getBoard_user(), message.getCnt(), message.getDt());

        return new ReportNotifying(message.getTo()+":"+message.getBoard_no()+":"+message.getBoard_user()+":"+message.getCnt());

    }

	@MessageMapping("/notifyload")
    @SendTo("/topic/notifyloadings")
    public NotifyLoading notifyloading(NotifyMessage message) throws Exception {
    	
		
		ArrayList<HashMap> loadlist=notifyBO.notifyview(message.getTo_id());
    	
        return new NotifyLoading(loadlist);
 
    }
	@MessageMapping("/notify")
    @SendTo("/topic/notifyings")
    public Notifying noticing(NotifyMessage message) throws Exception {
    	System.out.println("신청됬습니다.");
		notifyBO.notifyadd(message.getFrom_id(), message.getTo_id(), message.getSq(), message.getTit(), message.getDt());
    	
        return new Notifying(message.getFrom_id()+":"+message.getTo_id()+":"+message.getSq()+":"+message.getTit());
 
    }
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
    	
    	chatBO.Chatadd(message.getFrom(), message.getTo(), message.getMessage(), message.getDt());
    	
        return new Greeting(message.getFrom()+":"+message.getTo()+":"+message.getMessage()+":"+message.getDt());
 
    }
    @MessageMapping("/test")
    @SendTo("/topic/testings")
    public Testing testing(HelloMessage message) throws Exception {
    	
    	System.out.println("testes = "+message.getFrom()+ " / " + message.getTo()+ " / " + message.getMessage()+ " / " + message.getDt());
    	
        return new Testing(message.getFrom()+":"+message.getTo()+":"+message.getMessage()+":"+message.getDt());
 
    }

    
    @MessageMapping("/load")
    @SendTo("/topic/loadings")
    public Loading loading(LoadMessage message) throws Exception {
    	
    	System.out.println("ddd:"+message.getLoadfrom()+" dddd:"+message.getLoadto());
    	
    	ArrayList<HashMap> loadlist = chatBO.Chatview(message.getLoadfrom(), message.getLoadto());
    	System.out.println("get size"+loadlist);
    	System.out.println("get size11"+loadlist);
    	return new Loading(loadlist);
    }
	
	@MessageMapping("/loginuser")
    @SendTo("/topic/logings")
	public Loging loging(LoginUserMessage message) throws Exception{
		
		if(message.getLoginuserst() == 0){
			result.add(message.getLoginuser());
		}
		else if(message.getLoginuserst() == 1){
			
			for(Iterator<String> it = result.iterator() ; it.hasNext() ; )
			{
				String value = it.next();
				
				if(value.startsWith(message.getLoginuser()))
				{
					it.remove();
				}
			}
			
		}
		
		System.out.println("hhhhhh"+result);
		
		return new Loging(result);
		
	}
    @MessageMapping("/chatcount")
    @SendTo("/topic/chatcounts")
    public Counting counting(HelloMessage message) throws Exception {
    	System.out.println(message.getFrom()+"///"+message.getTo());
    	int count = chatBO.Chatcount(message.getFrom(), message.getTo());
    	HashMap content = new HashMap();
    	content.put("CHAT_FROM", message.getFrom());
    	content.put("CHAT_TO", message.getTo());
    	content.put("COUNT", count);
        return new Counting(content);
    }
	
    @MessageMapping("/chatupdate")
    @SendTo("/topic/chatupdates")
    public Updating updating(HelloMessage message) throws Exception {
    	HashMap content = new HashMap();
    	content.put("form", message.getFrom());
    	content.put("to", message.getTo());
    	System.out.println("updating result = "+chatBO.Chatupdate(message.getFrom(), message.getTo()));
        return new Updating(content);
    }
}