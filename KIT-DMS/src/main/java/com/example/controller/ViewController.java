package com.example.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping(value = {"/","/index"})
	public String getIndex() {
		return "index";
	}
	
	
	@RequestMapping(value = {"/","/document"})
	public String getDocument() {
		return "document";
	}
	@RequestMapping(value = {"/","/folder"})
	public String getFolder() {
		return "folder";
	}
	@RequestMapping(value = {"/","/login"})
	public String getLogn() {
		return "login";
	}
	
	
	
}
