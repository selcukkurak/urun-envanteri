package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.IdariKayitDto;
import tr.gov.tuik.urunenvanteri.dto.IdariKayitMapper;
import tr.gov.tuik.urunenvanteri.repository.IdariKayitRepository;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/idari-kayitlar")
public class IdariKayitResource {
    private final IdariKayitRepository idariKayitRepository;
    private final IdariKayitMapper idariKayitMapper;

    public IdariKayitResource(IdariKayitRepository idariKayitRepository, IdariKayitMapper idariKayitMapper) {
        this.idariKayitRepository = idariKayitRepository;
        this.idariKayitMapper = idariKayitMapper;
    }

    @GetMapping
    public Stream<IdariKayitDto> idariKayitlar() {
        return idariKayitRepository.findAllBy()
                .stream()
                .map(idariKayitMapper::toDto);
    }
}
