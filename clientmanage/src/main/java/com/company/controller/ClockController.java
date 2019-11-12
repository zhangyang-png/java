package com.company.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.pojo.Clock;
import com.company.pojo.Staff;
import com.company.service.IClockService;
import com.company.service.IStaffService;

/**
 * @author 白虎
 * @category 打卡控制器
 */
@Controller
public class ClockController {

	@Autowired
	private IClockService clockService;
	@Autowired
	private IStaffService staffService;

	@RequestMapping("/clock")
	public String clock(HttpSession session,Model model){
		Staff staff = (Staff) session.getAttribute("current_staff");
		int cid = staff.getCid();
		staff.setCid(2);
		Clock clock = clockService.findById(cid);
		clock.setId(2);
		staffService.update(staff);
		model.addAttribute("staff", staff);
		model.addAttribute("clock", clock);
		return "index";
	}
}
