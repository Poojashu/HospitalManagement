package sprint1.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint1.hospital.entity.*;
import sprint1.hospital.repo.*;

@Service
public class PatientonholdService {
	
	@Autowired
	PatientonholdRepo pohrepo;

	public List<PatientonholdSG> findByPid(int pid){
		return pohrepo.findByPid(pid);
	}

	public List<PatientonholdSG> findByPname(String pname){
		return pohrepo.findByPname(pname);
	}
	
	public List<PatientonholdSG> findByPsurgery(String psurgery){
		return pohrepo.findByPsurgery(psurgery);
	}

	public List<PatientonholdSG> findByProom(int proom){
		return pohrepo.findByProom(proom);
	}
	
	public List<PatientonholdSG> findByDocavail(String docavail){
		return pohrepo.findByDocavail(docavail);
	}

	public List<PatientonholdSG> findByStaffavail(String staffavail){
		return pohrepo.findByStaffavail(staffavail);
	}

	public List<PatientonholdSG> findByDid(int did){
		return pohrepo.findByDid(did);
	}

	public List<PatientonholdSG> findBySid(int sid){
		return pohrepo.findBySid(sid);
	}

	public List<PatientonholdSG> findAll(){
		return pohrepo.findAll();
	}

	public void deleteById(int pid){
		pohrepo.deleteById(pid);
	}
}