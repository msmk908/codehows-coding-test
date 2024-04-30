package com.example.codingtestproject.service;

import com.example.codingtestproject.domain.Portfolio;
import com.example.codingtestproject.dto.AddPortfolioRequest;
import com.example.codingtestproject.dto.UpdatePortfolioRequest;
import com.example.codingtestproject.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    // 포트폴리오 글 추가 메서드
    public void save(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }

    // 저장되어 있는 글을 모두 가져오는 메서드
    public List<Portfolio> findAll(){
        return portfolioRepository.findAll();
    }

    // 포트폴리오 작성 글 하나를 조회하는 메서드
    public Portfolio findById(long id){
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 포트폴리오 삭제 메서드
    public void delete(long id){
        portfolioRepository.deleteById(id);
    }

    // 트랜잭션 메서드
    @Transactional
    public Portfolio update(long id, UpdatePortfolioRequest request){
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        portfolio.update(request.getTitle(), request.getName(), request.getProfileimage(),
                request.getPhonenum(), request.getEmail(), request.getOnelinecontent(),
                request.getStack(), request.getContent());

        return portfolio;
    }

}
