package comVarun.Bigbasketcatlogservices.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@RestController
@RequestMapping("/BigBasket")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatlogController {
	
	@Autowired
	private CatlogServices catlogservices;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/catlog")
	public List<Catlogitems> getallcatlog() {
		
		
	  //this below line is used for getting all the services of DataRating service
		//UserRating ratings=restTemplate.getForObject("http://localhost:8083/rating/all",UserRating.class);
		UserRating ratings=restTemplate.getForObject("http://BIGBASKET-DATARAITING-SERVICE/rating/all",UserRating.class);
		
		
		//this class is maped with the CartInfo service
		return ratings.getUserrating().stream().map(rating ->{
			//CartInfo cartinfo=restTemplate.getForObject("http://localhost:8082/cart/all",CartInfo.class);
			CartInfo cartinfo=restTemplate.getForObject("http://BIGBASKET-CARTINFO-SERVICE/cart/all",CartInfo.class);
		      return new Catlogitems(cartinfo.getGrocerryitems(),"Grocerry",rating.getRating(),cartinfo.getCost(),"Fruits",cartinfo.getId());})
				.collect(Collectors.toList());
	}
	
	@RequestMapping("/catlog/{id}")
	public Optional<Catlogitems> getCatlog(@PathVariable Integer id) {
	return catlogservices.getCatlog(id);
	}

	@RequestMapping(method = RequestMethod.POST,value="/catlog")
	public void addCatlog(@RequestBody final Catlogitems catlog) {
	  catlogservices.addCatlog(catlog);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/catlog/{id}")
	public void updateCatlog(@RequestBody Catlogitems catlog,@PathVariable String id) {
		catlogservices.updateCatlog(id,catlog);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/catlog/{id}")
	public void deleteCatlog(@RequestBody Catlogitems catlog ,@PathVariable String id) {
		catlogservices.deleteCatlog(id,catlog);
	}
	
}
