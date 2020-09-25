package com.usm.taskmanagement.integration.configuration;

import com.usm.taskmanagement.integration.client.UserManagerClient;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
@PropertySource("classpath:user-manager.properties")
public class UserManagerConfiguration {

    private final String baseUrl;

    public UserManagerConfiguration(final @Value("${user-manager.base.url}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Bean
    public Retrofit userRetrofit(
            @Qualifier("dwHttpClient") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Bean
    public OkHttpClient dwHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Bean
    @Qualifier("userManagerClient")
    public UserManagerClient userManagerClient(@Qualifier("userRetrofit") Retrofit retrofit) {
        return retrofit.create(UserManagerClient.class);
    }
}
