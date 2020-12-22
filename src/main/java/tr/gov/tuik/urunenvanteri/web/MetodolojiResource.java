package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.MetodolojiDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.MetodolojiMapper;
import tr.gov.tuik.urunenvanteri.repository.MetodolojiRepository;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/metodolojiler")
public class MetodolojiResource {

    private final MetodolojiRepository metodolojiRepository;
    private final MetodolojiMapper metodolojiMapper;

    public MetodolojiResource(MetodolojiRepository metodolojiRepository, MetodolojiMapper metodolojiMapper) {
        this.metodolojiMapper = metodolojiMapper;
        this.metodolojiRepository = metodolojiRepository;
    }

    @GetMapping("{id}")
    public Stream<MetodolojiDto> getMetodolojiler(@PathVariable Long id) {
        return metodolojiRepository.getMetodolojiByUrunId(id)
                .stream()
                .map(metodolojiMapper::toDto);
    }
}
