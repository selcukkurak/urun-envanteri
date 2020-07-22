package tr.gov.tuik.urunenvanteri.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.UrunDto;
import tr.gov.tuik.urunenvanteri.dto.UrunMapper;
import tr.gov.tuik.urunenvanteri.entity.Urun;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.UrunRepository;
import tr.gov.tuik.urunenvanteri.security.Admin;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/urunler")
public class UrunResource {
    private final UrunRepository urunRepository;
    private final UrunMapper urunMapper;

    public UrunResource(UrunRepository urunRepository, UrunMapper urunMapper) {
        this.urunRepository = urunRepository;
        this.urunMapper = urunMapper;
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
    public List urunLoglari(@PathVariable Long id) {
        return urunRepository.findRevisions(id).getContent();
    }
}
