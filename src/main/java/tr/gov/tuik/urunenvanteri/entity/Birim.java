package tr.gov.tuik.urunenvanteri.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Birim {
    @Id
    private long id;

    private String adi;

    private int tc;

    private String birimi;
}
