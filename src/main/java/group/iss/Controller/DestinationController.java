package group.iss.Controller;

import group.iss.Model.Destination;
import group.iss.Service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Destination getDestination(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping(value = "/image/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public byte[] getDestinationImage(@PathVariable Long id){
        return service.getImageById(id);
    }

    @GetMapping("/{page}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Destination> getDestinations(@PathVariable int page){
        return service.getPublicLists(page);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Destination addDestination(@RequestBody Destination destination){
        return service.saveDestination(destination);
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Destination updateDestination(@RequestBody Destination destination, @PathVariable Long id){
        Destination oldDestination = service.getById(id);

        oldDestination.setDescription(destination.getDescription());
        oldDestination.setTitle(destination.getTitle());
        oldDestination.setArrival_date(destination.getArrival_date());
        oldDestination.setDeparture_date(destination.getDeparture_date());

        return service.saveDestination(oldDestination);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteDestination(@PathVariable Long id){
        service.deleteDestination(id);
    }
}
