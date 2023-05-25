package group.iss.Controller;

import group.iss.Model.BucketListItem;
import group.iss.Model.Destination;
import group.iss.Service.BucketListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BucketListController {

    @Autowired
    private BucketListService service;

    @GetMapping("/{id}/bucket-list/{page}")
    public List<BucketListItem> getBucketList(@PathVariable Long id,@PathVariable int page){
        return service.getBucketList(page,id);
    }

    @PostMapping("/{id}/bucket-list/add")
    public void addDestination(@PathVariable Long id, @RequestBody Destination destination){
        service.saveDestination(destination, id);
    }

    @DeleteMapping("/{id}/bucket-list/delete/{item}")
    public void deleteDestination(@PathVariable Long item){
        service.deleteDestination(item);
    }
}
