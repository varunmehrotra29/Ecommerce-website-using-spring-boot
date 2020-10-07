package comVarun.Bigbasketcatlogservices.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRating {
	
	
	private List<DataRating> userrating;

	public List<DataRating> getUserrating() {
		return userrating;
	}

	public void setUserrating(List<DataRating> userrating) {
		this.userrating = userrating;
	}

}
