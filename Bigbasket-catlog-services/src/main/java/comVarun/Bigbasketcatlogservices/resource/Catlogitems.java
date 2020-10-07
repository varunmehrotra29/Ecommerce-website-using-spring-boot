package comVarun.Bigbasketcatlogservices.resource;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Catlogitems {
	
	@Id@GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="Id")
   	private Integer Id;
	@Column(name="grocerryitems")
	private String grocerryitems;
	@Column(name="desc")
	private String desc;
	@Column(name="rating")
	private String rating;
	@Column(name="cost")
	private String cost;
	@Column(name="category")
	private String category;
	
	
	
	
	public Catlogitems(String grocerryitems, String desc, String rating, String cost, String category, Integer id) {
		super();
		this.grocerryitems = grocerryitems;
		this.desc = desc;
		this.rating = rating;
		this.cost = cost;
		this.category = category;
		Id = id;
	}





	public String getGrocerryitems() {
		return grocerryitems;
	}


	public void setGrocerryitems(String grocerryitems) {
		this.grocerryitems = grocerryitems;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}

	
	

}
