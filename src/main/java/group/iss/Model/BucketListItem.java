package group.iss.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="bucket_list_items")
public class BucketListItem {

    private @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("bucketListItems")
    private User user;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    @JsonIgnoreProperties("bucketListItems")
    private Destination destination;

    public BucketListItem() {
    }

    public BucketListItem(User user, Destination destination) {
        this.user = user;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
