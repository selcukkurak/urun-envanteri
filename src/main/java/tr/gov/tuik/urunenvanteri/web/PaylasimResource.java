package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.*;
import tr.gov.tuik.urunenvanteri.dto.PaylasimDto;
import tr.gov.tuik.urunenvanteri.dto.PaylasimKurulusDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.PaylasimKurulusMapper;
import tr.gov.tuik.urunenvanteri.dto.mapper.PaylasimMapper;
import tr.gov.tuik.urunenvanteri.repository.PaylasimRepository;

import java.util.stream.Stream;
@RestController
@RequestMapping("/api/paylasimlar")
public class PaylasimResource {

    private final PaylasimRepository paylasimRepository;
    private final PaylasimKurulusMapper paylasimKurulusMapper;

    public PaylasimResource(PaylasimRepository paylasimRepository, PaylasimKurulusMapper paylasimKurulusMapper) {
        this.paylasimRepository = paylasimRepository;
        this.paylasimKurulusMapper = paylasimKurulusMapper;
    }

    @GetMapping
    public Stream<PaylasimKurulusDto> paylasimlariGetir(){
        return paylasimRepository.findAllBy()
                .stream()
                .map(paylasimKurulusMapper::toDto);
    }
//    @GetMapping
//    public Stream<PaylasimDto> tumPaylasimAlanlariniGetir(){
//        return paylasimRepository.findAllBy()
//                .stream()
//                .map(paylasimMapper::toDto);
//    }


//    @PostMapping
//    public void paylasimEkle(@RequestBody PaylasimDto paylasimDto){
//        paylasimRepository.save(paylasimMapper.toEntity(paylasimDto));
//    }
 }
