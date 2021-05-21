package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.BultenDetayDto;
import tr.gov.tuik.urunenvanteri.dto.KategoriDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.KategoriMapper;
import tr.gov.tuik.urunenvanteri.repository.KategoriRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kategoriler")
public class KategoriResource {

    private final KategoriRepository kategoriRepository;
    private final KategoriMapper kategoriMapper;

    @GetMapping("{id}")
    public Stream<KategoriDto> kategoriler(@PathVariable String id){
        return kategoriRepository.findByBultenId(id)
                .stream()
                .map(kategoriMapper::toDto);
    }

    @PostMapping
    public ResponseEntity<?> kategoriEkle(@RequestBody BultenDetayDto detayDto) {

        for (KategoriDto dto  : detayDto.getKategoriler()) {
            kategoriRepository.save(kategoriMapper.toEntity(dto));
        }
        return ResponseEntity.ok().build();
    }
}
