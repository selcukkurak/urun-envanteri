package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniIstatikselTabloDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.HaberBulteniIstatikselTabloMapper;
import tr.gov.tuik.urunenvanteri.repository.IstatikselTabloRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/istatiksel-tablolar")
public class IstatikselTabloResource {

    private final IstatikselTabloRepository istatikselTabloRepository;
    private final HaberBulteniIstatikselTabloMapper haberBulteniIstatikselTabloMapper;

    @GetMapping
    public Stream<HaberBulteniIstatikselTabloDto> istatikselTablolar(){
        return istatikselTabloRepository.getAllBy()
                .stream()
                .map(haberBulteniIstatikselTabloMapper::toDto);
    }

    @GetMapping("{id}")
    public Stream<HaberBulteniIstatikselTabloDto> bulteneGoreIstatikselTablolar(@PathVariable String id){
        return istatikselTabloRepository.getAllByBultenId(id)
                .stream()
                .map(haberBulteniIstatikselTabloMapper::toDto);
    }
}
