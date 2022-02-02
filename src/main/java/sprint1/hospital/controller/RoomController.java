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
import sprint1.hospital.entity.RoomSG;
import sprint1.hospital.service.*;

@Controller
@RequestMapping("/room")
public class RoomController {

	@Autowired
	PatientService prepo;

	@Autowired
	RoomService roomrepo;
	
	@Autowired
	StaffsService srepo;

	@GetMapping("/home")
	public String Roomhome(Model model) {
		model.addAttribute("list", roomrepo.findAll());
		return "roomhome";
	}

	@PostMapping("/view/{roomno}")
	public String joinDP(Model model, @PathVariable int roomno) {
		model.addAttribute("list", roomrepo.findByRoomno(roomno));
		model.addAttribute("list2", prepo.findByProom(roomno));
		model.addAttribute("list3", srepo.findBySroom(roomno));
		return "roomview";
	}

	@GetMapping("/findbyid")
	public String Doctorfindid(Model model) {
		model.addAttribute("list", roomrepo.findAll());
		return "roomfindbyid";
	}

	@PostMapping("/findbyid")
	public String findidDoctor(Model model, @RequestParam Integer roomno) {
		List<RoomSG> list1 = roomrepo.findByRoomno(roomno);
		if (list1.size() > 0) {
			model.addAttribute("list", roomrepo.findByRoomno(roomno));
			model.addAttribute("list2", prepo.findByProom(roomno));
			model.addAttribute("list3", srepo.findBySroom(roomno));
			return "roomview";
		} else {
			model.addAttribute("error", "Room not present..");
			return "roomfindbyid";
		}
	}

	@GetMapping("/userhome")
	public String uDoctorhome(Model model) {
		model.addAttribute("list", roomrepo.findAll());
		return "roomuserhome";
	}

	@PostMapping("/userview/{roomno}")
	public String userview(Model model, @PathVariable int roomno) {
		model.addAttribute("list", roomrepo.findByRoomno(roomno));
		model.addAttribute("list2", prepo.findByProom(roomno));
		model.addAttribute("list3", srepo.findBySroom(roomno));
		return "roomuserview";
	}

	@GetMapping("/userfindbyid")
	public String Doctorfindid2(Model model) {
		model.addAttribute("list", roomrepo.findAll());
		return "roomfindbyid2";
	}

	@PostMapping("/userfindbyid")
	public String findidDoctor2(Model model, @RequestParam Integer roomno) {
		List<RoomSG> list1 = roomrepo.findByRoomno(roomno);
		if (list1.size() > 0) {
			model.addAttribute("list", roomrepo.findByRoomno(roomno));
			model.addAttribute("list2", prepo.findByProom(roomno));
			model.addAttribute("list3", srepo.findBySroom(roomno));
			return "roomuserview";
		} else {
			model.addAttribute("error", "Room not present..");
			return "roomfindbyid2";
		}
	}
}