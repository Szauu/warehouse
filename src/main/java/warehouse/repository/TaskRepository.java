package warehouse.repository;


import warehouse.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("select t from Task t where t.id=?1")
    Task findTaskById(Long id);
}
