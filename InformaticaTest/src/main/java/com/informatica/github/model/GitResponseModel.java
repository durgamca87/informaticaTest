package com.informatica.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GitResponseModel {

    @JsonProperty("id")
    private String projectId;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("")
    private OwnerDetails owner;
}
