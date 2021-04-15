package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.AnketDto;
import tr.gov.tuik.urunenvanteri.dto.UrunDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.AnketMapper;
import tr.gov.tuik.urunenvanteri.entity.Anket;
import tr.gov.tuik.urunenvanteri.entity.Urun;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.AnketRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/anketler")
public class AnketResource {
    private final AnketRepository anketRepository;
    private final AnketMapper anketMapper;

    public AnketResource(AnketRepository anketRepository, AnketMapper anketMapper) {
        this.anketRepository = anketRepository;
        this.anketMapper = anketMapper;
    }

    @GetMapping
    public Stream<AnketDto> anketler() {
        return anketRepository.findAllBy()
                .stream()
                .map(anketMapper::toDto);
    }

    @GetMapping("sayi")
    public Long anketSayisi(){
        return anketRepository.anketSayisi();
    }

    @PostMapping("ekle")
    public Stream<AnketDto> anketEkle(@RequestBody AnketDto anketDto){
        anketRepository.save(anketMapper.toEntity(anketDto));
        return anketler();
    }

    @DeleteMapping("sil/{id}")
    public Stream<AnketDto> deleteEmployee(@PathVariable String id)
            throws ResourceNotFoundException {
        Anket anket = anketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bu id ile ilişkili anket bulunmamaktadır :: " + id));
        if(anket.getId().equals(id)){
            anketRepository.delete(anket);
        }
        return anketler();

    }
    @PutMapping("guncelle/{id}")
    public Stream<AnketDto> urunuGuncelle(@PathVariable String id, @RequestBody AnketDto anketDto) {
        Anket anket = anketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anket", "id", id));
        if(anket.getId().equals(id)) {
            anketRepository.save(anketMapper.toEntity(anketDto));
        }
        return anketler();

    }

}
