package com.example.Bookingevent.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EventController {
    // public static final Logger logger =
    // LoggerFactory.getLogger(EventController.class);

    @RequestMapping("/apii")
    public String message() {
        // logger.info("INFO Enabled");
        // logger.error("Error Enabled");
        // logger.debug("Debug Enabled");
        return "Test Logging";
    }

}