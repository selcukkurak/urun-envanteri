package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.client.TakvimClient;
import tr.gov.tuik.urunenvanteri.client.WebIcerikClient;
import tr.gov.tuik.urunenvanteri.dto.*;
import tr.gov.tuik.urunenvanteri.dto.mapper.*;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteni;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.HaberBulteniRepository;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/bultenler")
public class HaberBulteniResource {
    private final WebIcerikClient webIcerikClient;
    private final TakvimClient takvimClient;
    private final HaberBulteniRepository haberBulteniRepository;
    private final HaberBulteniMapper haberBulteniMapper;

    public HaberBulteniResource(WebIcerikClient webIcerikClient, TakvimClient takvimClient, HaberBulteniRepository haberBulteniRepository, HaberBulteniMapper haberBulteniMapper) {
        this.webIcerikClient = webIcerikClient;
        this.takvimClient = takvimClient;
        this.haberBulteniRepository = haberBulteniRepository;
        this.haberBulteniMapper = haberBulteniMapper;
    }

    @GetMapping
    public Stream<Bulten> bultenler() {
        return webIcerikClient.getHaberBultenleri()
                .stream()
                .map(BultenMapper::toDto);
    }

    @GetMapping("/url")
    public String bultenUrlGetir(@RequestParam int id, @RequestParam int dilId) {
        String bultenBaslik = takvimClient.getHaberBulteniLink(id, dilId);
        return "https://data.tuik.gov.tr/Bulten/Index?p=" + bultenBaslik;
    }

    @GetMapping("/metaveri/{id}")
    public Stream<List<MetaveriDto>> metaverileriGetir(@PathVariable List<Long> id) {
        return webIcerikClient.getBultenMetaverileri(id)
                .stream()
                .map(MetaveriMapper::toDtoList);

    }

    @GetMapping("yeni")
    public Stream<HaberBulteniDto> bultenleriGetir() {
        return haberBulteniRepository.getAllBy()
                .stream()
                .map(haberBulteniMapper::toDto);
    }

    @PostMapping
    public Stream<HaberBulteniDto> bultenEkle(@RequestBody HaberBulteniDto haberBulteniDto) {
        haberBulteniRepository.save(haberBulteniMapper.toEntity(haberBulteniDto));
        return bultenleriGetir();
    }

    @PutMapping("guncelle/{id}")
    public Stream<HaberBulteniDto> bultenGuncelle(@PathVariable String id, @RequestBody HaberBulteniDto haberBulteniDto){
        HaberBulteni haberBulteni = haberBulteniRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Haber Bülteni", "id", id));
        if (haberBulteni.getId().equals(id)){
            haberBulteniRepository.save(haberBulteniMapper.toEntity(haberBulteniDto));
        }
        return bultenleriGetir();
    }

    @DeleteMapping("sil/{id}")
    public Stream<HaberBulteniDto> bultenSil(@PathVariable String id){
        HaberBulteni haberBulteni = haberBulteniRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Haber Bülteni", "id", id));
        if (haberBulteni.getId().equals(id)){
            haberBulteniRepository.delete(haberBulteni);
        }
        return bultenleriGetir();
    }
}
