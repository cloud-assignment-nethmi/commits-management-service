package com.commitmanagementservice.commitmanagementservice.service;

import com.commitmanagementservice.commitmanagementservice.dto.CommitDetailsDto;
import com.commitmanagementservice.commitmanagementservice.dto.GitHubCommitDto;
import com.commitmanagementservice.commitmanagementservice.model.GitHubCommit;
import com.commitmanagementservice.commitmanagementservice.repository.GitHubCommitRepository;
import com.commitmanagementservice.commitmanagementservice.service.external.GitHubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GitHubCommitServiceImpl implements GitHubCommitService {

    private final GitHubExternalClient githubExternalClient;
    private final GitHubCommitRepository gitHubCommitRepository;

    @Override
    public List<GitHubCommit> getGitHubCommits() {
        List<GitHubCommit> gitHubCommits = new ArrayList<>();

        List<GitHubCommitDto> gitHubCommitDtoList = this.githubExternalClient.getCommitDetails();
        gitHubCommitDtoList.forEach(gitHubCommitDto -> {
            GitHubCommit gitHubCommit = this.generateGitHubCommitObject(gitHubCommitDto);
            gitHubCommits.add(gitHubCommit);
        });

        this.gitHubCommitRepository.saveAll(gitHubCommits);

        return gitHubCommits;


    }

    @Override
    public List<GitHubCommit> getAllCommits() {
        return this.gitHubCommitRepository.findAll();
    }

    @Override
    public CommitDetailsDto getAllCommitsByAuthorName(String authorName) {
        List<GitHubCommit> gitHubCommits = this.gitHubCommitRepository.findAllByAuthorName(authorName.trim());
        return CommitDetailsDto.builder().commitCount(gitHubCommits.size()).userCommitList(gitHubCommits).build();
    }

    private GitHubCommit generateGitHubCommitObject(GitHubCommitDto gitHubCommitDto) {
        return GitHubCommit.builder()
                .authorName(gitHubCommitDto.getCommitDto().getAuthorDto().getName())
                .commitMessage(gitHubCommitDto.getCommitDto().getMessage())
                .email(gitHubCommitDto.getCommitDto().getAuthorDto().getEmail())
                .date(gitHubCommitDto.getCommitDto().getAuthorDto().getDate())
                .build();
    }

}





