package lk.ijse.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@CrossOrigin(origins = "http://localhost:63342")
*/
@RestController
@RequestMapping("api/v1/health")
public class HealthCheckController {
    @GetMapping
    public String healthCheck() {
        return "OK:) PROJECT IS WORKING";
    }
}
