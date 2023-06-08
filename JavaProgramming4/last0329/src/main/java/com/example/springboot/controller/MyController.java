package com.example.springboot.controller;

import com.example.springboot.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@SessionAttributes("member")
@Controller
public class MyController {

    @ModelAttribute("member")
    public Member setMember(){
        return new Member();
    }

    @GetMapping("/process")
    @ResponseBody
    public Member root(@ModelAttribute("member") Member member) {
        if (member.getMid() == null) {
            member.setId(1L);
            member.setMid("test");
            member.setPass("1234");
            return null;
        }
        return member;
    }

    @GetMapping("/guest")
    String guest(@ModelAttribute("member") Member member, Model model) {
        if (member.getMid() == null) {
            return "redirect:/login";
        }
        model.addAttribute("member", member);
        return "guest/guest";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/")
    @ResponseBody
    public String root() {
        return "시작";
    }
    @GetMapping("/admin")
    String admin() {
        return "admin/admin";
    }

    @GetMapping("/member")
    String member() {
        return "member/member";
    }

    @GetMapping("/loginSuccess")
    public void loginSuccess() { //void이면 요청명.html을 찾음.

    }
    @GetMapping("/accessDenied")
    public void accessDenied() {

    }

    @GetMapping("/aaa/{id}")
    public String aaa(@PathVariable("id") int id) {
        return "aaa";
    }

}
