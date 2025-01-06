package in.kunal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.kunal.Entities.Councellor;
import in.kunal.Service.CouncellorServiceImplement;

@Controller
public class councellorController {

	@Autowired
	private CouncellorServiceImplement councellorservice;

	@GetMapping("/")
	public String loadLoginform(Model model) {
		Councellor councellor = new Councellor();
		model.addAttribute("councellor", councellor);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model, @ModelAttribute String email, String password) {
	 String login = councellorservice.login(email, password);
	 model.addAttribute("login", login);
	 return "login";
	}
	
	@GetMapping("/register")
	public String loadRegisterform(Model model) {
		Councellor councellor = new Councellor();
		model.addAttribute("register", councellor);
		return "register";
	}
	
	@PostMapping("/registration")
	public String register(Model model , @RequestBody Councellor councellor) {
		boolean register = councellorservice.register(councellor);
		if(register) {
			 model.addAttribute("smsg", "Registration Saved");
		} else {
			model.addAttribute("emsg", "Registration Failed");
		}
		return "register";
	}

}
