package sprint1.hospital.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import sprint1.hospital.entity.RoomSG;

public interface RoomRepo extends JpaRepository<RoomSG, Integer> {

	List<RoomSG> findByRoomno(int roomno);
	
	List<RoomSG> findByLocation(String location);
}