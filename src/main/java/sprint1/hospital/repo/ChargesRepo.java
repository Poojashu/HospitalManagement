package sprint1.hospital.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sprint1.hospital.entity.ChargesSG;

public interface ChargesRepo extends JpaRepository<ChargesSG, Integer> {

	List<ChargesSG> findBySname(String sname);
	
	List<ChargesSG> findByAmount(int amount);
}