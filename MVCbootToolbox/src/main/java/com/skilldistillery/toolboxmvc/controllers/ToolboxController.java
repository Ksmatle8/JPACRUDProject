package com.skilldistillery.toolboxmvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.toolbox.entities.TypeWrench;
import com.skilldistillery.toolbox.entities.Wrench;
import com.skilldistillery.toolboxmvc.data.ToolboxDAO;

@Controller
public class ToolboxController {

	@Autowired
	private ToolboxDAO dao;

	@RequestMapping(path = "/")
	public String index() {
		return "WEB-INF/index.jsp";
	}
	
	@RequestMapping(path="create.do", method= RequestMethod.POST)
	public  String create(@Valid Wrench wrench, Errors errors, Model model) {
		Wrench newWrench;
		if(errors.getErrorCount() != 0) {
			return "WEB-INF/tool/error.jsp";
		}
		newWrench = dao.create(wrench);
		model.addAttribute("newWrench", newWrench);
		return "WEB-INF/tool/newwrenchcreated.jsp";

	}

	@RequestMapping(path = "createPage.do")
	public String redirect() {
		return "WEB-INF/tool/create.jsp";
	}

	@RequestMapping(path = "homePage.do")
	public String home() {
		return "WEB-INF/index.jsp";
	}

	@RequestMapping(path = "getWrench.do")
	public String findWrench(@RequestParam("fid") Integer id, Model model) {
		System.err.println(id);
		Wrench wrench = dao.findById(id);
		model.addAttribute("wrench", wrench);
		return "WEB-INF/tool/show.jsp";
	}

	@RequestMapping(path = "showAll.do", method = RequestMethod.GET)
	public String showAllWrenches(Model model) {
		List<Wrench> allWrenches = dao.findAll();
		model.addAttribute("allWrenches", allWrenches);
		return "WEB-INF/tool/showAll.jsp";
	}

	@RequestMapping(path = "sendToUpdateDeleteForm.do", method = RequestMethod.GET)
	public String editPage(@RequestParam("wrenchId") int id, Model model) {
		Wrench wrench = dao.findById(id);
		model.addAttribute("wrench", wrench);
		return "WEB-INF/tool/deleteUpdate.jsp";
	}

	@RequestMapping(path = "deleted.do", method = RequestMethod.POST)
	public String removeTool(int id, Model model) {
		boolean wrenchDeleted = dao.remove(id);
		return "WEB-INF/tool/deleted.jsp";
	}

	@RequestMapping(path = "update.do", method = RequestMethod.POST)
	public String updateTool(int id, Model model, Wrench wrench) {
		System.err.println(wrench);
		Wrench updatedWrench = dao.update(id, wrench);
		updatedWrench = dao.findById(id);
		model.addAttribute("wrench", updatedWrench);
		return "WEB-INF/tool/show.jsp";
	}
	
	@RequestMapping(path = "addNewTypeToWrench.do", method = RequestMethod.POST)
	public String addNewTypeToWrench(int id, /* Wrench wrench, */ String typeWrench, Model model) {
		System.err.println(id);
//		System.err.println(wrench);
		TypeWrench newTypeWrench = dao.findTypeByName(typeWrench);
		Wrench findWrench = dao.findById(id);
		findWrench.addTypeWrench(newTypeWrench);
		dao.update(findWrench.getId(), findWrench);
		model.addAttribute("wrench", findWrench);
		return  "WEB-INF/tool/show.jsp";
	}
	
	//@RequestMapping(path)
	
	
}






