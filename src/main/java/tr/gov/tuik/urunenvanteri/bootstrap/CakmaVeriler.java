package tr.gov.tuik.urunenvanteri.bootstrap;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import tr.gov.tuik.urunenvanteri.entity.Urun;
import tr.gov.tuik.urunenvanteri.repository.UrunRepository;

@Configuration
public class CakmaVeriler implements ApplicationRunner {
    private final UrunRepository urunRepository;

    public CakmaVeriler(UrunRepository urunRepository) {
        this.urunRepository = urunRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
