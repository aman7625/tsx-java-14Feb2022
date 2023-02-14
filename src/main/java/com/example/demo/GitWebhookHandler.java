package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class handles the Github webhooks and logs details of any new event triggered in the dummy-github-events repository.
 */
@RestController
@RequestMapping("/webhook")
public class GitWebhookHandler {

    private static final Logger logger = LoggerFactory.getLogger(GitWebhookHandler.class);

    @PostMapping
    public ResponseEntity<String> webhookHandler(@RequestHeader("x-github-event") String event,
                                                 @RequestBody String requestBody) {
        try {
            if(event.equals("push")) {
                logger.info("Push Event Triggered: " + requestBody);
            }
            else if(event.equals("pull_request")) {
                logger.info("Pull Request Event Triggered: " + requestBody);
            }
            else if(event.equals("merge")) {
                logger.info("Merge Event Triggered: " + requestBody);
            }
            else {
                logger.info("Unknown Event Triggered: " + requestBody);
            }
            return new ResponseEntity<>("Webhook Event handled successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error handling Webhook Event", e);
            return new ResponseEntity<>("Error handling Webhook Event", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
