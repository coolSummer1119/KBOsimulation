package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

	
@Controller
public class SelectTeamController {
	
	@GetMapping("/teamSelect")
	public String goTeamPage(Model model) {
		
		String selectedTeam = (String) model.getAttribute("teamName");
		
		if ("롯데".equals(selectedTeam)) {
			// TO DO 팀 선수들 정보 불러오는 로직
			
		} else if ("doosan".equals(selectedTeam)) {
			
		} else if ("kt".equals(selectedTeam)) {
			
		} else if ("ssg".equals(selectedTeam)) {
			
		} else if ("samsung".equals(selectedTeam)) {
			
		} else if ("kia".equals(selectedTeam)) {
			
		} else if ("hanhwa한화".equals(selectedTeam)) {
			
		} else if ("nc".equals(selectedTeam)) {
			
		} else if ("lg".equals(selectedTeam)) {
			
		} else {
			
		}
		
		
		model.addAttribute("team", "lotte");
		return "/teamSelect/teamSelect";
	}
}
