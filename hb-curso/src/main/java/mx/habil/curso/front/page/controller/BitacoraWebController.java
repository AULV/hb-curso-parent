package mx.habil.curso.front.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/protected/page/bitacora")
public class BitacoraWebController {
	
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
	public ModelAndView inicio(){
		ModelAndView result = null;
		result = new ModelAndView("/bitacora/bitacora.jsp");
		return result;
	}
}
