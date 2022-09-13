package pl.coderslab.charity.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.transform.Source;

@Entity
@Table(name = "institutions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2 , max = 30)
    private String name;
    @NotBlank
    @Size(min = 15)
    private String description;

    @Override
    public String toString() {
        return name + " " + description;
    }

}
