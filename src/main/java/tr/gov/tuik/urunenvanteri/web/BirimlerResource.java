package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.client.IkClient;
import tr.gov.tuik.urunenvanteri.dto.Birim;

import java.util.List;

@RestController
@RequestMapping("/api/birimler")
public class BirimlerResource {
    private final IkClient ikClient;

    public BirimlerResource(IkClient ikClient) {
        this.ikClient = ikClient;
    }

    @GetMapping
    public List<Birim> merkezBirimler() {
        return ikClient.birimler(true);
    }
}
