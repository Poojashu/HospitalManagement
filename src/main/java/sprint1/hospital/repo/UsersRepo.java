package sprint1.hospital.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sprint1.hospital.entity.UsersSG;

@Repository
public interface UsersRepo extends JpaRepository<UsersSG, String> {

	List<UsersSG> findByUsername (String username);
}