package tr.gov.tuik.urunenvanteri.web;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.PaylasimKurulusDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.PaylasimKurulusMapper;
import tr.gov.tuik.urunenvanteri.repository.PaylasimRepository;

import java.util.List;
import java.util.stream.Stream;
@RestController
@RequestMapping("/api/paylasimlar")
public class PaylasimResource {

    private final PaylasimRepository paylasimRepository;
    private final PaylasimKurulusMapper paylasimKurulusMapper;

    public PaylasimResource(PaylasimRepository paylasimRepository, PaylasimKurulusMapper paylasimKurulusMapper) {
        this.paylasimRepository = paylasimRepository;
        this.paylasimKurulusMapper = paylasimKurulusMapper;
    }

    @GetMapping
    public Stream<PaylasimKurulusDto> paylasimlariGetir(){
        return paylasimRepository.findAllBy()
                .stream()
                .map(paylasimKurulusMapper::toDto);
    }
 }
