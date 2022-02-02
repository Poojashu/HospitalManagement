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
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	PatientService prepo;

	@Autowired
	DoctorService doctorrepo;
	
	@Autowired
	ChargesService crepo;

	@GetMapping("/home")
	public String Doctorhome(Model model) {
		model.addAttribute("list", doctorrepo.findAll());
		return "doctorhome";
	}

	@PostMapping("/view/{did}")
	public String joinDP(Model model, @PathVariable int did) {
		model.addAttribute("list", doctorrepo.findByDid(did));
		model.addAttribute("list2", prepo.findByDid(did));
		return "doctorview";
	}

	@GetMapping("/add")
	public String Doctoradd(Model model) {
		model.addAttribute("list", crepo.findAll());
		return "doctoradd";
	}

	@GetMapping("/update/{did}")
	public String Doctoraddid(Model model, @PathVariable int did) {
		model.addAttribute("list", doctorrepo.findByDid(did));
		return "doctorupdate";
	}

	@PostMapping("/update")
	public String updateDoctor(Model model, @RequestParam int did, @RequestParam String dname,
			@RequestParam String daddress, @RequestParam String dmobile, @RequestParam String dspecialization) {
		doctorrepo.update(did, dname, daddress, dmobile, dspecialization);
		model.addAttribute("list", doctorrepo.findAll());
		return "doctorhome";
	}

	@PostMapping("/add")
	public String addDoctor(Model model, String dname, String daddress, String dmobile,
			String dspecialization) {
		doctorrepo.save(dname, daddress, dmobile, dspecialization);
		model.addAttribute("list", doctorrepo.findAll());
		return "doctorhome";
	}

	@GetMapping("/delete/{did}")
	public String deleteDoctor(Model model, @PathVariable int did) {
		doctorrepo.deleteById(did);
		model.addAttribute("list", doctorrepo.findAll());
		return "doctorhome";
	}

	@GetMapping("/findbyid")
	public String Doctorfindid() {
		return "doctorfindbyid";
	}

	@GetMapping("/findbyname")
	public String Doctorfindname() {
		return "doctorfindbyname";
	}

	@PostMapping("/findbyid")
	public String findidDoctor(Model model, @RequestParam Integer did) {
		List<DoctorSG> list1 = doctorrepo.findByDid(did);
		if (list1.size() > 0) {
			model.addAttribute("list", doctorrepo.findByDid(did));
			model.addAttribute("list2", prepo.findByDid(did));
			return "doctorview";
		} else {
			model.addAttribute("error", "Doctor unavailable..");
			return "doctorfindbyid";
		}
	}

	@PostMapping("/findbyname")
	public String findnameDoctor(Model model, String dname) {
		List<DoctorSG> list1 = doctorrepo.findByDname(dname);
		if (list1.size() > 0) {
			model.addAttribute("list", doctorrepo.findByDname(dname));
			List<DoctorSG> all = doctorrepo.findByDname(dname);
			int did = all.get(0).getDid();
			model.addAttribute("list2", prepo.findByDid(did));
			return "doctorview";
		} else {
			model.addAttribute("error", "Doctor unavailable..");
			return "doctorfindbyname";
		}
	}

	@GetMapping("/userhome")
	public String uDoctorhome(Model model) {
		model.addAttribute("list", doctorrepo.findAll());
		return "doctoruserhome";
	}

	@PostMapping("/userview/{did}")
	public String userview(Model model, @PathVariable int did) {
		model.addAttribute("list", doctorrepo.findByDid(did));
		model.addAttribute("list2", prepo.findByDid(did));
		return "doctoruserview";
	}

	@GetMapping("/userfindbyid")
	public String uDoctorfindid() {
		return "doctorfindbyid2";
	}

	@GetMapping("/userfindbyname")
	public String uDoctorfindname() {
		return "doctorfindbyname2";
	}

	@PostMapping("/userfindbyid")
	public String findiduDoctor(Model model, @RequestParam Integer did) {
		List<DoctorSG> list1 = doctorrepo.findByDid(did);
		if (list1.size() > 0) {
			model.addAttribute("list", doctorrepo.findByDid(did));
			model.addAttribute("list2", prepo.findByDid(did));
			return "doctoruserview";
		} else {
			model.addAttribute("error", "Doctor unavailable..");
			return "doctorfindbyid2";
		}
	}

	@PostMapping("/userfindbyname")
	public String findnameuDoctor(Model model, String dname) {
		List<DoctorSG> list1 = doctorrepo.findByDname(dname);
		if (list1.size() > 0) {
			model.addAttribute("list", doctorrepo.findByDname(dname));
			List<DoctorSG> all = doctorrepo.findByDname(dname);
			int did = all.get(0).getDid();
			model.addAttribute("list2", prepo.findByDid(did));
			return "doctoruserview";
		} else {
			model.addAttribute("error", "Doctor unavailable..");
			return "doctorfindbyname2";
		}
	}
}