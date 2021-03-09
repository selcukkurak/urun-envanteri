package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

@Data
public class AnketDto {
    private String id;
    private String adi;
    private String csa;
    private String birimId;
    private ReferansDto periyot;
    private ReferansDto cografiDuzey;
    private ReferansDto birimDuzey;
    private Integer orneklemSayisi;
    private String sema;
    private Integer harzemliDurum;
    private Integer ustDurum;
    private Integer anketorSayisiMerkez;
    private Integer anketorSayisiBolge;
    private Integer kontrolorSayisiMerkez;
    private Integer kontrolorSayisiBolge;
}
