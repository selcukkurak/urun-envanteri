FROM adoptopenjdk:11-jre-hotspot
VOLUME /tmp
EXPOSE 8080

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-cp", "app:app/lib/*", "tr.gov.tuik.urunenvanteri.TuikUrunEnvanteriApplication"]
