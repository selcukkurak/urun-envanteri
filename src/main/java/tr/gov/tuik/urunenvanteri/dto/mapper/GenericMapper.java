package tr.gov.tuik.urunenvanteri.dto.mapper;

import java.util.List;

public interface GenericMapper<IN, OUT> {

    OUT toDto(IN entity);
    IN toEntity(OUT dto);
    List<OUT> toDtoList(List<IN> entities);
    List<IN> toEntityList(List<OUT> dtos);
}
