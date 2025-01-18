package in.kunal.Service;

import in.kunal.Entities.Councellor;
import in.kunal.Response.DashboardResponse;

interface  CouncellorService {
	
	//Save Councellor information using councellor object.
	public boolean  register(Councellor councellor);
	
	//log into councellor account using login method.
	public Councellor login(String email, String password);
	
	public DashboardResponse response (Integer CouncellorId);

}
