package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Anket {

    @Id
    private String id;
    private String adi;
    private String csa;

    @Column(name = "birim_id")
    private String birimId;
}
