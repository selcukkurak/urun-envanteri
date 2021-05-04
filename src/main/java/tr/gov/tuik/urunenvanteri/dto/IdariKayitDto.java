package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;
import tr.gov.tuik.urunenvanteri.entity.Dosya;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class IdariKayitDto extends AuditableEntity {
    private String id;
    private String adi;
    private String icerik;
    private String kaynakKurumDtvt;
    private String kaynakBirimDtvt;
    private Integer kaynakKurumId;
    private String kaynakKurumAdi;
    private String kaynakBirimAdi;
    private Boolean taslak;
    private String birimId;
    private String transferdenSorumluBirimId;
    private String epostaGruplari;
    private String csa;
    private String sema;
    private String veritabani;
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
    private List<DosyaDto> dosyalar = new ArrayList<>();
}
