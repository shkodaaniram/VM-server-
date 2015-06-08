package org.vm.entity.img.controllers;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vm.entity.dao.EntityDAO;
import org.vm.entity.img.model.Image;
import org.vm.entity.model.EntityType;
import org.vm.entity.model.FilterType;
 
@Controller
@RequestMapping("/welcome")
public class TestController {
	@Autowired
	EntityDAO<Image>  imageDao;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "index";
 
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test(ModelMap model) {
 
		model.addAttribute("message", "TEST1");
		return "index";
 
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		/*ApplicationContext context = 
		    	  new ClassPathXmlApplicationContext(new String[] {"spring-module.xml"});*/
		 
		/*imageDao = (ImageDAO)context.getBean("imageDao");*/
		long time = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(time);
		Image image = new Image(876856, "testimage.png", FilterType.MONO, "d:" + File.separator + "Pictures" + File.separator, EntityType.IMAGE, date, 1);
		imageDao.insert(image);
		image = imageDao.findById(5);
		model.addAttribute("testOutput", image);
		model.addAttribute("message", "TEST1");
		return "index";
 
	}
}

