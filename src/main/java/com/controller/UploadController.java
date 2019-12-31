package com.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Service.uploadService;

@Controller
public class UploadController {
	@Autowired 
	uploadService  us;
	
	@RequestMapping(value="/welcome" , method=RequestMethod.GET)
	public ModelAndView  index() {
		return new ModelAndView("upload");
	}
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {
		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return new ModelAndView ("upload ","message","Please select a file to upload");
			
		}
		try {
			
		}
		catch(IOException ex) {
			
		}
		
	}
	
		
	

}
