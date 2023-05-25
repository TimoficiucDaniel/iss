package group.iss.Service;

import group.iss.Model.BucketListItem;
import group.iss.Model.Destination;
import group.iss.Model.User;
import group.iss.Repo.BucketListItemRepo;
import group.iss.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BucketListService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    BucketListItemRepo bucketListItemRepo;

    public List<BucketListItem> getBucketList(int page,Long id){

        return userRepo.findById(id).get().getBucketListItems().stream().skip(10*page).limit(10).collect(Collectors.toList());
    }

    public void saveUser(User user){
        userRepo.save(user);
    }

    public void saveDestination(Destination destination, Long id){

        BucketListItem item = new BucketListItem(userRepo.findById(id).get(),destination);
        bucketListItemRepo.save(item);
        userRepo.findById(id).get().addBucketListItem(item);
    }

    public void deleteDestination(Long id){
        bucketListItemRepo.deleteById(id);
    }
}
