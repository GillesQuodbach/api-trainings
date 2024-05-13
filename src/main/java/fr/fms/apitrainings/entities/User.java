package fr.fms.apitrainings.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    @Id
    @Pattern(regexp = "^[A-Za-z0-9._-]{6,12}$",
            message = "username must be of 6 to 12 length with no special characters")
    private String username;


//    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*\\d)).{6,}$",
//            message = "password must contains at least 1 uppercase, 1 lowercase, 1 special character and 1 digit")
    private String password;
    private boolean active;

    @ManyToMany
    @JsonIgnore
    private Collection<Role> roles;
}
