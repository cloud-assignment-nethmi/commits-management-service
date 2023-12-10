package com.commitmanagementservice.commitmanagementservice.repository;

import com.commitmanagementservice.commitmanagementservice.model.GitHubCommit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//this interface connects to mongodb
@Repository
public interface GitHubCommitRepository extends MongoRepository<GitHubCommit, String> {

    List<GitHubCommit> findAllByAuthorName(String authorName);
}
