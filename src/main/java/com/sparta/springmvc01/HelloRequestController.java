package com.sparta.springmvc01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class HelloRequestController {
    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // [Request sample]
// GET http://localhost:8080/hello/request/star/BTS/age/28
//    @PathVariable 의 역할 : url에 들어가있는 정보를 (name,age) 뺴옴
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// GET http://localhost:8080/hello/request/form/param?name=BTS&age=28
//    @RequestParam 은 생략가능하지만 명시적으로 표시하는게 학습에 도움됨.
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// POST http://localhost:8080/hello/request/form/param
// Header
// Content type: application/x-www-form-urlencoded 폼형태.
// Body
// name=BTS&age=28
//  get요청의 경우 url요청안에 내용이 들어감 (age,name)
//  post요청의 경우 url에 있는 것을 감추기위해서 정보가 body에 들어감!
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// POST http://localhost:8080/hello/request/form/model
// Header
// Content type: application/x-www-form-urlencoded
// Body
// name=BTS&age=28
//   @ModelAttribute도 생략가능.  컨트롤 클릭하면 해당위치로 이동. - star클래스로 이동 -name ,age를 갖고있음.
//    여러개를 @RequestParam할경우 코드가 복잡하니까 star라는 객체를 만들어 객체를 받도록함. -setter가 필요함.
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }

    // [Request sample]
// POST http://localhost:8080/hello/request/form/json
// Header
// Content type: application/json
// Body
// {"name":"BTS","age":"28"}
//  페이지 이동없이 데이터만 왔다갔다함. - 제이슨형태를 받는방법 ResponseBody로 받는다.
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }
}