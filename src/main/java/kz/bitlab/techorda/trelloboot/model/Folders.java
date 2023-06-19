package kz.bitlab.techorda.trelloboot.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="t_folders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Folders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id")
    private Long id;

    @Column(name="Name")
    private String name;

    @ManyToMany
    private List<TaskCategories> categories;
}
