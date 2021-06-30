package tr.gov.tuik.urunenvanteri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.gov.tuik.urunenvanteri.entity.Dosya;
import tr.gov.tuik.urunenvanteri.repository.DosyaRepository;

import java.util.stream.Stream;

@Service
public class DosyaService{

    @Autowired
    private DosyaRepository repository;


    public Dosya getFile(Long id) {
        return repository.findById(id).get();
    }

    public Stream<Dosya> getAllFiles() {
        return repository.findAll().stream();
    }
}
