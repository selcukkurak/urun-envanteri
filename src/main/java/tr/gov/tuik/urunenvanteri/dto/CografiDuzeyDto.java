package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class CografiDuzeyDto {
    private Integer id;
    private String adi;
}
