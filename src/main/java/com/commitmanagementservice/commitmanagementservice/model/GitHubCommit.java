package com.commitmanagementservice.commitmanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//mongodb saves classes as documents -- creates in this manner
@Document(collection = "github_commits")
public class GitHubCommit {

    @Id
    private String id;

    private String sha;

    private String nodeId;

    private String url;

}
