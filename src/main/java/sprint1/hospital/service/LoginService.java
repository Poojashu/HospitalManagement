package sprint1.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint1.hospital.entity.UsersSG;
import sprint1.hospital.repo.UsersRepo;

@Service
public class LoginService {

	@Autowired
	UsersRepo usersrepo;
	
	public List<UsersSG> findByUsername(String username) {
		return usersrepo.findByUsername(username);
	}
	
	public List<UsersSG> findAll(){
		return usersrepo.findAll();
	}

	public void save(String used, String userid, String password) {
		UsersSG obj = new UsersSG();
		obj.setUsed(used);
		obj.setUsername(userid);
		obj.setPassword(password);
		usersrepo.save(obj);
	}
}