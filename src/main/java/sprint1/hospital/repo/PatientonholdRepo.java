package sprint1.hospital.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sprint1.hospital.entity.PatientonholdSG;

@Repository
public interface PatientonholdRepo extends JpaRepository<PatientonholdSG, Integer> {

	List<PatientonholdSG> findByPid(int pid);

	List<PatientonholdSG> findByPname(String pname);

	List<PatientonholdSG> findByPsurgery(String psurgery);

	List<PatientonholdSG> findByProom(int proom);
	
	List<PatientonholdSG> findByDocavail(String docavail);

	List<PatientonholdSG> findByStaffavail(String staffavail);

	List<PatientonholdSG> findByDid(int did);

	List<PatientonholdSG> findBySid(int sid);
}
