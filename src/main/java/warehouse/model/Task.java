package warehouse.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String label;
    @NotNull
    private LocalDate date;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Owner owner;

    public Task() {
    }

    public Task(@NotNull String label, @NotNull LocalDate date, @NotNull Owner owner) {
        this.label = label;
        this.date = date;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", date=" + date +
                ", owner=" + owner +
                '}';
    }
}

