package tr.gov.tuik.urunenvanteri.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.*;
import tr.gov.tuik.urunenvanteri.dto.mapper.IdariKayitMapper;
import tr.gov.tuik.urunenvanteri.dto.mapper.IdariKayitTabloMapper;
import tr.gov.tuik.urunenvanteri.dto.mapper.IletisimKisiMapper;
import tr.gov.tuik.urunenvanteri.dto.mapper.TabloBilgileriMapper;
import tr.gov.tuik.urunenvanteri.entity.IdariKayit;
import tr.gov.tuik.urunenvanteri.entity.Urun;
import tr.gov.tuik.urunenvanteri.exception.ResourceNotFoundException;
import tr.gov.tuik.urunenvanteri.repository.IdariKayitRepository;

import java.util.Collection;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/idari-kayitlar")
public class IdariKayitResource {
    private final IdariKayitRepository idariKayitRepository;
    private final IdariKayitMapper idariKayitMapper;
    private final IletisimKisiMapper iletisimKisiMapper;
    private final TabloBilgileriMapper tabloBilgileriMapper;
    private final IdariKayitTabloMapper idariKayitTabloMapper;


    public IdariKayitResource(IdariKayitRepository idariKayitRepository, IdariKayitMapper idariKayitMapper,
                              IletisimKisiMapper iletisimKisiMapper, TabloBilgileriMapper tabloBilgileriMapper, IdariKayitTabloMapper idariKayitTabloMapper) {
        this.idariKayitRepository = idariKayitRepository;
        this.idariKayitMapper = idariKayitMapper;
        this.iletisimKisiMapper = iletisimKisiMapper;
        this.tabloBilgileriMapper = tabloBilgileriMapper;
        this.idariKayitTabloMapper = idariKayitTabloMapper;
    }

    @GetMapping
    public Stream<IdariKayitDto> idariKayitlar() {
        return idariKayitRepository.findAllBy()
                .stream()
                .map(idariKayitMapper::toDto);
    }
    @PutMapping("version/{id}")
    public Stream<IdariKayitDto> kayitSil(@PathVariable String id){
        IdariKayit kayit = idariKayitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("İdari Kayıt", "id", id));
        kayit.setTaslak(true);
        return idariKayitlar();
    }
    @PostMapping
    public ResponseEntity<IdariKayit> idariKayitEkle(@RequestBody IdariKayitDto idariKayitDto){
            IdariKayit idariKayit = new IdariKayit();
            idariKayit.setTaslak(true);
            return new ResponseEntity<>(idariKayitRepository.save(idariKayitMapper.toEntity(idariKayitDto)), HttpStatus.OK);
    }
    @GetMapping("tablolar")
    public Stream<IdariKayitTabloDto> idariKayitTablolar() {
        return idariKayitRepository.findTablolarBy()
                .stream()
                .map(idariKayitTabloMapper::toDto);
    }

    @GetMapping("sayi")
    public Long kayitSayisi(){
        return idariKayitRepository.kayitSayisi();
    }

    @GetMapping("{id}/iletisim-kisileri")
    public Stream<IletisimKisiDto> idariKayitIletisimKisileri(@PathVariable String id) {
        return idariKayitRepository.findById(id)
                .map(IdariKayit::getIletisimKisileri)
                .map(Collection::stream)
                .orElseThrow(() -> new ResourceNotFoundException("IdariKayit", "id", id))
                .map(iletisimKisiMapper::toDto);
    }
    @GetMapping("{id}/tablo-bilgileri")
    public Stream<TabloBilgileriDto> idariKayitTabloBilgileri(@PathVariable String id){
        return idariKayitRepository.findById(id)
                .map(IdariKayit::getTabloBilgileri)
                .map(Collection::stream)
                .orElseThrow(() -> new ResourceNotFoundException("IdariKayit", "id", id))
                .map(tabloBilgileriMapper::toDto);
    }

    @PutMapping("guncelle/{id}")
    public IdariKayit idariKayitGuncelle(@PathVariable String id, @RequestBody IdariKayitDto idariKayitDto){
        IdariKayit idariKayit = idariKayitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("İdari Kayıt", "id", id));
        return idariKayitRepository.save(idariKayitMapper.toEntity(idariKayitDto));
    }

    @DeleteMapping("sil/{id}")
    public Stream<IdariKayitDto> idariKayitSil(@PathVariable String id){
        IdariKayit idariKayit = idariKayitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("İdari Kayıt", "id", id));
        if(idariKayit.getId().equals(id)){
            idariKayitRepository.delete(idariKayit);
        }
        return idariKayitlar();
    }

}
