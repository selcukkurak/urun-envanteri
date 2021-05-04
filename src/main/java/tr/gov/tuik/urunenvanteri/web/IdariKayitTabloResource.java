package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.IdariKayitDto;
import tr.gov.tuik.urunenvanteri.dto.PaylasimDto;
import tr.gov.tuik.urunenvanteri.dto.TabloBilgileriDto;
import tr.gov.tuik.urunenvanteri.dto.UrunGirdiCiktiBilgileriDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.IdariKayitTabloMapper;
import tr.gov.tuik.urunenvanteri.dto.mapper.TabloBilgileriMapper;
import tr.gov.tuik.urunenvanteri.repository.IdariKayitTabloRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/idari-kayit/tablolar")
public class IdariKayitTabloResource {

    private final IdariKayitTabloRepository idariKayitTabloRepository;
    private final TabloBilgileriMapper tabloBilgileriMapper;

    @GetMapping("/{id}")
    private Stream<TabloBilgileriDto> tablolar(@PathVariable String id){
        return idariKayitTabloRepository.getAllByIdariKayitId(id)
                .stream()
                .map(tabloBilgileriMapper::toDto);
    }

    @PostMapping
    public ResponseEntity<?> paylasimEkle(@RequestBody IdariKayitDto list) {

        for (TabloBilgileriDto dto : list.getTablolar()) {
            idariKayitTabloRepository.save(tabloBilgileriMapper.toEntity(dto));

        }
        return ResponseEntity.ok().build();
    }
}
