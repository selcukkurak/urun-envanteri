package tr.gov.tuik.urunenvanteri.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "webicerik", url = "${feign.webicerik.url}")
public interface WebIcerikClient {

    @GetMapping("/webicerik/rapor/haber_bultenleri")
    List<Map<String, Object>> getHaberBultenleri();


    @GetMapping("/webicerik/rapor/haber_bultenleri_metaveri_listesi")
    List<List<Map<String, Object>>> getBultenMetaverileri(@RequestParam("bultenler") List<Long> id);

}
