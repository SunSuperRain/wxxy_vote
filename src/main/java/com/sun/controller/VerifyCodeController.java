package com.sun.controller;

import com.sun.utils.GifCaptcha;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/verifycode")
public class VerifyCodeController {

    public static final String SESSION_KEY = "GIF_CODE";

    @GetMapping(value = "/get")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/gif");

        GifCaptcha gifCaptcha = new GifCaptcha(120, 40, 4);
        HttpSession session = request.getSession();
        gifCaptcha.out(response.getOutputStream());
        session.removeAttribute(SESSION_KEY);
        session.setAttribute(SESSION_KEY,gifCaptcha.text());
    }

}
