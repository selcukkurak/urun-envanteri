package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class AnketDto extends AuditableEntity {
    private String id;
    private String adi;
    private String csa;
    private String birimId;
    private Boolean taslak;
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
