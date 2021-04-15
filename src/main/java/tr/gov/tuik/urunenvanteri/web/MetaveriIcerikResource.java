package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.MetaveriIcerikDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.MetaveriIcerikMapper;
import tr.gov.tuik.urunenvanteri.repository.MetaveriIcerikRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/metaveri-icerikler")
public class MetaveriIcerikResource {

    private final MetaveriIcerikRepository metaveriIcerikRepository;
    private final MetaveriIcerikMapper metaveriIcerikMapper;

    @GetMapping("{id")
    public Stream<MetaveriIcerikDto> icerikler(@PathVariable Long id){
        return metaveriIcerikRepository.getAllByMv_Id(id)
                .stream()
                .map(metaveriIcerikMapper::toDto);
    }


}
