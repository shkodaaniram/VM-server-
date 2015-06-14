package org.vm.entity.img.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vm.entity.dao.EntityDAO;
import org.vm.entity.img.model.Image;
import org.vm.entity.model.EntityType;
import org.vm.entity.model.FilterType;
import org.vm.entity.video.model.Video;
 
@Controller
@RequestMapping("/welcome")
public class TestController {
	@Autowired
	EntityDAO<Image>  imageDao;
	
	@Autowired
	EntityDAO<Video>  videoDao;
	
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
		long time = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(time);
		Image image = new Image(876854, "newtestimage.png", FilterType.MONO, "d:" + File.separator + "Pictures" + File.separator, EntityType.IMAGE, date, 1);
		//imageDao.insert(image);
		assert image.getId() == 2;
		//imageDao.deleteById(6);
		//imageDao.rename(4, "rename.png");
		List<Image> resultImages = new ArrayList<Image>();
		resultImages = imageDao.findAllForAccount(1);
		/*model.addAllAttributes(resultImages);
		model.addAttribute("resultImages", resultImages);*/
		//model.addAttribute("testOutput", image);
		model.addAttribute("message", "TEST1");
		Video video = new Video(756746, "video.mp4", FilterType.NONE, "d:" + File.separator + "Videos" + File.separator, EntityType.VIDEO, date, 1, 5000, new byte[10] );
		videoDao.insert(video);
		model.addAttribute("insertVideo", video);
		return "index";
 
	}
}

