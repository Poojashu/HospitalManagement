package sprint1.hospital.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sprint1.hospital.entity.UsersSG;
import sprint1.hospital.service.*;

@Controller
public class LoginController {

	@Autowired
	LoginService usersrepo;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage() {
		return "loginpage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminPage(ModelMap model, @RequestParam String userid, @RequestParam String password) {
		List<UsersSG> list1 = usersrepo.findByUsername(userid);
		if (list1.size() > 0) {
			String used = list1.get(0).getUsed();
			String pass = list1.get(0).getPassword();
			if (password.equals(pass)) {
				if (used.equals("admin")) {
					model.put("page", "Welcome Admin!!");
					return "adminhome";
				} else if (used.equals("user")) {
					model.put("page", "Welcome User!!");
					return "userhome";
				}
			}
		}
		model.put("errormsg", "Wrong Credentials!!");
		return "loginpage";
	}

	@GetMapping("/create")
	public String Create() {
		return "useridp";
	}

	@PostMapping("/create")
	public String Created(ModelMap model, @RequestParam String userid, @RequestParam String password,
			@RequestParam String password2) {
		List<UsersSG> list1 = usersrepo.findByUsername(userid);
		if (list1.size() > 0) {
			model.put("errormsg2", "ID already exists!!");
			return "useridp";
		}
		if (!password.equals(password2)) {
			model.put("errormsg2", "Passwords do not match!!");
			return "useridp";
		}
		usersrepo.save("user", userid, password);
		return "loginpage";
	}

	@GetMapping("/forgot")
	public String Forgot() {
		return "forgotpass";
	}

	@PostMapping("/forgot")
	public String Forgotten(ModelMap model, @RequestParam String userid, @RequestParam String oldpassword,
			@RequestParam String newpassword, @RequestParam String newpassword2) {
		List<UsersSG> list1 = usersrepo.findByUsername(userid);
		if (list1.size() > 0) {
			String used = list1.get(0).getUsed();
			String pass = list1.get(0).getPassword();
			if (oldpassword.equals(pass)) {
				if (!newpassword.equals(newpassword2)) {
					model.put("errormsg2", "Passwords do not match!!");
					return "forgotpass";
				}
				usersrepo.save(used, userid, newpassword);
				return "loginpage";
			}
		}
		model.put("errormsg2", "Credentials don't match!!");
		return "forgotpass";
	}

	@GetMapping("/userhome")
	public String UserHome() {
		return "userhome";
	}

	@GetMapping("/home")
	public String Home() {
		return "adminhome";
	}
}