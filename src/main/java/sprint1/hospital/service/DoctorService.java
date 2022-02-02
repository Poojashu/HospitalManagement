package sprint1.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint1.hospital.entity.DoctorSG;
import sprint1.hospital.entity.PatientSG;
import sprint1.hospital.entity.PatientonholdSG;
import sprint1.hospital.repo.ChargesRepo;
import sprint1.hospital.repo.DoctorRepo;
import sprint1.hospital.repo.PatientRepo;
import sprint1.hospital.repo.PatientonholdRepo;

@Service
public class DoctorService {

	@Autowired
	DoctorRepo doctorrepo;

	@Autowired
	PatientRepo prepo;
	
	@Autowired
	ChargesRepo crepo;

	@Autowired
	PatientonholdRepo pohrepo;

	public List<DoctorSG> findAll() {
		return doctorrepo.findAll();
	}
	
	public List<DoctorSG> findByDname(String dname) {
		return doctorrepo.findByDname(dname);
	}

	public List<DoctorSG> findByDid(int did) {
		return doctorrepo.findByDid(did);
	}

	public List<DoctorSG> findByDspecialization(String dspecialization) {
		return doctorrepo.findByDspecialization(dspecialization);
	}
	public void update(int did, String dname,
			String daddress, String dmobile, String dspecialization) {
		DoctorSG userobj = new DoctorSG();
		userobj.setDid(did);
		userobj.setDname(dname);
		userobj.setDaddress(daddress);
		userobj.setDmobile(dmobile);
		userobj.setDspecialization(dspecialization);
		doctorrepo.save(userobj);
	}

	public void save(String dname, String daddress, String dmobile,
			String dspecialization) {
		List<DoctorSG> dsg = doctorrepo.findAll();
		int a = 0;
		for(int i=0;i<dsg.size();i++) {
			a = a<dsg.get(i).getDid()?dsg.get(i).getDid():a;
		}
		int did = a+1;
		DoctorSG userobj = new DoctorSG();
		userobj.setDid(did);
		userobj.setDname(dname);
		userobj.setDaddress(daddress);
		userobj.setDmobile(dmobile);
		userobj.setDspecialization(dspecialization);
		doctorrepo.save(userobj);
	}

	public void deleteById(int did) {
		List<PatientonholdSG> list1 = pohrepo.findByDid(did);
		for (int i = 0; i < list1.size(); i++) {
			PatientonholdSG pohsg = new PatientonholdSG();
			pohsg.setPid(list1.get(i).getPid());
			pohsg.setPname(list1.get(i).getPname());
			pohsg.setProom(list1.get(i).getProom());
			pohsg.setPage(list1.get(i).getPage());
			pohsg.setPgender(list1.get(i).getPgender());
			pohsg.setPsurgery(list1.get(i).getPsurgery());
			pohsg.setPaddress(list1.get(i).getPaddress());
			pohsg.setDid(did);
			pohsg.setSid(list1.get(i).getSid());
			pohsg.setDocavail("No");
			pohsg.setStaffavail("No");
			pohrepo.save(pohsg);
		}
		List<PatientSG> psg = prepo.findByDid(did);
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
			pohsg.setDid(did);
			pohsg.setSid(psg.get(i).getSid());
			pohsg.setDocavail("No");
			pohsg.setStaffavail("Yes");
			pohrepo.save(pohsg);
			prepo.deleteById(psg.get(i).getPid());
		}
		doctorrepo.deleteById(did);
	}
}