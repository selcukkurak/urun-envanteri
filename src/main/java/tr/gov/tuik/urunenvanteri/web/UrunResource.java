package tr.gov.tuik.urunenvanteri.web;

import org.springframework.data.history.Revision;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.*;
import tr.gov.tuik.urunenvanteri.dto.mapper.*;
import tr.gov.tuik.urunenvanteri.entity.Urun;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.UrunRepository;
import tr.gov.tuik.urunenvanteri.security.Admin;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/urunler")
public class UrunResource {
    private final UrunRepository urunRepository;
    private final UrunMapper urunMapper;
    private final UrunKurulusMapper urunKurulusMapper;

    public UrunResource(UrunRepository urunRepository,UrunKurulusMapper urunKurulusMapper, UrunMapper urunMapper) {
        this.urunRepository = urunRepository;
        this.urunMapper = urunMapper;
        this.urunKurulusMapper = urunKurulusMapper;
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

    @GetMapping("{id}")
    public UrunDetayDto urunDetay(@PathVariable Long id) {
        return urunRepository.findWithDetayById(id)
                .map(urunMapper::toDetayDto)
                .orElseThrow(() -> new ResourceNotFoundException("Urun", "id", id));
    }

    @GetMapping("baglantilar")
    public Stream<UrunBagliUrunlerDto> urunBaglantilari() {
        return urunRepository.findWithUrunlerByTaslakFalse()
                .stream()
                .map(urunMapper::toBagliUrunDto);
    }

    @GetMapping("sayilar")
    public List<UrunRaporDto> sayilar() {
        return urunRepository.urunGirdiSayilari();
    }

    @GetMapping("kaynak-kurumlar")
    public Stream<UrunKaynakKurumDto> urunKaynakKurumlari() {
        return urunRepository.findAllWithIdariKayitBy()
                .stream()
                .map(UrunKaynakKurumMapper::toDto);
    }
    @GetMapping("kuruluslar")
    public Stream<UrunKurulusDto> urunKuruluslari() {
        return urunRepository.findAllWithPaylasimlarBy()
                .stream()
                .map(urunKurulusMapper::toDto);
    }
    @GetMapping("idari-kayitlar")
    public Stream<UrunIdariKayitDto> urunIdariKayitlari() {
        return urunRepository.findAllWithIdariKayitIdBy()
                .stream()
                .map(UrunIdariKayitMapper::toDto);
    }
    @GetMapping("anketler")
    public Stream<UrunAnketDto> urunAnketleri() {
        return urunRepository.findAllWithAnketIdBy()
                .stream()
                .map(UrunAnketMapper::toDto);
    }
    @Admin
    @GetMapping("{id}/loglar")
    public List<Revision<Integer, Urun>> urunLoglari(@PathVariable Long id) {
        return urunRepository.findRevisions(id).getContent();
    }
}
