package group.iss.Repo;

import group.iss.Model.Destination;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepo extends JpaRepository<Destination,Long> {
    List<Destination> findAllByIsPrivateFalse();
}
