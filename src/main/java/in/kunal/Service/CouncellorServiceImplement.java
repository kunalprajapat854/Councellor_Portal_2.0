package in.kunal.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.kunal.Entities.Councellor;
import in.kunal.Entities.Enquiry;
import in.kunal.Repositories.councellorRepo;
import in.kunal.Repositories.enquiryRepo;
import in.kunal.Response.DashboardResponse;

@Service
public class CouncellorServiceImplement implements CouncellorService {

	// injecting councellor repository in service to perform register and login
	@Autowired
	private councellorRepo councellorrepo;

	// injecting enquiry repository to perform dashboard response according to
	// particular
	// councellorId

	@Autowired
	private enquiryRepo enquiryrepo;

	public boolean register(Councellor councellor) {
		Councellor save = councellorrepo.save(councellor);
		if (save != null) {
			return true;
		}
		return false;
	}

	@Override
	public Councellor login(String email, String password) {
		Councellor emailpwd = councellorrepo.findByNameAndPassword(email, password);
		return emailpwd;
	}

	public DashboardResponse response(Integer CouncellorId) {
   //Using Stream to count the number of status like lostEnq,enrolledEnq, openEqn etc.
		DashboardResponse response = new DashboardResponse();
        List<Enquiry> enqList = enquiryrepo.dashboardresponse(CouncellorId);
        
        int totalEnq = enqList.size();
        response.setTotalEnq(totalEnq);
        
        int openEnq = enqList.stream()
             .filter(e-> e.getStatus().equals("Open"))
             .collect(Collectors.toList())
             .size();
         
         int lostEnq = enqList.stream()
         .filter(e-> e.getStatus().equals("Lost"))
         .collect(Collectors.toList())
         .size();
         
         
         int enrolledEnq = enqList.stream()
         .filter(e->e.getStatus().equals("Enrolled"))
         .collect(Collectors.toList())
         .size();
         
         response.setTotalEnq(totalEnq);
         response.setLostEnq(lostEnq);
         response.setEnrollEnq(enrolledEnq);
         response.setOpenEnq(openEnq);
        
   
		return response;
	}

}
