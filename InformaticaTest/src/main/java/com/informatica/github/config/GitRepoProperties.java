package com.informatica.github.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "git.repo")
@Configuration
@Getter
@Setter
public class GitRepoProperties {

    private String url;

}
