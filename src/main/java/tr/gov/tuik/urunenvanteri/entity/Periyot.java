package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Periyot {

    @Id
    private Integer id;
    private String adi;
}
