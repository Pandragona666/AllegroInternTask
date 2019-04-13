package pl.allegro.internship;

import pl.allegro.internship.service.GitHubService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GitHubService gitHubService = new GitHubService("https://api.github.com/users/allegro/repos");

        gitHubService.getLastUpdatedRepository();

    }
}
