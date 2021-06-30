package tr.gov.tuik.urunenvanteri.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tr.gov.tuik.urunenvanteri.entity.Dosya;
import tr.gov.tuik.urunenvanteri.repository.DosyaRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("api/dosyalar")
public class DosyaResource {

    private final DosyaRepository repository;
    private String uploadFolderPath = "/Users/17446811978";

    public DosyaResource(DosyaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void dosyaEkle(@RequestParam("file") MultipartFile file) {
        try {
            byte[] data = file.getBytes();
            Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
            Files.write(path, data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/db")
    public Dosya dosyaVeritabaninaAktar(@RequestParam("file") MultipartFile file){
        Dosya dosya = new Dosya();

        try{
            dosya.setSize(file.getBytes());
            dosya.setTipi(file.getContentType());
            dosya.setAdi(file.getOriginalFilename());
            repository.save(dosya);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return dosya;
    }

}
