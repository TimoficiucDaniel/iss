package group.iss.Controller;

import group.iss.Model.Destination;
import group.iss.Service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    @Autowired
    DestinationService service;

    @GetMapping("/details/{id}")
    public Destination getDestination(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/{page}")
    public List<Destination> getDestinations(@PathVariable int page){
        return service.getPublicLists(page);
    }

    @PostMapping("/add")
    public Destination addDestination(@RequestBody Destination destination){
        return service.saveDestination(destination);
    }

    @PutMapping("/edit/{id}")
    public Destination updateDestination(@RequestBody Destination destination, @PathVariable Long id){
        Destination oldDestination = service.getById(id);

        oldDestination.setDescription(destination.getDescription());
        oldDestination.setTitle(destination.getTitle());
        oldDestination.setArrival_date(destination.getArrival_date());
        oldDestination.setDeparture_date(destination.getDeparture_date());

        return service.saveDestination(oldDestination);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDestination(@PathVariable Long id){
        service.deleteDestination(id);
    }
}
