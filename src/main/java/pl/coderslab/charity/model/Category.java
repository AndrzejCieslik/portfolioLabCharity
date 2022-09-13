package pl.coderslab.charity.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="categories")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


}
