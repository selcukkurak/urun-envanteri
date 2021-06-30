package tr.gov.tuik.urunenvanteri.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tr.gov.tuik.urunenvanteri.entity.Dosya;
import tr.gov.tuik.urunenvanteri.service.DosyaService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class DosyaExportResource {

    @Autowired
    private DosyaService service;

    @GetMapping("/files")
    public ResponseEntity<List<Dosya>> getListFiles() {
        List<Dosya> files = service.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(String.valueOf(dbFile.getId()))
                    .toUriString();

            return new Dosya(
                    dbFile.getId(),
                    dbFile.getAdi(),
                    fileDownloadUri,
                    dbFile.getTipi(),
                    dbFile.getSize());
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<Dosya> getFile(@PathVariable Long id) {
        Dosya dosya = service.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dosya.getAdi() + "\"")
                .body(dosya);
    }

}
