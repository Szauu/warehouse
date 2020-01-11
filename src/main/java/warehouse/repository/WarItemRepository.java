package warehouse.repository;


import warehouse.model.WarItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WarItemRepository extends JpaRepository<WarItem, Long> {
    @Query("select w from WarItem w where w.id =?1")
    WarItem getWarItemById(long id);
}
