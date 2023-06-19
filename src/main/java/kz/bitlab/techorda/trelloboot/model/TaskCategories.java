package kz.bitlab.techorda.trelloboot.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="t_task_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="Id")
    private Long id;

    @Column(name="Name")
    private String name;
}