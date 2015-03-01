package mx.habil.curso.front.page.controller;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CommonsLog
@Controller
@RequestMapping(value="/")
public class IndexController {
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
	public String redirect(){
		log.debug("begin");
		String result = "redirect:/protected/page/bitacora";
		log.debug("end");
		return result;
	}
}
