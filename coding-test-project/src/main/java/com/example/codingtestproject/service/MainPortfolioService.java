package com.example.codingtestproject.service;

import com.example.codingtestproject.domain.Portfolio;
import com.example.codingtestproject.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MainPortfolioService {

    private final PortfolioRepository portfolioRepository;

    // 메인 포트폴리오 선택 메서드
    public Portfolio selectMainPortfolio(Long portfolioId) {
        // 이전 메인 포트폴리오 해제
        List<Portfolio> currentMainPortfolios = portfolioRepository.findByMainTrue();
        for (Portfolio portfolio : currentMainPortfolios) {
            portfolio.setMain(false);
        }
        // 새로운 메인 포트폴리오 선택
        Portfolio newMainPortfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new IllegalArgumentException("포트폴리오를 찾을 수 없습니다: " + portfolioId));
        newMainPortfolio.setMain(true);
        return portfolioRepository.save(newMainPortfolio);
    }
}
