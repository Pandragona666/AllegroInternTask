package pl.sda.allegro.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class GitHubService {

    Repository repository = null;
    private String gitHubUrl;

    public void getLastUpdatedRepository() throws IOException {
        jsonDownloading();
        showLastUpdated();
    }


    public void jsonDownloading() throws IOException {

        URL jsonURL = new URL(gitHubUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        repository = objectMapper.readValue(jsonURL, Repository.class);
    }

    public void showLastUpdated(){

    }

}
