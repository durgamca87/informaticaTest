package com.informatica.github.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatica.github.config.GitRepoProperties;
import com.informatica.github.exception.InvalidRepoException;
import com.informatica.github.exception.MissingRepoException;
import com.informatica.github.model.GitRepoModel;
import com.informatica.github.model.GitResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GitRepoService {

    private final GitRepoProperties gitRepoProperties;
    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    public List<GitResponseModel> getRepoByLang(String lang) throws JsonProcessingException {

        ResponseEntity<String> responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(gitRepoProperties.getUrl().concat(lang), String.class);
        } catch (Exception e) {
            throw new InvalidRepoException("Invalid Repository name specified");
        }
        if (responseEntity.getStatusCode().value() == 404) {
            throw new MissingRepoException("input not found");
        } else {
            GitRepoModel responseModel = objectMapper.readValue(responseEntity.getBody(), GitRepoModel.class);
            return responseModel.getItems();
        }
    }
}
