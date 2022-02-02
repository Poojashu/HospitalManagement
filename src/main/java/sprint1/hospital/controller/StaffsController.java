package sprint1.hospital.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sprint1.hospital.entity.*;
import sprint1.hospital.service.*;

@Controller
@RequestMapping("/staffs")
public class StaffsController {

	@Autowired
	StaffsService staffsrepo;

	@Autowired
	PatientService prepo;

	@Autowired
	PatientonholdService pohrepo;

	@Autowired
	RoomService rrepo;

	@GetMapping("/home")
	public String Staffshome(Model model) {
		model.addAttribute("list", staffsrepo.findAll());
		return "staffshome";
	}

	@PostMapping("/view/{sid}")
	public String joinDP(Model model, @PathVariable int sid) {
		model.addAttribute("list", staffsrepo.findBySid(sid));
		model.addAttribute("list2", prepo.findBySid(sid));
		return "staffsview";
	}

	@GetMapping("/add")
	public String Staffsadd(Model model) {
		model.addAttribute("list", rrepo.findAll());
		return "staffsadd";
	}

	@GetMapping("/update/{sid}")
	public String Doctoraddid(Model model, @PathVariable int sid) {
		model.addAttribute("list", staffsrepo.findBySid(sid));
		model.addAttribute("list2", rrepo.findAll());
		return "staffsupdate";
	}

	@PostMapping("/update")
	public String updateDoctor(Model model, @RequestParam int sid, String sname, @RequestParam int sroom,
			String smobile) {
		staffsrepo.save(sid, sname, sroom, smobile);
		model.addAttribute("list", staffsrepo.findAll());
		return "staffshome";
	}

	@PostMapping("/add")
	public String addStaffs(Model model, String sname, @RequestParam int sroom, String smobile) {
		List<StaffsSG> dsg = staffsrepo.findAll();
		int a = 0;
		for (int i = 0; i < dsg.size(); i++) {
			a = a < dsg.get(i).getSid() ? dsg.get(i).getSid() : a;
		}
		int sid = a + 1;
		List<StaffsSG> dsg2 = staffsrepo.findBySid(sid);
		if (dsg2.size() > 0) {
			model.addAttribute("error", "ID already exists..");
			return "staffsadd";
		}
		staffsrepo.save(sid, sname, sroom, smobile);
		model.addAttribute("list", staffsrepo.findAll());
		return "staffshome";
	}

	@GetMapping("/delete/{sid}")
	public String deleteDoctor(Model model, @PathVariable int sid) {
		staffsrepo.deleteById(sid);
		model.addAttribute("list", staffsrepo.findAll());
		return "staffshome";
	}

	@GetMapping("/findbyid")
	public String Doctorfindid() {
		return "staffsfindbyid";
	}

	@GetMapping("/findbyname")
	public String Doctorfindname() {
		return "staffsfindbyname";
	}

	@PostMapping("/findbyid")
	public String findidDoctor(Model model, @RequestParam Integer sid) {
		List<StaffsSG> list1 = staffsrepo.findBySid(sid);
		if (list1.size() > 0) {
			model.addAttribute("list", staffsrepo.findBySid(sid));
			model.addAttribute("list2", prepo.findBySid(sid));
			return "staffsview";
		} else {
			model.addAttribute("error", "Staff unavailable..");
			return "staffsfindbyid";
		}
	}

	@PostMapping("/findbyname")
	public String findnameDoctor(Model model, String sname) {
		List<StaffsSG> list1 = staffsrepo.findBySname(sname);
		if (list1.size() > 0) {
			model.addAttribute("list", staffsrepo.findBySname(sname));
			List<StaffsSG> all = staffsrepo.findBySname(sname);
			int sid = all.get(0).getSid();
			model.addAttribute("list2", prepo.findBySid(sid));
			return "staffsview";
		} else {
			model.addAttribute("error", "Staff unavailable..");
			return "staffsfindbyname";
		}
	}

	@GetMapping("/userhome")
	public String uDoctorhome(Model model) {
		model.addAttribute("list", staffsrepo.findAll());
		return "staffsuserhome";
	}

	@PostMapping("/userview/{sid}")
	public String userview(Model model, @PathVariable int sid) {
		model.addAttribute("list", staffsrepo.findBySid(sid));
		model.addAttribute("list2", prepo.findBySid(sid));
		return "staffsuserview";
	}

	@GetMapping("/userfindbyid")
	public String uDoctorfindid() {
		return "staffsfindbyid2";
	}

	@GetMapping("/userfindbyname")
	public String uDoctorfindname() {
		return "staffsfindbyname2";
	}

	@PostMapping("/userfindbyid")
	public String findiduDoctor(Model model, @RequestParam Integer sid) {
		List<StaffsSG> list1 = staffsrepo.findBySid(sid);
		if (list1.size() > 0) {
			model.addAttribute("list", staffsrepo.findBySid(sid));
			model.addAttribute("list2", prepo.findBySid(sid));
			return "staffsuserview";
		} else {
			model.addAttribute("error", "Staff unavailable..");
			return "staffsfindbyid2";
		}
	}

	@PostMapping("/userfindbyname")
	public String findnameuDoctor(Model model, String sname) {
		List<StaffsSG> list1 = staffsrepo.findBySname(sname);
		if (list1.size() > 0) {
			model.addAttribute("list", staffsrepo.findBySname(sname));
			List<StaffsSG> all = staffsrepo.findBySname(sname);
			int sid = all.get(0).getSid();
			model.addAttribute("list2", prepo.findBySid(sid));
			return "staffsuserview";
		} else {
			model.addAttribute("error", "Staff unavailable..");
			return "staffsfindbyname2";
		}
	}
}