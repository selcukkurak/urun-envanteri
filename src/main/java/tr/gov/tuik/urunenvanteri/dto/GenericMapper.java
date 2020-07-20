package tr.gov.tuik.urunenvanteri.dto;

public interface GenericMapper<IN, OUT> {

    OUT toDto(IN entity);
    IN toEntity(OUT dto);
}
