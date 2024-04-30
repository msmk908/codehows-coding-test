package com.example.codingtestproject.controller;

import com.example.codingtestproject.domain.Portfolio;
import com.example.codingtestproject.dto.AddPortfolioRequest;
import com.example.codingtestproject.dto.PortfolioListViewResponse;
import com.example.codingtestproject.dto.UpdatePortfolioRequest;
import com.example.codingtestproject.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class PortfolioApiController {

    private final PortfolioService portfolioService;

    @GetMapping("/api/portfolios")
    public ResponseEntity<List<PortfolioListViewResponse>> findAllPortfolio(){
        List<PortfolioListViewResponse> portfolios = portfolioService.findAll()
                .stream()
                .map(PortfolioListViewResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(portfolios);
    }

    @GetMapping("/api/portfolios/{id}")
    // @PathVariable long id  <- 여기서 URL에 있는 {id} 값을 추출
    public ResponseEntity<PortfolioListViewResponse> findPortfolio(@PathVariable long id) {
        Portfolio portfolio = portfolioService.findById(id);

        return ResponseEntity.ok()
                .body(new PortfolioListViewResponse(portfolio));
    }

    @DeleteMapping("/api/portfolios/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable long id){
        portfolioService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/portfolios/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable long id,
                                                     @RequestBody UpdatePortfolioRequest request){
        Portfolio updatePortfolio = portfolioService.update(id, request);

        return ResponseEntity.ok()
                .body(updatePortfolio);
    }


}
