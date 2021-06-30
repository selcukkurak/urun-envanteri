package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.HaberBulteniMapper;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteni;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.HaberBulteniRepository;

import java.util.ArrayList;
import java.util.List;
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
    public ResponseEntity<HaberBulteni> bultenEkle(@RequestBody HaberBulteniDto haberBulteniDto) {
        HaberBulteni haberBulteni = new HaberBulteni();
        haberBulteni.setTaslak(true);
        return new ResponseEntity<>(haberBulteniRepository.save(haberBulteniMapper.toEntity(haberBulteniDto)), HttpStatus.OK);
    }

    @PutMapping("guncelle/{id}")
    public ResponseEntity<HaberBulteni> bultenGuncelle(@PathVariable String id, @RequestBody HaberBulteniDto haberBulteniDto){
        HaberBulteni haberBulteni = haberBulteniRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Haber Bülteni", "id", id));
        return new ResponseEntity<>(haberBulteniRepository.save(haberBulteniMapper.toEntity(haberBulteniDto)), HttpStatus.OK);
    }

    @PutMapping("urun")
    private List<HaberBulteni> urunIdGuncelle(@RequestBody List<HaberBulteniDto> dtoList) {
        List<HaberBulteni> haberBultenleri = new ArrayList<>();
        for (HaberBulteniDto dto : dtoList) {
            HaberBulteni haberBulteni = haberBulteniRepository.findById(dto.getKodu())
                    .orElseThrow(() -> new ResourceNotFoundException("kodu", "haber bülteni" , dto.getKodu()));
            haberBulteniRepository.save(haberBulteniMapper.toEntity(dto));
        }
        return haberBultenleri;
    }

    @DeleteMapping("sil/{id}")
    public Stream<HaberBulteniDto> bultenSil(@PathVariable String id){
        HaberBulteni haberBulteni = haberBulteniRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Haber Bülteni", "id", id));
        haberBulteni.setSilindi(true);
        return bultenleriGetir();
    }
}
