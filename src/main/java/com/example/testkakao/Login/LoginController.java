package com.example.testkakao.Login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


// REST API 키 : c6a9f5dbf692782ac8d66a6a51953953
// Redirect URI : http://localhost:8080/kakao/login
// 테스트용 고정주소값 https://kauth.kakao.com/oauth/authorize?client_id=c6a9f5dbf692782ac8d66a6a51953953&redirect_uri=http://localhost:8080/kakao/login&response_type=code
@RestController
@RequestMapping("/kakao")
@Slf4j
public class LoginController {

    private final LoginService service;

    @Autowired
    public LoginController(LoginService service){
        this.service = service;
    }


    //callback
    @ResponseBody
    @GetMapping("/login")
    public void kakaoCallback(@RequestParam String code) {
        log.info("code 추출값 : {}", code);
        log.info("로그인용 인가코드 정상 추출");

        service.getKakaoAccessToken(code);
    }



}
