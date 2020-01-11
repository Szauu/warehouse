package warehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private Set<Task> tasks = new HashSet<>();


    public Owner() {
    }
    public Owner(@NotNull String name, Set<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
