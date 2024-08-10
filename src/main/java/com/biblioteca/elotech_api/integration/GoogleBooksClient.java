package com.biblioteca.elotech_api.integration;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class GoogleBooksClient {
    private static final String BASE_URL = "https://www.googleapis.com/books/v1/volumes";

    public List<Map<String, Object>> searchBook(String query) {
        String url = BASE_URL + "?q=" + query;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Content-Type", "application/json");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
        Map<String, List<Map<String, Object>>> responseBody = response.getBody();

        if (response.getStatusCode().is2xxSuccessful()) {
            return responseBody.get("items");
        }

        return null;
    }
}
