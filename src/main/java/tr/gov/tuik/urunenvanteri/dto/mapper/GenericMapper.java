package tr.gov.tuik.urunenvanteri.dto.mapper;

public interface GenericMapper<IN, OUT> {

    OUT toDto(IN entity);
    IN toEntity(OUT dto);
}
