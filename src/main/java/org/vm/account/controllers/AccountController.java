package org.vm.account.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AccountController {
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public void saveImage(@RequestParam("getImage") MultipartFile file, HttpServletResponse response) {
		try {
			byte[] image = file.getBytes();
			response.setHeader("Content-Disposition", "inline; filename=\"report.pdf\"");
			response.setDateHeader("Expires", -1);
			response.setContentType("application/pdf");
			response.setContentLength(image.length);
			response.getOutputStream().write(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// TODO: all methods
	}
}
