package com.commitmanagementservice.commitmanagementservice.controller;

import com.commitmanagementservice.commitmanagementservice.dto.CommitDetailsDto;
import com.commitmanagementservice.commitmanagementservice.model.GitHubCommit;
import com.commitmanagementservice.commitmanagementservice.service.GitHubCommitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")
public class CommitController {

    //GitHubCommitService interface in service package
    private GitHubCommitService gitHubCommitService;

    @GetMapping("/commits")
    public ResponseEntity<List<GitHubCommit>> getGitHubCommits() {
        return ResponseEntity.ok(this.gitHubCommitService.getGitHubCommits());
    }

    @GetMapping("/commits/get-all")
    public ResponseEntity<List<GitHubCommit>> getAllCommits() {
        return ResponseEntity.ok(this.gitHubCommitService.getAllCommits());
    }

    @GetMapping("/commits/by-author-name")
    public ResponseEntity<CommitDetailsDto> getAllCommitsByAuthorName(@RequestParam() String authorName) {
        return ResponseEntity.ok(this.gitHubCommitService.getAllCommitsByAuthorName(authorName));
    }
}

