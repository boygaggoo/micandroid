package ningbo.media.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "locations")
@XmlRootElement
public class Location implements Serializable {

	private static final long serialVersionUID = 5398023012055824282L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Expose
	private Integer id;

	@Expose
	private String name_en;

	@Expose
	private String name_cn;

	@Expose
	private String address_en;

	@Expose
	private String address_cn;

	@Expose
	private String telephone;

	@Expose
	private Double longitude;

	@Expose
	private Double latitude;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "location")
	private List<Event> events ;

	public Location() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public String getName_cn() {
		return name_cn;
	}

	public void setName_cn(String name_cn) {
		this.name_cn = name_cn;
	}

	public String getAddress_en() {
		return address_en;
	}

	public void setAddress_en(String address_en) {
		this.address_en = address_en;
	}

	public String getAddress_cn() {
		return address_cn;
	}

	public void setAddress_cn(String address_cn) {
		this.address_cn = address_cn;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	
	@XmlTransient
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String toJson() {
		Gson gson = new Gson();
		String json = gson.toJson(this, Location.class);
		return json;
	}

	public static Location fromJson(String jsonCategory) {
		Gson gson = new Gson();
		Location fLocation = gson.fromJson(jsonCategory, Location.class);
		return fLocation;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name_en=" + name_en + ", name_cn="
				+ name_cn + ", address_en=" + address_en + ", address_cn="
				+ address_cn + ", telephone=" + telephone + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}

}
