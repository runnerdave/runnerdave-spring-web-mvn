package com.runnerdave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
class IndexController {

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/hola", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex() {
        return "Hola mundo";
    }
    
    @RequestMapping(value="/hello-page")
	public ModelAndView goToHelloPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("hello"); //name of the jsp-file in the "pages" folder
		
		String str = "MVC Spring is here!";
		view.addObject("message", str); //adding of str object as "message" parameter
		
		return view;
	}

}
