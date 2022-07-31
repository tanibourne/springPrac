package com.tanibourne.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/response")// 공통된 URL은 RequestMapping으로 빼준다. /hello/response/~~~~~~
public class HelloResponseController {
    // [Response header]
    //   Location: http://localhost:8080/hello.html
    @GetMapping("/html/redirect")
    public String htmlFile() {
        return "redirect:/hello.html";
    }

    // [Response header]
    //   Content-Type: text/html
    // [Response body]
    // * resources/templates/hello.html 의 text 내용
    //   <!DOCTYPE html>
    //   <html>
    //     <head><meta charset="UTF-8"><title>By Templates engine</title></head>
    //      <body>Hello, Spring 정적 웹 페이지!!</body>
    //   </html>
    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "hello"; //String을 리턴한다는 것은 VIEW를 전달해준 것 view name으로 전달이 된것이다. Template engine에게 View를 전달한것
    }

    // [Response header]
    //   Content-Type: text/html
    // [Response body]
    //   <!DOCTYPE html>
    //   <html>
    //     <head><meta charset="UTF-8"><title>By @ResponseBody</title></head>
    //      <body>Hello, Spring 정적 웹 페이지!!</body>
    //   </html>
    @GetMapping("/body/html")
    @ResponseBody // 아래에서 return한 String을 Body로 채워 바로 위 htmlTemplates()와 완전 동일하게 동작. htmlTemplates()에서도 파일이 전달되는것이 아니라
    //파일 안에 있는 Text 내용이  body로 넣어져서 동작한다. 그런데 코드의 가독성때문에 htmlTemplates()이 방법을 쓰는것이 좋다.
    // @ResponseBody를 해주면 View를 통과하지 않는다. Template engine으로 넘기는 것이 아니라 이 String을 body에 넣어준다.


    public String helloStringHTML() {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head><meta charset=\"UTF-8\"><title>By @ResponseBody</title></head>" +
                "<body> Hello, 정적 웹 페이지!!</body>" +
                "</html>";
    }

    // [Response header]
    //   Content-Type: text/html
    // [Response body]
    // * resources/templates/hello-visit.html 의 text 내용
    @GetMapping("/html/dynamic")
    public String helloHtmlFile(Model model) {
        visitCount++;
        model.addAttribute("visits", visitCount);
        // resources/templates/hello-visit.html
        return "hello-visit";
    }

    private static long visitCount = 0;

    // [Response header]
    //   Content-Type: text/html
    // [Response body]
    //   {"name":"BTS","age":28}
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"BTS\",\"age\":28}";
    }

    // [Response header]
    //   Content-Type: application/json
    // [Response body]
    //   {"name":"BTS","age":28}
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloJson() {
        return new Star("BTS", 28);
    }
}