package pl.sda.allegro;

import pl.sda.allegro.model.GitHubService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GitHubService gitHubService = new GitHubService("https://api.github.com/users/allegro/repos");

        gitHubService.getLastUpdatedRepository();

    }
}
