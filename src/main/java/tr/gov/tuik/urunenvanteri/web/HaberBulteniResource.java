package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.client.WebIcerikClient;
import tr.gov.tuik.urunenvanteri.dto.Bulten;
import tr.gov.tuik.urunenvanteri.dto.mapper.BultenMapper;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/bultenler")
public class HaberBulteniResource {
    private final WebIcerikClient webIcerikClient;

    public HaberBulteniResource(WebIcerikClient webIcerikClient) {
        this.webIcerikClient = webIcerikClient;
    }

    @GetMapping
    public Stream<Bulten> bultenler() {
        return webIcerikClient.getHaberBultenleri()
                .stream()
                .map(BultenMapper::toDto);
    }
}
