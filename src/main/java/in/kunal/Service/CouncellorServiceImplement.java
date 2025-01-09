package in.kunal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.kunal.Entities.Councellor;
import in.kunal.Repositories.councellorRepo;
@Service
public class CouncellorServiceImplement implements CouncellorService {

   // injecting councellor repository in service to perform register and login
	@Autowired
	private councellorRepo councellorrepo;

	@Override
	public boolean register(Councellor councellor) {
		Councellor save = councellorrepo.save(councellor);
		if(save!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Councellor login(String email, String password) {
		  Councellor emailpwd = councellorrepo.findByNameAndPassword(email, password);
		  return emailpwd;
	}

}
