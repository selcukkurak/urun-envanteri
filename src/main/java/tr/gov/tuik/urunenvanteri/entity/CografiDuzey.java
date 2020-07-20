package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cografi_duzey")
public class CografiDuzey {

    @Id
    private Integer id;
    private String adi;
}
