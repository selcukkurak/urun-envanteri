package tr.gov.tuik.urunenvanteri.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "webicerik", url = "${feign.webicerik.url}")
public interface WebIcerikClient {

    @GetMapping("/webicerik/rapor/haber_bultenleri")
    List<Map<String, Object>> getHaberBultenleri();
}
