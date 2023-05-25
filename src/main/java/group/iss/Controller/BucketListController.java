package group.iss.Controller;

import group.iss.Model.BucketListItem;
import group.iss.Model.Destination;
import group.iss.Service.BucketListService;
import group.iss.Service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BucketListController {

    @Autowired
    private BucketListService service;

    @Autowired
    DestinationService destinationService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}/bucket-list/{page}")
    public List<BucketListItem> getBucketList(@PathVariable Long id,@PathVariable int page){
        return service.getBucketList(page,id);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/{id}/bucket-list/add")
    public void addDestination(@PathVariable Long id, @RequestBody Long destinationId){
        Destination destination = destinationService.getById(destinationId);
        service.saveDestination(destination, id);
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{id}/bucket-list/delete/{item}")
    public void deleteDestination(@PathVariable Long item){
        service.deleteDestination(item);
    }
}
