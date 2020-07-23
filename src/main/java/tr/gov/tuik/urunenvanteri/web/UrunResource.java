package tr.gov.tuik.urunenvanteri.web;

import org.springframework.data.history.Revision;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.*;
import tr.gov.tuik.urunenvanteri.entity.Urun;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.UrunRepository;
import tr.gov.tuik.urunenvanteri.security.Admin;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/urunler")
public class UrunResource {
    private final UrunRepository urunRepository;
    private final UrunMapper urunMapper;
    private final AnketMapper anketMapper;
    private final IdariKayitMapper idariKayitMapper;

    public UrunResource(UrunRepository urunRepository, UrunMapper urunMapper, AnketMapper anketMapper, IdariKayitMapper idariKayitMapper) {
        this.urunRepository = urunRepository;
        this.urunMapper = urunMapper;
        this.anketMapper = anketMapper;
        this.idariKayitMapper = idariKayitMapper;
    }

    @GetMapping
    public Stream<UrunDto> urunler() {
        return urunRepository.findAllBy()
                .stream()
                .map(urunMapper::toDto);
    }

    @GetMapping(params = "onayli")
    public Stream<UrunDto> onayliUrunler(@RequestParam boolean onayli) {
        if (onayli) {
            return urunRepository.findByTaslakFalse()
                    .stream()
                    .map(urunMapper::toDto);
        } else return urunler();
    }

    @Admin
    @PostMapping
    public UrunDto urunEkle(@RequestBody UrunDto payload) {
        Urun urun = new Urun();
        urun.setKodu(payload.getKodu());
        urun.setAdi(payload.getAdi());
        urun.setCsa(payload.getCsa());
        urun.setBirimId(payload.getBirimId());

        return urunMapper.toDto(urunRepository.save(urun));
    }

    @Admin
    @PutMapping("{id}")
    public UrunDto urunGuncelle(@PathVariable Long id, @RequestBody UrunDto payload) {
        Urun urun = urunRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Urun", "id", id));

        urun.setKodu(payload.getKodu());
        urun.setAdi(payload.getAdi());
        urun.setCsa(payload.getCsa());
        urun.setBirimId(payload.getBirimId());

        return urunMapper.toDto(urunRepository.save(urun));
    }

    @Admin
    @GetMapping("{id}/loglar")
    public List<Revision<Integer, Urun>> urunLoglari(@PathVariable Long id) {
        return urunRepository.findRevisions(id).getContent();
    }

    @GetMapping("{id}/anketler")
    public Stream<AnketDto> urunAnketleri(@PathVariable Long id) {
        return urunRepository.findById(id)
                .map(Urun::getAnketler)
                .map(Collection::stream)
                .orElseThrow(() -> new ResourceNotFoundException("Urun", "id", id))
                .map(anketMapper::toDto);
    }

    @GetMapping("{id}/idari-kayitlar")
    public Stream<IdariKayitDto> urunIdariKayitlari(@PathVariable Long id) {
        return urunRepository.findById(id)
                .map(Urun::getIdariKayitlar)
                .map(Collection::stream)
                .orElseThrow(() -> new ResourceNotFoundException("Urun", "id", id))
                .map(idariKayitMapper::toDto);
    }
}
