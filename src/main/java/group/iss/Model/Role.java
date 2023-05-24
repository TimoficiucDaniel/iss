package group.iss.Model;


import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="role_name")
    private ERole roleName;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getRoleName() {
        return roleName;
    }

    public void setRoleName(ERole name_name) {
        this.roleName = name_name;
    }
}
