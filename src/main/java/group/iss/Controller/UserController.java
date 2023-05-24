package group.iss.Controller;

import group.iss.Model.BucketListItem;
import group.iss.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;
}
