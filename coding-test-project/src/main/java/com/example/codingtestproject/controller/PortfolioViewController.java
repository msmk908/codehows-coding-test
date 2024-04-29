package com.example.codingtestproject.controller;

import com.example.codingtestproject.domain.Portfolio;
import com.example.codingtestproject.dto.AddPortfolioRequest;
import com.example.codingtestproject.dto.PortfolioListViewResponse;
import com.example.codingtestproject.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/newPortfolio")
    public String newPortfolio(AddPortfolioRequest addPortfolioRequest) {
        // 사용자가 작성한 포트폴리오 정보를 담은 AddPortfolioRequest 객체를 받음
        // 서비스를 통해 포트폴리오를 저장하고 결과를 반환받음
        portfolioService.save(addPortfolioRequest);

        // 포트폴리오 추가 후 어떤 페이지로 이동할지 결정
        return "redirect:/portfolioList";
    }

}
