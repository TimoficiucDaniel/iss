package group.iss.Repo;

import group.iss.Model.BucketListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketListItemRepo extends JpaRepository<BucketListItem,Long> {

    public BucketListItem findByUserIdAndDestinationId(Long userId, Long destinationId);
}
