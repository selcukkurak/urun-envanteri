package tr.gov.tuik.urunenvanteri.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;
import tr.gov.tuik.urunenvanteri.entity.Dosya;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class IdariKayitDto extends AuditableEntity {
    @Id
    private Long id;
    @NotNull
    private String adi;
    @NotNull
    private String kodu;
    private String icerik;
    private String kaynakKurumDtvt;
    private String kaynakBirimDtvt;
    private Integer kaynakKurumId;
    private String kaynakKurumAdi;
    private String kaynakBirimAdi;
    private Boolean taslak;
    private Boolean silindi;
    private String birimId;
    private String transferdenSorumluBirimId;
    private String epostaGruplari;
    private String csa;
    private String sema;
    private String veritabani;
    private Long protokolDosyaId;
    private String protokol;
    private Long yasalHukumDosyaId;
    private String tercihNedeni;
    private String alternatifKaynak;
    private String kisitlar;
    private ReferansDto cografiDuzey;
    private ReferansDto kullanimAmaci;
    private String kullanimAmacDigerAciklama;
    private ReferansDto veriDuzeyi;
    private ReferansDto bicim;
    private String bicimDigerAciklama;
    private ReferansDto aktarimBicimi;
    private String aktarimBicimDigerAciklama;
    private ReferansDto transferPeriyot;
    private String transferPeriyotAciklama;
    private String yasalHukum;
    private String teslimatSartlari;
    private ReferansDto verininTutulduguYer;
    private String verininTutulduguYerDigerAciklama;
    private ReferansDto talepBicimi;
    private String talepBicimiDigerAciklama;
    private ReferansDto birimDuzeyi;
    private String birimDuzeyiDigerAciklama;
    private List<IletisimKisiDto> iletisimKisileri = new ArrayList<>();
    private List<TabloBilgileriDto> tablolar = new ArrayList<>();
}
