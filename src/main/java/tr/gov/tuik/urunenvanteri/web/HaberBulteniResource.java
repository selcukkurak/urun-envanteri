package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.*;
import tr.gov.tuik.urunenvanteri.dto.mapper.*;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteni;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.HaberBulteniRepository;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/bultenler")
public class HaberBulteniResource {

    private final HaberBulteniRepository haberBulteniRepository;
    private final HaberBulteniMapper haberBulteniMapper;

    public HaberBulteniResource(HaberBulteniRepository bultenRepository, HaberBulteniMapper bultenMapper){
        haberBulteniRepository = bultenRepository;
        haberBulteniMapper = bultenMapper;
    }

    @GetMapping
    public Stream<HaberBulteni> bultenler() {
        return (Stream<HaberBulteni>) haberBulteniRepository.findAll();
    }


}
