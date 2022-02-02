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
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientrepo;

	@Autowired
	DoctorService drepo;

	@Autowired
	StaffsService srepo;

	@Autowired
	ChargesService crepo;

	@Autowired
	RoomService rrepo;

	@Autowired
	PatientonholdService pohrepo;

	@GetMapping("/home")
	public String Patienthome(Model model) {
		model.addAttribute("list", patientrepo.findAll());
		return "patienthome";
	}

	@PostMapping("/view/{pid}")
	public String viewpid(Model model, @PathVariable int pid) {
		model.addAttribute("list", patientrepo.findByPid(pid));
		model.addAttribute("doctor", drepo.findByDid(patientrepo.findByPid(pid).get(0).getDid()).get(0).getDname());
		model.addAttribute("staff", srepo.findBySid(patientrepo.findByPid(pid).get(0).getSid()).get(0).getSname());
		model.addAttribute("charge",
				crepo.findBySname(patientrepo.findByPid(pid).get(0).getPsurgery()).get(0).getAmount());
		return "patientview";
	}

	@GetMapping("/add")
	public String Patientadd(Model model) {
		model.addAttribute("list", rrepo.findAll());
		model.addAttribute("list2", crepo.findAll());
		return "patientadd";
	}

	@GetMapping("/delete/{pid}")
	public String Patientdelete(Model model, @PathVariable int pid) {
		patientrepo.deleteById(pid);
		model.addAttribute("list", patientrepo.findAll());
		return "patienthome";
	}

	@PostMapping("/add")
	public String addPatient(Model model, String pname, @RequestParam int proom, @RequestParam int page, String pgender,
			String psurgery, String paddress) {
		patientrepo.save(pname, proom, page, pgender, psurgery, paddress);
		model.addAttribute("list", patientrepo.findAll());
		return "patienthome";
	}

	@GetMapping("/update/{pid}")
	public String Doctoraddid(Model model, @PathVariable int pid) {
		model.addAttribute("list", patientrepo.findByPid(pid));
		model.addAttribute("list3", rrepo.findAll());
		model.addAttribute("list2", crepo.findAll());
		return "patientupdate";
	}

	@PostMapping("/update")
	public String updateDoctor(Model model, @RequestParam int pid, String pname, @RequestParam int proom,
			@RequestParam int page, String pgender, String psurgery, String paddress) {
		patientrepo.update(pid, pname, proom, page, pgender, psurgery, paddress);
		model.addAttribute("list", patientrepo.findAll());
		return "patienthome";
	}

	@GetMapping("/findbyid")
	public String patientfindid() {
		return "patientfindbyid";
	}

	@GetMapping("/findbyname")
	public String patientfindname() {
		return "patientfindbyname";
	}

	@PostMapping("/findbyid")
	public String findidDoctor(Model model, @RequestParam Integer pid) {
		List<PatientSG> list1 = patientrepo.findByPid(pid);
		if (list1.size() > 0) {
			model.addAttribute("list", list1);
			model.addAttribute("doctor", drepo.findByDid(list1.get(0).getDid()).get(0).getDname());
			model.addAttribute("staff", srepo.findBySid(list1.get(0).getSid()).get(0).getSname());
			model.addAttribute("charge", crepo.findBySname(list1.get(0).getPsurgery()).get(0).getAmount());
			return "patientview";
		} else {
			model.addAttribute("error", "Patient unavailable..");
			return "patientfindbyid";
		}
	}

	@PostMapping("/findbyname")
	public String findnameDoctor(Model model, String pname) {
		List<PatientSG> list1 = patientrepo.findByPname(pname);
		if (list1.size() > 0) {
			model.addAttribute("list", list1);
			model.addAttribute("doctor", drepo.findByDid(list1.get(0).getDid()).get(0).getDname());
			model.addAttribute("staff", srepo.findBySid(list1.get(0).getSid()).get(0).getSname());
			model.addAttribute("charge", crepo.findBySname(list1.get(0).getPsurgery()).get(0).getAmount());
			return "patientview";
		} else {
			model.addAttribute("error", "Patient unavailable..");
			return "patientfindbyname";
		}
	}

	@GetMapping("/onhold")
	public String Patientonholdhome(Model model) {
		model.addAttribute("list", pohrepo.findAll());
		return "patientonhold";
	}

	@PostMapping("/onholdview/{pid}")
	public String viewpidasd(Model model, @PathVariable int pid) {
		model.addAttribute("list", pohrepo.findByPid(pid));
		return "patientonholdview";
	}

	@GetMapping("/userhome")
	public String uDoctorhome(Model model) {
		model.addAttribute("list", patientrepo.findAll());
		return "patientuserhome";
	}

	@PostMapping("/userview/{pid}")
	public String userview(Model model, @PathVariable int pid) {
		model.addAttribute("list", patientrepo.findByPid(pid));
		model.addAttribute("doctor", drepo.findByDid(patientrepo.findByPid(pid).get(0).getDid()).get(0).getDname());
		model.addAttribute("staff", srepo.findBySid(patientrepo.findByPid(pid).get(0).getSid()).get(0).getSname());
		model.addAttribute("charge",
				crepo.findBySname(patientrepo.findByPid(pid).get(0).getPsurgery()).get(0).getAmount());
		return "patientuserview";
	}

	@GetMapping("/userfindbyid")
	public String uDoctorfindid() {
		return "patientfindbyid2";
	}

	@GetMapping("/userfindbyname")
	public String uDoctorfindname() {
		return "patientfindbyname2";
	}

	@PostMapping("/userfindbyid")
	public String findiduDoctor(Model model, @RequestParam Integer pid) {
		List<PatientSG> list1 = patientrepo.findByPid(pid);
		if (list1.size() > 0) {
			model.addAttribute("list", patientrepo.findByPid(pid));
			model.addAttribute("doctor", drepo.findByDid(patientrepo.findByPid(pid).get(0).getDid()).get(0).getDname());
			model.addAttribute("staff", srepo.findBySid(patientrepo.findByPid(pid).get(0).getSid()).get(0).getSname());
			model.addAttribute("charge",
					crepo.findBySname(patientrepo.findByPid(pid).get(0).getPsurgery()).get(0).getAmount());
			return "patientuserview";
		} else {
			model.addAttribute("error", "Patient unavailable..");
			return "patientfindbyid2";
		}
	}

	@PostMapping("/userfindbyname")
	public String findnameuDoctor(Model model, String pname) {
		List<PatientSG> list1 = patientrepo.findByPname(pname);
		if (list1.size() > 0) {
			model.addAttribute("list", patientrepo.findByPname(pname));
			model.addAttribute("doctor",
					drepo.findByDid(patientrepo.findByPname(pname).get(0).getDid()).get(0).getDname());
			model.addAttribute("staff",
					srepo.findBySid(patientrepo.findByPname(pname).get(0).getSid()).get(0).getSname());
			model.addAttribute("charge",
					crepo.findBySname(patientrepo.findByPname(pname).get(0).getPsurgery()).get(0).getAmount());
			return "patientuserview";
		} else {
			model.addAttribute("error", "Patient unavailable..");
			return "patientfindbyname2";
		}
	}

	@GetMapping("/onholduser")
	public String Patientonholdhome2(Model model) {
		model.addAttribute("list", pohrepo.findAll());
		return "patientonhold2";
	}

	@PostMapping("/onholduserview/{pid}")
	public String viewpidasd2(Model model, @PathVariable int pid) {
		model.addAttribute("list", pohrepo.findByPid(pid));
		return "patientonholdview2";
	}
}