package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.PaylasimDto;
import tr.gov.tuik.urunenvanteri.dto.PaylasimKurulusDto;
import tr.gov.tuik.urunenvanteri.dto.UrunGirdiCiktiBilgileriDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.PaylasimKurulusMapper;
import tr.gov.tuik.urunenvanteri.dto.mapper.PaylasimMapper;
import tr.gov.tuik.urunenvanteri.entity.Paylasim;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.PaylasimRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/paylasimlar")
public class PaylasimResource {

    private final PaylasimRepository paylasimRepository;
    private final PaylasimKurulusMapper paylasimKurulusMapper;
    private final PaylasimMapper paylasimMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public Stream<PaylasimKurulusDto> paylasimlariGetir() {
        return paylasimRepository.findAllBy()
                .stream()
                .map(paylasimKurulusMapper::toDto);
    }

    @GetMapping("tum")
    public Stream<PaylasimDto> tumPaylasimAlanlariniGetir() {
        return paylasimRepository.findAllBy()
                .stream()
                .map(paylasimMapper::toDto);
    }

    @PostMapping
    public ResponseEntity<?> paylasimEkle(@RequestBody UrunGirdiCiktiBilgileriDto list) {

        for (PaylasimDto dto : list.getPaylasimlar()) {
            paylasimRepository.save(paylasimMapper.toEntity(dto));

        }
        return ResponseEntity.ok().build();
    }



    @PutMapping("guncelle/{id}")
    public Stream<PaylasimDto> paylasimGuncelle(@PathVariable Long id, @RequestBody PaylasimDto paylasimDto){
        Paylasim paylasim = paylasimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paylasim", "id", id));
        if(paylasim.getId().equals(id)){
            paylasimRepository.save(paylasimMapper.toEntity(paylasimDto));
        }
        return tumPaylasimAlanlariniGetir();
    }
}
