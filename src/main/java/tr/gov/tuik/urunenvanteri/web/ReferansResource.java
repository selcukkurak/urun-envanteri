package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.ReferansDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.ReferansMapper;
import tr.gov.tuik.urunenvanteri.dto.ReferanslarPayload;
import tr.gov.tuik.urunenvanteri.entity.ReferansTipi;
import tr.gov.tuik.urunenvanteri.repository.ReferansRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/referanslar")
public class ReferansResource {
    private final ReferansRepository referansRepository;
    private final ReferansMapper referansMapper;

    public ReferansResource(ReferansRepository referansRepository, ReferansMapper referansMapper) {
        this.referansRepository = referansRepository;
        this.referansMapper = referansMapper;
    }

    @GetMapping
    public ReferanslarPayload referanslar() {
        return new ReferanslarPayload(
                ReferansTipi.values(),
                referansRepository.findAll()
                        .stream()
                        .map(referansMapper::toDto)
                        .collect(Collectors.groupingBy(ReferansDto::getTipi))
        );
    }

    @GetMapping("tipler")
    public ReferansTipi[] referansTipleri() {
        return ReferansTipi.values();
    }

    @GetMapping("kurum-sayisi")
    public Object kurumSayisi(){ return referansRepository.kurumSayisi(); }

    @GetMapping("kurulus-sayisi")
    public Object kurulusSayisi(){ return referansRepository.kurulusSayisi(); }

    @GetMapping(params = "tipi")
    public Stream<ReferansDto> araclar(@RequestParam ReferansTipi tipi) {
        return referansRepository.findByTipi(tipi)
                .stream()
                .map(referansMapper::toDto);
    }
}
