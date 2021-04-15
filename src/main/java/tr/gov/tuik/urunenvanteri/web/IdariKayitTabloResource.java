package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.TabloBilgileriDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.IdariKayitTabloMapper;
import tr.gov.tuik.urunenvanteri.dto.mapper.TabloBilgileriMapper;
import tr.gov.tuik.urunenvanteri.repository.IdariKayitTabloRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/idari-kayit/tablolar")
public class IdariKayitTabloResource {

    private final IdariKayitTabloRepository idariKayitTabloRepository;
    private final TabloBilgileriMapper tabloBilgileriMapper;

    @GetMapping("/{id}")
    private Stream<TabloBilgileriDto> tablolar(@PathVariable String id){
        return idariKayitTabloRepository.getAllByIdariKayitId(id)
                .stream()
                .map(tabloBilgileriMapper::toDto);
    }
}
