package sprint1.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint1.hospital.entity.*;
import sprint1.hospital.repo.*;

@Service
public class RoomService {

	@Autowired
	RoomRepo roomrepo;
	
	public List<RoomSG> findByRoomno(int roomno) {
		return roomrepo.findByRoomno(roomno);
	}

	public List<RoomSG> findByLocation(String location) {
		return roomrepo.findByLocation(location);
	}
	
	public List<RoomSG> findAll(){
		return roomrepo.findAll();
	}
}