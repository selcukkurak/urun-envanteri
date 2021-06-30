package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.security.Deneme;

@RestController
@RequestMapping("/api/deneme")
public class DenemeResource {

    @Deneme
    @GetMapping
    public String hello(){
        return "hello word";
    }
}
