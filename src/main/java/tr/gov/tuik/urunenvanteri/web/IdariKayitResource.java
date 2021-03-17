package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.IdariKayitDto;
import tr.gov.tuik.urunenvanteri.dto.IdariKayitTabloDto;
import tr.gov.tuik.urunenvanteri.dto.TabloBilgileriDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.IdariKayitMapper;
import tr.gov.tuik.urunenvanteri.dto.IletisimKisiDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.IdariKayitTabloMapper;
import tr.gov.tuik.urunenvanteri.dto.mapper.IletisimKisiMapper;
import tr.gov.tuik.urunenvanteri.dto.mapper.TabloBilgileriMapper;
import tr.gov.tuik.urunenvanteri.entity.IdariKayit;
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
    @GetMapping("tablolar")
    public Stream<IdariKayitTabloDto> idariKayitTablolar() {
        return idariKayitRepository.findTablolarBy()
                .stream()
                .map(idariKayitTabloMapper::toDto);
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

}
