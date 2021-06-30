package tr.gov.tuik.urunenvanteri.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class UrunDto extends AuditableEntity {
    private Long id;
    @NotNull
    private String kodu;
    @NotNull
    private String adi;
    private String csa;
    private String amac;
    private String kapsam;
    private String fayda;
    private String birimId;
    private Long zamanlilik;
    private boolean taslak;
    private ReferansDto periyot;
    private ReferansDto cografiDuzey;
    private boolean uretiliyor;
    private List<UrunHaberBulteniDto> bultenler = new ArrayList<>();
}
