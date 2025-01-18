package in.kunal.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.kunal.Entities.Enquiry;
@Repository
// repository annotation is optional 
public interface enquiryRepo extends JpaRepository<Enquiry, Integer> {
	
	@Query(value = "SELECT * FROM Enquiry WHERE CouncellorId:= councellorId" ,nativeQuery =  true)
	public List<Enquiry> dashboardresponse (Integer councellorId);

}
