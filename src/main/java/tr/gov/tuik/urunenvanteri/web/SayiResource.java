package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tuik.urunenvanteri.dto.Sayilar;
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

    public SayiResource(UrunRepository urunRepository, AnketRepository anketRepository, IdariKayitRepository idariKayitRepository, ReferansRepository referansRepository) {
        this.urunRepository = urunRepository;
        this.anketRepository = anketRepository;
        this.idariKayitRepository = idariKayitRepository;
        this.referansRepository = referansRepository;
    }

    @GetMapping
    private Sayilar sayilariGetir(){
        return new Sayilar(
                anketRepository.anketSayisi(),
                idariKayitRepository.kayitSayisi(),
                referansRepository.kurumSayisi(),
                referansRepository.kurulusSayisi()
        );
    }
}
