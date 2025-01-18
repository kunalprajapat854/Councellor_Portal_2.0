package in.kunal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.kunal.Entities.Councellor;
import in.kunal.Repositories.enquiryRepo;
import in.kunal.Response.DashboardResponse;
import in.kunal.Service.CouncellorServiceImplement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class councellorController {

	@Autowired
	private CouncellorServiceImplement councellorservice;

	@GetMapping("/")
	public String loadLoginform(Model model) {
		Councellor councellor = new Councellor();
//		Sending data to controller to UI using Model is map send data in key value format
		model.addAttribute("councellor", councellor);
		return "index";
	}

	@PostMapping("/login")
	public String login(Model model, Councellor councellor) {
		Councellor login = councellorservice.login(councellor.getEmail(), councellor.getPassword());
		if (login == null) {
			model.addAttribute("emsg", "Invalid Credentials");
			return "index";
		} else {
			DashboardResponse response = councellorservice.response(login.getCouncellorId());
			model.addAttribute("dashobj", response);
			return "dashboard"; 

		}

	}

}
