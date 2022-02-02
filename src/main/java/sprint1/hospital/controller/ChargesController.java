package sprint1.hospital.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sprint1.hospital.entity.*;
import sprint1.hospital.service.*;

@Controller
@RequestMapping("/charges")
public class ChargesController {

	@Autowired
	PatientService prepo;

	@Autowired
	DoctorService drepo;

	@Autowired
	ChargesService chargesrepo;

	@GetMapping("/home")
	public String Chargeshome(Model model) {
		model.addAttribute("list", chargesrepo.findAll());
		return "chargeshome";
	}

	@PostMapping("/view/{sname}")
	public String joinDP(Model model, @PathVariable String sname) {
		model.addAttribute("list", chargesrepo.findBySname(sname));
		model.addAttribute("list2", prepo.findByPsurgery(sname));
		model.addAttribute("list3", drepo.findByDspecialization(sname));
		return "chargesview";
	}

	@GetMapping("/findbyname")
	public String Doctorfindid(Model model) {
		model.addAttribute("list", chargesrepo.findAll());
		return "chargesfindbyname";
	}

	@PostMapping("/findbyname")
	public String findidDoctor(Model model, @RequestParam String sname) {
		List<ChargesSG> list1 = chargesrepo.findBySname(sname);
		if (list1.size() > 0) {
			model.addAttribute("list", chargesrepo.findBySname(sname));
			model.addAttribute("list2", prepo.findByPsurgery(sname));
			model.addAttribute("list3", drepo.findByDspecialization(sname));
			return "chargesview";
		} else {
			model.addAttribute("error", "Surgery not available in this hospital..");
			return "chargesfindbyname";
		}
	}

	@GetMapping("/userhome")
	public String uDoctorhome(Model model) {
		model.addAttribute("list", chargesrepo.findAll());
		return "chargesuserhome";
	}

	@PostMapping("/userview/{sname}")
	public String userview(Model model, @PathVariable String sname) {
		model.addAttribute("list", chargesrepo.findBySname(sname));
		model.addAttribute("list2", prepo.findByPsurgery(sname));
		model.addAttribute("list3", drepo.findByDspecialization(sname));
		return "chargesuserview";
	}

	@GetMapping("/userfindbyname")
	public String Doctorfindid2(Model model) {
		model.addAttribute("list", chargesrepo.findAll());
		return "chargesfindbyname2";
	}

	@PostMapping("/userfindbyname")
	public String findidDoctor2(Model model, @RequestParam String sname) {
		List<ChargesSG> list1 = chargesrepo.findBySname(sname);
		if (list1.size() > 0) {
			model.addAttribute("list", chargesrepo.findBySname(sname));
			model.addAttribute("list2", prepo.findByPsurgery(sname));
			model.addAttribute("list3", drepo.findByDspecialization(sname));
			return "chargesuserview";
		} else {
			model.addAttribute("error", "Surgery not available in this hospital..");
			return "chargesfindbyname2";
		}
	}
}