package com.example.codingtestproject.controller;

import com.example.codingtestproject.domain.Portfolio;
import com.example.codingtestproject.dto.AddPortfolioRequest;
import com.example.codingtestproject.dto.PortfolioResponse;
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

    // HTTP 메서드가 POST일 때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/portfolios")
    // @RequestBody로 요청 본문 값 매핑
    public ResponseEntity<Portfolio> addPortfolio(@RequestBody AddPortfolioRequest request){
        Portfolio savedPortfolio = portfolioService.save(request);

        // 요청한 자원이 성공적으로 생성되었으며 저장된 포트폴리오 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPortfolio);

    }

    @GetMapping("/api/portfolios")
    public ResponseEntity<List<PortfolioResponse>> findAllPortfolio(){
        List<PortfolioResponse> portfolios = portfolioService.findAll()
                .stream()
                .map(PortfolioResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(portfolios);
    }

    @GetMapping("/api/portfolios/{id}")
    // @PathVariable long id  <- 여기서 URL에 있는 {id} 값을 추출
    public ResponseEntity<PortfolioResponse> findPortfolio(@PathVariable long id) {
        Portfolio portfolio = portfolioService.findById(id);

        return ResponseEntity.ok()
                .body(new PortfolioResponse(portfolio));
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
