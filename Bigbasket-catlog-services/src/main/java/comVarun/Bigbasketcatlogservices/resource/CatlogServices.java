package comVarun.Bigbasketcatlogservices.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatlogServices {
	 
	@Autowired
	private CatlogRepository catlogrepository;
	
	public List<Catlogitems> getallCatlogs(){
		List<Catlogitems> catlog=new ArrayList<>();
		catlogrepository.findAll()
		.forEach(catlog::add);
		return catlog;
	}
	
	public Optional<Catlogitems> getCatlog(Integer id) {
		return catlogrepository.findById(id);
		
	}
	public List<Catlogitems>addCatlog(Catlogitems catlog1) {
		catlogrepository.save(catlog1);
		return (List<Catlogitems>) catlogrepository.findAll();
		
	}
	public void updateCatlog(String id,Catlogitems catlog1) {
		   catlogrepository.save(catlog1);
			
		}
		public void deleteCatlog(String id,Catlogitems catlog1) {
          catlogrepository.delete(catlog1);
			
		}

}
