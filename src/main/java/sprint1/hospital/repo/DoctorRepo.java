package sprint1.hospital.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sprint1.hospital.entity.DoctorSG;

@Repository
public interface DoctorRepo extends JpaRepository<DoctorSG, Integer> {

	List<DoctorSG> findByDname(String dname);
	
	List<DoctorSG> findByDid(int did);
	
	List<DoctorSG> findByDspecialization(String dspecialization);
}