package tr.gov.tuik.urunenvanteri.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.KategoriDto;
import tr.gov.tuik.urunenvanteri.dto.mapper.KategoriMapper;
import tr.gov.tuik.urunenvanteri.repository.KategoriRepository;

import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kategoriler")
public class KategoriResource {

    private final KategoriRepository kategoriRepository;
    private final KategoriMapper kategoriMapper;

    @GetMapping
    public Stream<KategoriDto> kategoriler(){
        return kategoriRepository.findAllBy()
                .stream()
                .map(kategoriMapper::toDto);
    }
}
