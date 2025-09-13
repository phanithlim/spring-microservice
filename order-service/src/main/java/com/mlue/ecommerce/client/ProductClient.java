package com.mlue.ecommerce.client;

import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.dto.ProductPurchaseDto;
import com.mlue.ecommerce.dto.ProductPurchaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public ApiResponse<List<ProductPurchaseResponseDto>> purchaseProducts(List<ProductPurchaseDto> requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<List<ProductPurchaseDto>> requestEntity = new HttpEntity<>(requestBody, headers);
        ParameterizedTypeReference<ApiResponse<List<ProductPurchaseResponseDto>>> responseType = new ParameterizedTypeReference<>() {};
        return restTemplate.exchange(productUrl + "/product-purchases", HttpMethod.POST, requestEntity, responseType).getBody();
    }

}
