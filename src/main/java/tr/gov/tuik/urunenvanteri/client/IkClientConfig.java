package tr.gov.tuik.urunenvanteri.client;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class IkClientConfig {
    private final String client;
    private final String key;

    public IkClientConfig(@Value("${api.client}") String client, @Value("${api.ik.key}") String key) {
        this.client = client;
        this.key = key;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-TUIK-API-CLIENT", client);
            requestTemplate.header("X-TUIK-API-KEY", key);
        };
    }
}
