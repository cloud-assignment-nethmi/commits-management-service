package com.commitmanagementservice.commitmanagementservice.dto;

import com.commitmanagementservice.commitmanagementservice.model.GitHubCommit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommitDetailsDto {

    private int commitCount;

    private List<GitHubCommit> userCommitList;
}
