package group.iss.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users",uniqueConstraints = {})
public class User {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Column(name="username")
    private java.lang.String username;

    @Column(name="email")
    private java.lang.String email;

    @Column(name="password")
    private java.lang.String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user" , cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("user")
    private List<BucketListItem> bucketListItems;

    public User() {
    }

    public User(String username, String email, String password, List<BucketListItem> bucketListItems) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.bucketListItems = bucketListItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<BucketListItem> getBucketListItems() {
        return bucketListItems;
    }

    public void setBucketListItems(List<BucketListItem> bucketListItems) {
        this.bucketListItems = bucketListItems;
    }

    public void addBucketListItem(BucketListItem item){
        this.bucketListItems.add(item);
        System.out.println("lmao");
    }

    public void deleteBucketListItem(BucketListItem item){this.bucketListItems.remove(item);}
}
