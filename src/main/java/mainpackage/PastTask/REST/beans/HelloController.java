package mainpackage.PastTask.REST.beans;

import mainpackage.PastTask.REST.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @GetMapping("/france")
    public ResponseEntity<Country> hello(){
        Country c = Country.of("France",87);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("continent","Europe")
                .header("capital","Paris")
                .header("favourite food","wine and cheese")
                .body(c);
    }

    @GetMapping("/all")
    public List<Country> countryList(){
        Country france = Country.of("France",97);
        Country spain = Country.of("Spain",47);
        return List.of(france,spain);
    }

}
