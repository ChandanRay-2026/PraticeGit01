  package com.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.service.IDoctorImplmt;
import com.nit.vo.DoctorVo;

@Controller
public class DoctorControll 
{
	@Autowired
	IDoctorImplmt doctorService;
	@GetMapping("/")
	public String home()
	{
		return "welcome";
	}
	
	@GetMapping("/report") 
	public String showReport(Map<String,Object>map)
	{
		List<DoctorVo> listVo = doctorService.findAllDoctors();
		map.put("doctorlist", listVo);
		return "show_report";
		
	}
@GetMapping("/register")//for register doctor form page launching
	public String showRegisterDoctorForm(@ModelAttribute("docVo") DoctorVo vo)
	{ 
		 return "register_doctor_form";
	}
//@PostMapping("/register")
//public String registerDoctor(@ModelAttribute("docVo") DoctorVo vo,Map<String,Object> map)
//{
//	String msg = doctorService.registerDoctor(vo);
//	List<DoctorVo> listVo = doctorService.findAllDoctors();
//	map.put("resultMsg", msg);
//	map.put("doctorlist", listVo);
//	
//	return "show_report";
//}
	
@PostMapping("/register")
public String registerDoctor(@ModelAttribute("docVo") DoctorVo vo,RedirectAttributes attr)
{
	String msg = doctorService.registerDoctor(vo);
	//List<DoctorVo> listVo = doctorService.findAllDoctors();
	attr.addFlashAttribute("resultMsg", msg);
	//map.put("doctorlist", listVo);
	
	return "redirect:report";
}

@GetMapping("/edit")
public String showEditDoctorFormPage(@RequestParam("no")int no,@ModelAttribute("docVo") DoctorVo vo)
{
	DoctorVo vo1=doctorService.showDoctorById(no);
	BeanUtils.copyProperties(vo1, vo);
	 
	return "edit_doctor_form";
}

@PostMapping("/edit")
public String editDoctor(@ModelAttribute("docVo") DoctorVo vo,RedirectAttributes attr)
{
   String msg = doctorService.editDoctor(vo);
   attr.addFlashAttribute("resultMsg",msg);
   
   return "redirect:report";
}

@GetMapping("/delete")
public String removeDoctor(@RequestParam("no")int no,RedirectAttributes attrs)
{
	String msg=doctorService.removeDoctor(no);
	attrs.addFlashAttribute("resultMsg",msg);
	return "redirect:report";
	
}

}
