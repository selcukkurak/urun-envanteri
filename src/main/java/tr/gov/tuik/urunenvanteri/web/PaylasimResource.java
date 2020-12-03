package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.PaylasimDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.PaylasimMapper;
import tr.gov.tuik.urunenvanteri.repository.PaylasimRepository;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/paylasimlar")
public class PaylasimResource {

    private final PaylasimRepository paylasimRepository;
    private final PaylasimMapper paylasimMapper;

    public PaylasimResource(PaylasimRepository paylasimRepository, PaylasimMapper paylasimMapper) {
        this.paylasimRepository = paylasimRepository;
        this.paylasimMapper = paylasimMapper;
    }

    @GetMapping
    public Stream<PaylasimDto> paylasimlariGetir(){
        return paylasimRepository.findAllBy()
                .stream()
                .map(paylasimMapper::toDto);
    }
 }
