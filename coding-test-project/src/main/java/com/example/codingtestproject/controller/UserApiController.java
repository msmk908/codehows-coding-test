package com.example.codingtestproject.controller;

import com.example.codingtestproject.domain.User;
import com.example.codingtestproject.dto.AddUserRequest;
import com.example.codingtestproject.dto.UserInfoResponse;
import com.example.codingtestproject.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        userService.save(request); // 회원 가입 메서드 호출
        return "redirect:/login"; // 회원 가입이 완료된 이후 로그인 페이지로 이동
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    @GetMapping("/getUserInfo")
    @ResponseBody
    public UserInfoResponse getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 인증된 사용자의 정보를 가져옵니다.
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // 여기서 UserDetails를 이용하여 필요한 정보를 추출합니다.
            String usereamil = userDetails.getUsername();
            // 나머지 정보를 가져오는 코드를 작성합니다.
            User user = userService.findByEmail(usereamil);

            String username = user.getName();
            String userPhonenum = user.getPhonenum();

            // 임시로 사용자 이름과 전화번호, 이메일을 반환하도록 가정합니다.
            UserInfoResponse userInfo = new UserInfoResponse();
            userInfo.setName(username);
            userInfo.setPhonenum(userPhonenum);
            userInfo.setEmail(usereamil);
            return userInfo;
        } else {
            // 사용자가 인증되지 않은 경우 예외 처리를 수행합니다.
            // 예를 들어, 로그인 페이지로 리다이렉트하거나 인증 오류 메시지를 반환할 수 있습니다.
            // 이 경우 null을 반환하거나 예외를 던져도 됩니다.
            return null;
        }
    }

}