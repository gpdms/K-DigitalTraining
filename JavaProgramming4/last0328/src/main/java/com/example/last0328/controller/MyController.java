package com.example.last0328.controller;

import com.example.last0328.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

//@SessionAttributes("member")는 member라는 이름을 가진 모델(Model) 속성을 세션에 저장하겠다는 의미
// 이렇게 저장된 데이터는 해당 컨트롤러(Controller)에서만 사용할 수 있음.
@SessionAttributes("member") //초기 설정. member를 세션으로 쓰겠다
@Controller
public class MyController {

    @ModelAttribute("member") //선언. 객체생성. 없으면 null나옴.
    public Member setMember(){
        return new Member();
    }

    @GetMapping("/process")
    @ResponseBody
    public Member root(@ModelAttribute("member") Member member) { //사용. 세션정보를 가져오겠다.
        if (member.getMid() == null) { //객체 생성만 하고 값이 없음. 당연함.
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
    public String root(){
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

}
