package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.AnketDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.AnketMapper;
import tr.gov.tuik.urunenvanteri.entity.Anket;
import tr.gov.tuik.urunenvanteri.repository.AnketRepository;

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
    public Object anketSayisi(){ return anketRepository.anketSayisi(); }

    @PostMapping("ekle")
    public Stream<AnketDto> anketEkle(@RequestBody AnketDto anketDto){
        anketRepository.save(anketMapper.toEntity(anketDto));
        return anketler();
    }

    @DeleteMapping("sil/{id}")
    public void anketSil(@PathVariable String id){

    }
}
