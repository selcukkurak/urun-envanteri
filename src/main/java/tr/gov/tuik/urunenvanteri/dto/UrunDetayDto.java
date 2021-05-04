package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.*;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class UrunDetayDto extends AuditableEntity {
    private Long id;
    private String kodu;
    private String adi;
    private String csa;
    private String amac;
    private String kapsam;
    private String fayda;
    private String birimId;
    private Long zamanlilik;
    private boolean taslak;
    private ReferansDto periyot;
    private ReferansDto cografiDuzey;
    private boolean uretiliyor;
    private List<HaberBulteniDto> bultenler = new ArrayList<>();
    private List<IdariKayitDto> idariKayitlar = new ArrayList<>();
    private List<AnketDto> anketler = new ArrayList<>();
    private List<UrunDto>  urunler = new ArrayList<>();
    private List<PaylasimDto> paylasimlar = new ArrayList<>();
    private List<MetaveriKonuDto> metaveriler = new ArrayList<>();
}
