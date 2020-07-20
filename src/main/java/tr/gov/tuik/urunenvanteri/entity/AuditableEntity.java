package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@Audited
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity {

    @CreatedBy
    private Long ekleyen;

    @LastModifiedBy
    private Long guncelleyen;

    @CreatedDate
    @Column(name = "ekleme_tarihi")
    private LocalDateTime eklemeTarihi;

    @LastModifiedDate
    @Column(name = "guncelleme_tarihi")
    private LocalDateTime guncellemeTarihi;
}
