package com.skilldistillery.toolboxmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.toolboxmvc.data.ToolboxDAO;

@Controller
public class ToolboxController {

	@Autowired
	private ToolboxDAO dao;
	
	//@RequestMapping(path="")
	
	
}
