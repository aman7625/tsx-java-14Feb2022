package com.example.demo;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * This class contains a function that retrieves all the commits in the dummy-github-events repository
 */
@Service
public class GitApiRetriever {
    private final OkHttpClient httpClient = new OkHttpClient();
    private static final Logger logger = LoggerFactory.getLogger(GitApiRetriever.class);

    public void retrieveCommitList() throws IOException {
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/aman7625/dummy-github-events/commits").get().build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Error in retrieving commits: " + response);
            }

            String commits = response.body().string();
            logger.info("Retrieved commits: " + commits);
        }
    }
}