package group.iss.Service;

import group.iss.Model.BucketListItem;
import group.iss.Model.Destination;
import group.iss.Model.User;
import group.iss.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public List<BucketListItem> getBucketList(int page,Long id){

        return repo.findById(id).get().getBucketListItems().stream().skip(10*page).limit(10).collect(Collectors.toList());
    }

    public void saveUser(User user){
        repo.save(user);
    }

    public void saveDestination(Destination destination, Long id){
        repo.findById(id).get().addBucketListItem(new BucketListItem(repo.findById(id).get(),destination));
    }
}
