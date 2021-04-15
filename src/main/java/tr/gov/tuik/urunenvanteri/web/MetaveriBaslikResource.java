package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.MetaveriAlanDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.MetaveriAlanMapper;
import tr.gov.tuik.urunenvanteri.repository.MetaveriBaslikRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/metaveri-basliklar")
public class MetaveriBaslikResource {

    private final MetaveriBaslikRepository metaveriBaslikRepository;
    private final MetaveriAlanMapper metaveriAlanMapper;

    @GetMapping
    public Stream<MetaveriAlanDto> alanlariGetir(){
        return metaveriBaslikRepository.getAllBy()
                .stream()
                .map(metaveriAlanMapper::toDto);
    }
}
