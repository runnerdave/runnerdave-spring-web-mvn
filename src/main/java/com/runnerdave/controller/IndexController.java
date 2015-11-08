package com.runnerdave.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.runnerdave.service.HelloWorldService;

@Controller
class IndexController {
	
	private final Logger logger = LoggerFactory.getLogger(IndexController.class);
	private final HelloWorldService helloWorldService;
	
	@Autowired
	public IndexController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/hola", method = RequestMethod.GET)
    @ResponseBody
    public String showHola() {
    	logger.debug("showHola() is executed!");
        return "Hola mundos";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");		
		return "index";
	}
    
    @RequestMapping(value="/hello-page")
    @ResponseBody
    public ModelAndView goToHelloPage() {
    	logger.debug("goToHelloPage() is executed!");
		ModelAndView view = new ModelAndView();
		view.setViewName("hello"); //name of the jsp-file in the "pages" folder
		
		String str = "MVC Spring is here!";
		view.addObject("message", str); //adding of str object as "message" parameter
		
		return view;
	}
    
    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());
		
		return model;

	}

}
