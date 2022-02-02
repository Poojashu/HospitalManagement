package sprint1.hospital.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sprint1.hospital.entity.StaffsSG;

@Repository
public interface StaffsRepo extends JpaRepository<StaffsSG, Integer> {

	List<StaffsSG> findBySname(String sname);
	
	List<StaffsSG> findBySid(int sid);
	
	List<StaffsSG> findBySroom(int sroom);
	
	List<StaffsSG> findBySmobile(int smobile);
}