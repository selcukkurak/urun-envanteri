package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Anket {

    @Id
    private String id;
    private String adi;
    private String csa;

    @Column(name = "birim_id")
    private String birimId;

    @ManyToOne
    private Referans periyot;

    @ManyToOne
    private Referans cografiDuzey;

    @ManyToOne
    private Referans birimDuzey;

    private Integer orneklemSayisi;
    private String sema;
    private Integer harzemliDurum;
    private Integer ustDurum;


}
