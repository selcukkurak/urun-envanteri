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

    public HaberBulteniResource(WebIcerikClient webIcerikClient, TakvimClient takvimClient) {
        this.webIcerikClient = webIcerikClient;
        this.takvimClient = takvimClient;
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

}
