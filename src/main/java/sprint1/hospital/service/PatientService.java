package sprint1.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint1.hospital.entity.*;
import sprint1.hospital.repo.*;

@Service
public class PatientService {

	@Autowired
	PatientRepo patientrepo;

	@Autowired
	DoctorRepo drepo;

	@Autowired
	StaffsRepo srepo;

	public List<PatientSG> findAll() {
		return patientrepo.findAll();
	}

	public List<PatientSG> findByPid(int pid) {
		return patientrepo.findByPid(pid);
	}

	public List<PatientSG> findByPname(String pname) {
		return patientrepo.findByPname(pname);
	}

	public List<PatientSG> findByPsurgery(String psurgery) {
		return patientrepo.findByPsurgery(psurgery);
	}

	public List<PatientSG> findByProom(int proom) {
		return patientrepo.findByProom(proom);
	}

	public List<PatientSG> findByDid(int did) {
		return patientrepo.findByDid(did);
	}

	public List<PatientSG> findBySid(int sid) {
		return patientrepo.findBySid(sid);
	}

	public void deleteById(int pid) {
		patientrepo.deleteById(pid);
	}

	public void save(String pname, int proom, int page, String pgender,
			String psurgery, String paddress) {
		List<PatientSG> patientlist = patientrepo.findAll();
		int a = 0;
		for (int i = 0; i < patientlist.size(); i++) {
			a = a < patientlist.get(i).getPid() ? patientlist.get(i).getPid() : a;
		}
		int pid = a + 1;
		List<StaffsSG> ssg = srepo.findBySroom(proom);
		int t = 0, tx = 0;
		for (int i = 0; i < ssg.size(); i++) {
			List<PatientSG> psg2 = patientrepo.findBySid(ssg.get(i).getSid());
			if (t < psg2.size()) {
				t = psg2.size();
				continue;
			}
			if (patientrepo.findBySid(ssg.get(tx).getSid()).size() > psg2.size()) {
				tx = i;
			}
		}
		int sid = ssg.get(tx).getSid();
		List<DoctorSG> dsg2 = drepo.findByDspecialization(psurgery);
		int s = 0, sx = 0;
		for (int i = 0; i < dsg2.size(); i++) {
			List<PatientSG> psg2 = patientrepo.findByDid(dsg2.get(i).getDid());
			if (s < psg2.size()) {
				s = psg2.size();
				continue;
			}
			if (patientrepo.findByDid(dsg2.get(sx).getDid()).size() > psg2.size()) {
				sx = i;
			}
		}
		int did = dsg2.get(sx).getDid();
		PatientSG obj = new PatientSG();
		obj.setPid(pid);
		obj.setPname(pname);
		obj.setProom(proom);
		obj.setPage(page);
		obj.setPgender(pgender);
		obj.setPsurgery(psurgery);
		obj.setPaddress(paddress);
		obj.setDid(did);
		obj.setSid(sid);
		patientrepo.save(obj);
	}

	public void update(int pid, String pname, int proom, int page, String pgender,
			String psurgery, String paddress) {
		List<StaffsSG> ssg = srepo.findBySroom(proom);
		int t = 0, tx = 0;
		for (int i = 0; i < ssg.size(); i++) {
			List<PatientSG> psg2 = patientrepo.findBySid(ssg.get(i).getSid());
			if (t < psg2.size()) {
				t = psg2.size();
				continue;
			}
			if (patientrepo.findBySid(ssg.get(tx).getSid()).size() > psg2.size()) {
				tx = i;
			}
		}
		int sid = ssg.get(tx).getSid();
		List<DoctorSG> dsg2 = drepo.findByDspecialization(psurgery);
		int s = 0, sx = 0;
		for (int i = 0; i < dsg2.size(); i++) {
			List<PatientSG> psg2 = patientrepo.findByDid(dsg2.get(i).getDid());
			if (s < psg2.size()) {
				s = psg2.size();
				continue;
			}
			if (patientrepo.findByDid(dsg2.get(sx).getDid()).size() > psg2.size()) {
				sx = i;
			}
		}
		int did = dsg2.get(sx).getDid();
		PatientSG obj = new PatientSG();
		obj.setPid(pid);
		obj.setPname(pname);
		obj.setProom(proom);
		obj.setPage(page);
		obj.setPgender(pgender);
		obj.setPsurgery(psurgery);
		obj.setPaddress(paddress);
		obj.setDid(did);
		obj.setSid(sid);
		patientrepo.save(obj);
	}
}