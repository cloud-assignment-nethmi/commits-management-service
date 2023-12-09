package com.commitmanagementservice.commitmanagementservice.service;

import com.commitmanagementservice.commitmanagementservice.model.GitHubCommit;

import java.util.List;

public interface GitHubCommitService {
    List<GitHubCommit> getGitHubCommits();

    List<GitHubCommit> getAllCommits();
}

