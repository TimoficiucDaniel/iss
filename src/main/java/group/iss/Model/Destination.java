package group.iss.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="destinations")
@JsonIgnoreProperties("image")
public class Destination {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Column(name = "geolocation")
    private String geolocation;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    byte[] image;

    @Column(name = "description")
    private String description;

    @Column(name = "arrival_date")
    private Date arrival_date;

    @Column(name = "departure_date")
    private Date departure_date;

    @Column(name = "private")
    private Boolean isPrivate;

    @OneToMany(mappedBy = "destination")
    @JsonIgnoreProperties("destination")
    private List<BucketListItem> bucketListItems;

    public Destination() {
    }

    public Destination(String geolocation, String title, byte[] image, String description, Date arrival_date, Date departure_date, Boolean isPrivate, List<BucketListItem> bucketListItems) {
        this.geolocation = geolocation;
        this.title = title;
        this.image = image;
        this.description = description;
        this.arrival_date = arrival_date;
        this.departure_date = departure_date;
        this.isPrivate = isPrivate;
        this.bucketListItems = bucketListItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public List<BucketListItem> getBucketListItems() {
        return bucketListItems;
    }

    public void setBucketListItems(List<BucketListItem> bucketListItems) {
        this.bucketListItems = bucketListItems;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }
}
