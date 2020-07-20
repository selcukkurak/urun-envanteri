package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.AracDto;
import tr.gov.tuik.urunenvanteri.dto.BirimDuzeyDto;
import tr.gov.tuik.urunenvanteri.dto.CografiDuzeyDto;
import tr.gov.tuik.urunenvanteri.dto.ReferansMapper;
import tr.gov.tuik.urunenvanteri.repository.AracRepository;
import tr.gov.tuik.urunenvanteri.repository.BirimDuzeyRepository;
import tr.gov.tuik.urunenvanteri.repository.CografiDuzeyRepository;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/referanslar")
public class ReferansResource {
    private final AracRepository aracRepository;
    private final CografiDuzeyRepository cografiDuzeyRepository;
    private final BirimDuzeyRepository birimDuzeyRepository;
    private final ReferansMapper referansMapper;

    public ReferansResource(AracRepository aracRepository, CografiDuzeyRepository cografiDuzeyRepository, BirimDuzeyRepository birimDuzeyRepository, ReferansMapper referansMapper) {
        this.aracRepository = aracRepository;
        this.cografiDuzeyRepository = cografiDuzeyRepository;
        this.birimDuzeyRepository = birimDuzeyRepository;
        this.referansMapper = referansMapper;
    }

    @GetMapping("araclar")
    public Stream<AracDto> araclar() {
        return aracRepository.findAll()
                .stream()
                .map(referansMapper::toDto);
    }

    @GetMapping("cografiDuzeyler")
    public Stream<CografiDuzeyDto> cografiDuzeyler() {
        return cografiDuzeyRepository.findAll()
                .stream()
                .map(referansMapper::toDto);
    }

    @GetMapping("birimDuzeyleri")
    public Stream<BirimDuzeyDto> birimDuzeyleri() {
        return birimDuzeyRepository.findAll()
                .stream()
                .map(referansMapper::toDto);
    }
}
