package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.MetaveriKonuDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.MetaveriKonuMapper;
import tr.gov.tuik.urunenvanteri.entity.MetaveriKonu;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.MetaveriKonuRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/metaveriler")
public class MetaveriKonuResource {

    private final MetaveriKonuRepository metaveriKonuRepository;
    private final MetaveriKonuMapper metaveriKonuMapper;

    @GetMapping
    public Stream<MetaveriKonuDto> metaveriler(){
        return metaveriKonuRepository.getAllBy()
                .stream()
                .map(metaveriKonuMapper::toDto);
    }

    @GetMapping("{id}")
    public Stream<MetaveriKonuDto> metaverilerByUrunId(@PathVariable Long id){
        return metaveriKonuRepository.getAllByUrunId(id)
                .stream()
                .map(metaveriKonuMapper::toDto);
    }

    @PostMapping
    public Stream<MetaveriKonuDto> metaveriEkle(@RequestBody MetaveriKonuDto metaveriKonuDto){
        metaveriKonuRepository.save(
                metaveriKonuMapper.toEntity(metaveriKonuDto)
        );
        return metaveriler();
    }

    @PutMapping("guncelle/{id}")
    public Stream<MetaveriKonuDto> metaveriGuncelle(@PathVariable Long id, @RequestBody MetaveriKonuDto metaveriKonuDto){
        MetaveriKonu metaveriKonu = metaveriKonuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("metaveri", "id" ,id));
        if(metaveriKonu.getId().equals(id)){
            metaveriKonuRepository.save(metaveriKonuMapper.toEntity(metaveriKonuDto));
        }
        return metaveriler();
    }

    @DeleteMapping("sil/{id}")
    public Stream<MetaveriKonuDto> metaveriSil(@PathVariable Long id){
        MetaveriKonu metaveriKonu = metaveriKonuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("metaveri", "id" ,id));
        if(metaveriKonu.getId().equals(id)){
            metaveriKonuRepository.delete(metaveriKonu);
        }
        return metaveriler();
    }

}