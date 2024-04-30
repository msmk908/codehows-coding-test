package com.example.codingtestproject.controller;

import com.example.codingtestproject.domain.Board;
import com.example.codingtestproject.domain.Portfolio;
import com.example.codingtestproject.dto.AddPortfolioRequest;
import com.example.codingtestproject.dto.PortfolioListViewResponse;
import com.example.codingtestproject.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PortfolioViewController {

    private final PortfolioService portfolioService;

    @GetMapping("/main")
    public String getPortfolios(Model model){
        List<PortfolioListViewResponse> portfolios = portfolioService.findAll().stream()
                .map(PortfolioListViewResponse::new)
                .toList();
        model.addAttribute("portfolios", portfolios); // 포트폴리오 글 리스트 저장

        return "main";
    }

    @GetMapping("/portfolios")
    public String showPortfolios(Model model) {
        List<Portfolio> portfolios = portfolioService.findAll();
        model.addAttribute("portfolios", portfolios);
        return "portfolios";
    }

    @GetMapping("/portfolioList")
    public String portfolioList(){
        return "portfolioList";
    }

    @GetMapping("/newPortfolio")
    public String newPortfolio(){
        return "newPortfolio";
    }

    @PostMapping("/savePortfolio")
    public ResponseEntity<Portfolio> savePortfolio(@RequestBody AddPortfolioRequest addPortfolioRequest) {
        System.out.println(addPortfolioRequest.getTitle());
        String title = addPortfolioRequest.getTitle();
        String name = addPortfolioRequest.getName();
        String profileimage = addPortfolioRequest.getProfileimage();
        String phonenum = addPortfolioRequest.getPhonenum();
        String email = addPortfolioRequest.getEmail();
        String onelinecontent = addPortfolioRequest.getOnelinecontent();
        String stack = addPortfolioRequest.getStack();
        String content = addPortfolioRequest.getContent();

        // 현재 시간을 가져오기
        LocalDateTime now = LocalDateTime.now();

        Portfolio portfolio = new Portfolio();
        portfolio.setTitle(title);
        portfolio.setName(name);
        portfolio.setProfileimage(profileimage);
        portfolio.setPhonenum(phonenum);
        portfolio.setEmail(email);
        portfolio.setOnelinecontent(onelinecontent);
        portfolio.setStack(stack);
        portfolio.setContent(content);
        portfolio.setCreatetime(now);

        portfolioService.save(portfolio);

        return new ResponseEntity<>(portfolio, HttpStatus.CREATED);
    }



}
