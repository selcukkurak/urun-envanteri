package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.*;
import tr.gov.tuik.urunenvanteri.repository.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/referanslar")
public class ReferansResource {
    private final AracRepository aracRepository;
    private final CografiDuzeyRepository cografiDuzeyRepository;
    private final BirimDuzeyRepository birimDuzeyRepository;
    private final PeriyotRepository periyotRepository;
    private final KurulusRepository kurulusRepository;
    private final ReferansMapper referansMapper;

    public ReferansResource(AracRepository aracRepository, CografiDuzeyRepository cografiDuzeyRepository, BirimDuzeyRepository birimDuzeyRepository, PeriyotRepository periyotRepository, KurulusRepository kurulusRepository, ReferansMapper referansMapper) {
        this.aracRepository = aracRepository;
        this.cografiDuzeyRepository = cografiDuzeyRepository;
        this.birimDuzeyRepository = birimDuzeyRepository;
        this.periyotRepository = periyotRepository;
        this.kurulusRepository = kurulusRepository;
        this.referansMapper = referansMapper;
    }

    @GetMapping("araclar")
    public Stream<ReferansDto> araclar() {
        return aracRepository.findAll()
                .stream()
                .map(referansMapper::toDto);
    }

    @GetMapping("cografiDuzeyler")
    public Stream<ReferansDto> cografiDuzeyler() {
        return cografiDuzeyRepository.findAll()
                .stream()
                .map(referansMapper::toDto);
    }

    @GetMapping("birimDuzeyleri")
    public Stream<ReferansDto> birimDuzeyleri() {
        return birimDuzeyRepository.findAll()
                .stream()
                .map(referansMapper::toDto);
    }

    @GetMapping("periyotlar")
    public Stream<ReferansDto> periyotlar() {
        return periyotRepository.findAll()
                .stream()
                .map(referansMapper::toDto);
    }

    @GetMapping("kuruluslar")
    public Stream<ReferansDto> kuruluslar() {
        return kurulusRepository.findAll()
                .stream()
                .map(referansMapper::toDto);
    }
}
