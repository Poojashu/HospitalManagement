package sprint1.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint1.hospital.entity.*;
import sprint1.hospital.repo.*;

@Service
public class StaffsService {

	@Autowired
	StaffsRepo staffsrepo;

	@Autowired
	PatientRepo prepo;

	@Autowired
	PatientonholdRepo pohrepo;
	
	public List<StaffsSG> findBySname(String sname) {
		return staffsrepo.findBySname(sname);
	}

	public List<StaffsSG> findBySid(int sid) {
		return staffsrepo.findBySid(sid);
	}

	public List<StaffsSG> findBySroom(int sroom) {
		return staffsrepo.findBySroom(sroom);
	}

	public List<StaffsSG> findBySmobile(int smobile) {
		return staffsrepo.findBySmobile(smobile);
	}
	
	public List<StaffsSG> findAll() {
		return staffsrepo.findAll();
	}

	public void save(int sid, String sname, int sroom, String smobile) {
		StaffsSG userobj = new StaffsSG();
		userobj.setSid(sid);
		userobj.setSname(sname);
		userobj.setSroom(sroom);
		userobj.setSmobile(smobile);
		staffsrepo.save(userobj);
	}

	public void deleteById(int sid) {
		List<PatientonholdSG> list1 = pohrepo.findBySid(sid);
		for (int i = 0; i < list1.size(); i++) {
			PatientonholdSG pohsg = new PatientonholdSG();
			pohsg.setPid(list1.get(i).getPid());
			pohsg.setPname(list1.get(i).getPname());
			pohsg.setProom(list1.get(i).getProom());
			pohsg.setPage(list1.get(i).getPage());
			pohsg.setPgender(list1.get(i).getPgender());
			pohsg.setPsurgery(list1.get(i).getPsurgery());
			pohsg.setPaddress(list1.get(i).getPaddress());
			pohsg.setDid(list1.get(i).getDid());
			pohsg.setSid(list1.get(i).getSid());
			pohsg.setDocavail("No");
			pohsg.setStaffavail("No");
			pohrepo.save(pohsg);
		}
		List<PatientSG> psg = prepo.findBySid(sid);
		for (int i = 0; i < psg.size(); i++) {
			List<PatientonholdSG> dsg = pohrepo.findAll();
			int a = 0;
			for(int j=0;j<dsg.size();j++) {
				a = a<dsg.get(j).getDid()?dsg.get(j).getDid():a;
			}
			int pid = a+1;
			PatientonholdSG pohsg = new PatientonholdSG();
			pohsg.setPid(pid);
			pohsg.setPname(psg.get(i).getPname());
			pohsg.setProom(psg.get(i).getProom());
			pohsg.setPage(psg.get(i).getPage());
			pohsg.setPgender(psg.get(i).getPgender());
			pohsg.setPsurgery(psg.get(i).getPsurgery());
			pohsg.setPaddress(psg.get(i).getPaddress());
			pohsg.setDid(psg.get(i).getDid());
			pohsg.setSid(psg.get(i).getSid());
			pohsg.setDocavail("Yes");
			pohsg.setStaffavail("No");
			pohrepo.save(pohsg);
			prepo.deleteById(psg.get(i).getPid());
		}
		staffsrepo.deleteById(sid);
	}
}