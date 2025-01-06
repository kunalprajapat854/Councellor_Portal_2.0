package in.kunal.Service;

import in.kunal.Entities.Councellor;

interface  CouncellorService {
	
	//Save Councellor information using councellor object.
	public boolean  register(Councellor councellor);
	
	//log into councellor account using login method.
	public String login(String email, String password);

}
