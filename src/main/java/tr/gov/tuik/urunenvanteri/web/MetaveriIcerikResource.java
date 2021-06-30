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

    @GetMapping("/{id}")
    public Stream<MetaveriIcerikDto> icerikGetir(@PathVariable Long id){
        return metaveriIcerikRepository.getAllByMv_Id(id)
                .stream()
                .map(metaveriIcerikMapper::toDto);
    }
    @GetMapping
    public Stream<MetaveriIcerikDto> icerikler(){
        return metaveriIcerikRepository.findAll()
                .stream()
                .map(metaveriIcerikMapper::toDto);
    }
    @PostMapping
    public Stream<MetaveriIcerikDto> icerikEkle(@RequestBody MetaveriIcerikDto dto){

        metaveriIcerikRepository.save(metaveriIcerikMapper.toResourceEntity(dto));
        return icerikler();
    }

}
