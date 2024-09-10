package kr.smhrd.controller;

import kr.smhrd.entity.Customer;
import kr.smhrd.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("/login")
    public String login(Customer customer, HttpSession session) {
        Customer cus = customerService.login(customer);
        if(cus!=null){
            // 인증성공 - 권한처리(XC)
            // httpSession
            session.setAttribute("cus", cus);
        }

        return "redirect:/bookList";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에서 "cus" 속성을 제거
        session.removeAttribute("cus");
        // 세션을 무효화
        session.invalidate();
        // 로그인 페이지로 리다이렉트
        return "redirect:/bookList";
    }

}
