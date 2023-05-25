package group.iss.Service;

import group.iss.Model.Destination;
import group.iss.Repo.DestinationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepo repo;

    public List<Destination> getPublicLists(int page){
        return repo.findAllByIsPrivateFalse().stream().skip(10*page).limit(10).collect(Collectors.toList());
    }

    public Destination saveDestination(Destination destination){
        return repo.save(destination);
    }

    public void deleteDestination(Long id){
        repo.deleteById(id);
    }

    public Destination getById(Long id){
        return repo.findById(id).get();
    }

    public byte[] getImageById(Long id){
        return repo.findById(id).get().getImage();
    }
}
