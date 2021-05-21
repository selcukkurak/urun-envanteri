package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.KolonBilgileriDto;
import tr.gov.tuik.urunenvanteri.dto.TabloBilgileriDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.KolonBilgileriMapper;
import tr.gov.tuik.urunenvanteri.repository.KolonBlgisiRepository;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kolon-bilgileri")
public class KolonBilgisiResource {

    private final KolonBlgisiRepository kolonBlgisiRepository;
    private final KolonBilgileriMapper kolonBilgileriMapper;

    @PostMapping
    public ResponseEntity<?> kolonEkle(@RequestBody TabloBilgileriDto dto){

        for (KolonBilgileriDto kolonBilgileriDto : dto.getKolonBilgileri()){
            kolonBlgisiRepository.save(kolonBilgileriMapper.toEntity(kolonBilgileriDto));
        }
        return ResponseEntity.ok().build();
    }
}
