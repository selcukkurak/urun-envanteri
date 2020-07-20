package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
public class Arac {

    @Id
    private Integer id;
    private String adi;
}
