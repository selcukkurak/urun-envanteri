package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.client.WebIcerikClient;
import tr.gov.tuik.urunenvanteri.dto.Bulten;
import tr.gov.tuik.urunenvanteri.dto.Sayilar;
import tr.gov.tuik.urunenvanteri.dto.mapper.BultenMapper;
import tr.gov.tuik.urunenvanteri.repository.AnketRepository;
import tr.gov.tuik.urunenvanteri.repository.IdariKayitRepository;
import tr.gov.tuik.urunenvanteri.repository.ReferansRepository;
import tr.gov.tuik.urunenvanteri.repository.UrunRepository;

@RestController
@RequestMapping("api/sayilar")
public class SayiResource {
    private final UrunRepository urunRepository;
    private final AnketRepository anketRepository;
    private final IdariKayitRepository idariKayitRepository;
    private final ReferansRepository referansRepository;
    private final WebIcerikClient webIcerikClient;

    public SayiResource(UrunRepository urunRepository, AnketRepository anketRepository, IdariKayitRepository idariKayitRepository, ReferansRepository referansRepository, WebIcerikClient webIcerikClient) {
        this.urunRepository = urunRepository;
        this.anketRepository = anketRepository;
        this.idariKayitRepository = idariKayitRepository;
        this.referansRepository = referansRepository;
        this.webIcerikClient = webIcerikClient;
    }

    @GetMapping
    private Sayilar sayilariGetir(){
        return new Sayilar(
                urunRepository.urunSayisi(),
                anketRepository.anketSayisi(),
                idariKayitRepository.kayitSayisi(),
                webIcerikClient.getHaberBultenleri()
                        .stream()
                        .map(BultenMapper::toDto).map(item -> item.getId()).distinct().count(),
                referansRepository.kurumSayisi(),
                referansRepository.kurulusSayisi()
        );
    }
}
