package sprint1.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint1.hospital.entity.ChargesSG;
import sprint1.hospital.repo.ChargesRepo;

@Service
public class ChargesService {

	@Autowired
	ChargesRepo chargesrepo;
	
	public List<ChargesSG> findBySname(String sname) {
		return chargesrepo.findBySname(sname);
	}

	public List<ChargesSG> findByAmount(int amount) {
		return chargesrepo.findByAmount(amount);
	}

	public List<ChargesSG> findAll() {
		return chargesrepo.findAll();
	}
}