package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.MetaveriIcerikDto;
import tr.gov.tuik.urunenvanteri.dto.MetaveriKonuDto;
import tr.gov.tuik.urunenvanteri.dto.UrunGirdiCiktiBilgileriDto;
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
    @PostMapping
    public ResponseEntity<?> icerikEkle(@RequestBody MetaveriKonuDto dto){

        for (MetaveriIcerikDto icerikDto: dto.getIcerikler()){

            metaveriIcerikRepository.save(metaveriIcerikMapper.toEntity(icerikDto));


        }
        return ResponseEntity.ok().build();
    }

}
