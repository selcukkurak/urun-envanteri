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
    private String birimId;
    private boolean taslak;
    private ReferansDto periyot;
    private ReferansDto cografiDuzey;
    private boolean uretiliyor;
    private List<UrunHaberBulteniDto> bultenler = new ArrayList<>();
    public List<PaylasimDto> paylasimlar = new ArrayList<>();
    private List<UrunDto> urunler = new ArrayList<>();
    private List<AnketDto> anketler = new ArrayList<>();
    private List<IdariKayitDto> idariKayitlar = new ArrayList<>();
}
