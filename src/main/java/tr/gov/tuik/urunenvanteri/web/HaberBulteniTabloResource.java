package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniTabloDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.HaberBulteniTabloMapper;
import tr.gov.tuik.urunenvanteri.repository.HaberBulteniTabloRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bulten-tablolari")
public class HaberBulteniTabloResource {

    private final HaberBulteniTabloRepository haberBulteniTabloRepository;
    private final HaberBulteniTabloMapper haberBulteniTabloMapper;

    @GetMapping
    public Stream<HaberBulteniTabloDto> tablolar(){
        return haberBulteniTabloRepository.getAllBy()
                .stream()
                .map(haberBulteniTabloMapper::toDto);
    }

    @GetMapping("{id}")
    public Stream<HaberBulteniTabloDto> bulteneGoreTablolariGetir(@PathVariable String id){
        return haberBulteniTabloRepository.getAllByBultenId(id)
                .stream()
                .map(haberBulteniTabloMapper::toDto);

    }
}