package pl.sda.allegro.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

public class GitHubService {

    Repository repository;
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
        LocalDateTime date_of_update = null;
        String nameOfRepository = null;

        for (Repository e : repositoryList) {
            if (date_of_update == null || e.getPushed_at().isAfter(date_of_update)) {
                date_of_update = e.getPushed_at();
                nameOfRepository = e.getName();
            }
        }

        System.out.println(nameOfRepository);
    }

}
