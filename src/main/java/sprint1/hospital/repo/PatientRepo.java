package sprint1.hospital.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sprint1.hospital.entity.PatientSG;

@Repository
public interface PatientRepo extends JpaRepository<PatientSG, Integer> {

	List<PatientSG> findByPid(int pid);

	List<PatientSG> findByPname(String pname);

	List<PatientSG> findByPsurgery(String psurgery);

	List<PatientSG> findByProom(int proom);
	
	List<PatientSG> findByDid(int did);

	List<PatientSG> findBySid(int sid);
}