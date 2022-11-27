package com.informatica.github.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.informatica.github.model.GitRepoModel;
import com.informatica.github.model.GitResponseModel;
import com.informatica.github.service.GitRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GitRepoController {

    private final GitRepoService gitRepoService;

    @GetMapping("/api/repo")
    public List<GitResponseModel> getReposByLanguage(@RequestParam String lang) throws JsonProcessingException {
        return gitRepoService.getRepoByLang(lang);
    }
}
