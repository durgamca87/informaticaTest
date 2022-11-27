package com.informatica.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OwnerDetails {

    private String url;
    @JsonProperty("login")
    private String ownerLogin;
    @JsonProperty("html_url")
    private String htmlUrl;
}
