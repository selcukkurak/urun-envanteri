package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.AnketDto;
import tr.gov.tuik.urunenvanteri.dto.AnketMapper;
import tr.gov.tuik.urunenvanteri.repository.AnketRepository;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/anketler")
public class AnketResource {
    private final AnketRepository anketRepository;
    private final AnketMapper anketMapper;

    public AnketResource(AnketRepository anketRepository, AnketMapper anketMapper) {
        this.anketRepository = anketRepository;
        this.anketMapper = anketMapper;
    }

    @GetMapping
    public Stream<AnketDto> anketler() {
        return anketRepository.findAll()
                .stream()
                .map(anketMapper::toDto);
    }
}
