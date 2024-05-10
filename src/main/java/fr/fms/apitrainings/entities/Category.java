package fr.fms.apitrainings.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cglib.core.KeyFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category implements Serializable {

    // cat Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // cat name
    private String name;

    // cat description
    private String description;

    // training in category
    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private Collection<Training> trainings;
}
