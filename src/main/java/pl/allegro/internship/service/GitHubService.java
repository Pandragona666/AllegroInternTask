package pl.allegro.internship.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import pl.allegro.internship.model.Repository;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

public class GitHubService {

    private String gitHubUrl;
    private List<Repository> repositoryList;

    public GitHubService(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public void getLastUpdatedRepository() throws IOException {
        jsonDownloading();
        showLastUpdated();
    }


    public void jsonDownloading() throws IOException {

        URL jsonURL = new URL(gitHubUrl);
        //json ignore unknown properties
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //adding to object mapper possibility to use time modules
        objectMapper.registerModule(new JavaTimeModule());

        repositoryList = objectMapper.readValue(jsonURL, new TypeReference<List<Repository>>() {
        });
    }


    public void showLastUpdated() {
        LocalDateTime dateOfUpdate = null;
        String nameOfRepository = null;

        for (Repository e : repositoryList) {
            if (dateOfUpdate == null || e.getPushed_at().isAfter(dateOfUpdate)) {
                dateOfUpdate = e.getPushed_at();
                nameOfRepository = e.getName();
            }
        }

        System.out.println(nameOfRepository);
    }

}
