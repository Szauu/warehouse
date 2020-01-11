package warehouse.repository;


import warehouse.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {

    @Query("select o from Owner o where o.name =?1")
    Owner findOwnerByName(String name);
}
