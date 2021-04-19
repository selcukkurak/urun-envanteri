package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.HaberBulteniMapper;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteni;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.HaberBulteniRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/yeni-bultenler")
public class HaberBulteniYeniResource {

    private final HaberBulteniRepository haberBulteniRepository;
    private final HaberBulteniMapper haberBulteniMapper;

    @GetMapping
    public Stream<HaberBulteniDto> bultenleriGetir() {
        return haberBulteniRepository.getAllBy()
                .stream()
                .map(haberBulteniMapper::toDto);
    }

    @PostMapping
    public HaberBulteni bultenEkle(@RequestBody HaberBulteniDto haberBulteniDto) {
        return haberBulteniRepository.save(haberBulteniMapper.toEntity(haberBulteniDto));
    }

    @PutMapping("guncelle/{id}")
    public Stream<HaberBulteniDto> bultenGuncelle(@PathVariable String id, @RequestBody HaberBulteniDto haberBulteniDto){
        HaberBulteni haberBulteni = haberBulteniRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Haber Bülteni", "id", id));
        if (haberBulteni.getId().equals(id)){
            haberBulteniRepository.save(haberBulteniMapper.toEntity(haberBulteniDto));
        }
        return bultenleriGetir();
    }

    @DeleteMapping("sil/{id}")
    public Stream<HaberBulteniDto> bultenSil(@PathVariable String id){
        HaberBulteni haberBulteni = haberBulteniRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Haber Bülteni", "id", id));
        if (haberBulteni.getId().equals(id)){
            haberBulteniRepository.delete(haberBulteni);
        }
        return bultenleriGetir();
    }
}
