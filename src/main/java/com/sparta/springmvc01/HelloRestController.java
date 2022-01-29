package com.sparta.springmvc01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hello/rest")
public class HelloRestController {

    @GetMapping("/json/string")
    //@ResponseBody가 자동으로 추가된다. 모두다.
    public String helloHtmlString() {
        return "<html><body>Hello @ResponseBody</body></html>";
        //컨트롤러엿으면 에러났음.
    }
    @GetMapping("/json/list")
    public List<String> helloJson() {
        List<String> words = Arrays.asList("Hello", "Controller", "And", "JSON");

        return words;
    }
}