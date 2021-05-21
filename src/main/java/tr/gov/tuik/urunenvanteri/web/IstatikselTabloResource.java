package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniIstatikselTabloDto;
import tr.gov.tuik.urunenvanteri.dto.KategoriDetayDto;
import tr.gov.tuik.urunenvanteri.dto.KategoriDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.HaberBulteniIstatikselTabloMapper;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteniIstatikselTablo;
import tr.gov.tuik.urunenvanteri.repository.IstatikselTabloRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/istatiksel-tablolar")
public class IstatikselTabloResource {

    private final IstatikselTabloRepository istatikselTabloRepository;
    private final HaberBulteniIstatikselTabloMapper haberBulteniIstatikselTabloMapper;


    @GetMapping("{id}")
    public Stream<HaberBulteniIstatikselTabloDto> bulteneGoreIstatikselTablolar(@PathVariable Long id){
        return istatikselTabloRepository.getAllByKategoriId(id)
                .stream()
                .map(haberBulteniIstatikselTabloMapper::toDto);
    }

    @PostMapping
    public ResponseEntity<?> istatikselTabloEkle(@RequestBody KategoriDetayDto kategoriDto){

        for (HaberBulteniIstatikselTabloDto dto : kategoriDto.getIstatikselTablolar()){
            istatikselTabloRepository.save(haberBulteniIstatikselTabloMapper.toEntity(dto));
        }
        return ResponseEntity.ok().build();
    }
}
