package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.entity.Birim;
import tr.gov.tuik.urunenvanteri.repository.BirimRepository;

import java.util.List;

@RestController
@RequestMapping("/api/birimler")
public class BirimlerResource {

    private final BirimRepository birimRepository;

    public BirimlerResource(BirimRepository repository){
        birimRepository = repository;
    }

    @GetMapping
    public List<Birim> merkezBirimler() {
        return birimRepository.findAll();
    }
}
