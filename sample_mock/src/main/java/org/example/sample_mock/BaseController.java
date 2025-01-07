package org.example.sample_mock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class BaseController {

    public static String temp_answer = "Say hello to my little friend!";

    public int randomRangeThreadLocalRandom(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String answer() {
        String answer = temp_answer + randomRangeThreadLocalRandom(10, 15);
        String current_time = java.time.LocalDateTime.now().toString().substring(0,23);
        System.out.printf("[INFO][%s] Returned: %s\n",current_time,answer);
        return answer;
    }

}
