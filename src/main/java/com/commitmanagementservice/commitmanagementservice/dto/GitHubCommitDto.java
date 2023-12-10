package com.commitmanagementservice.commitmanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GitHubCommitDto {

    @JsonProperty("commit")
    private CommitDto commitDto;


}
