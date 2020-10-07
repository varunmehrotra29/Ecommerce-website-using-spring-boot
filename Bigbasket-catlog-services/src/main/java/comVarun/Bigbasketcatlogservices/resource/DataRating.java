package comVarun.Bigbasketcatlogservices.resource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataRating {
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private Integer Id;
	@Column(name="grocerryitems")
	private String grocerryitems;
	@Column(name="rating")
	private String rating;
	
	public DataRating() {
		
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getGrocerryitems() {
		return grocerryitems;
	}
	public void setGrocerryitems(String grocerryitems) {
		this.grocerryitems = grocerryitems;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}


}
