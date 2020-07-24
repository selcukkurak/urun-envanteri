package tr.gov.tuik.urunenvanteri.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tr.gov.tuik.urunenvanteri.dto.Birim;

import java.util.List;

@FeignClient(name = "ikClient", url = "${feign.ik.url}", configuration = IkClientConfig.class)
public interface IkClient {

    @GetMapping(value = "/api/birimler/detay")
    List<Birim> birimler(@RequestParam boolean merkez);
}
