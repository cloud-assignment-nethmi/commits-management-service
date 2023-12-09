package com.commitmanagementservice.commitmanagementservice.repository;

import com.commitmanagementservice.commitmanagementservice.model.GitHubCommit;
import org.springframework.data.mongodb.repository.MongoRepository;

//this interface connects to mongodb
public interface GitHubCommitRepository extends MongoRepository<GitHubCommit, String> {
}
