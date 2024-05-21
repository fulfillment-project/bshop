package com.ashop.controller;

import com.ashop.data.dto.request.ShopOrderRequestDTO;
import com.ashop.data.dto.response.ProductResponseDTO;
import com.ashop.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    //상품 전체 목록 조회
    @GetMapping("/list")
    public ModelAndView selectProductList() throws Exception{
        List<ProductResponseDTO> productList = this.productService.selectProductList();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("product/list");
        mav.addObject("productList", productList);
        return mav;
    }

    //상품 상세 조회
    @GetMapping("/detail/{sellerProductId}")
    public ModelAndView selectProduct(@PathVariable Long sellerProductId) throws Exception{
        ProductResponseDTO product = this.productService.selectOne(sellerProductId);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("product/detail");
        mav.addObject("product",product);
        return mav;
    }

    //상품 구매 화면
    @GetMapping("/purchase/{sellerProductId}")
    public ModelAndView purchaseProductForm(@PathVariable Long sellerProductId, @RequestParam("buyProductCount") Integer buyProductCount) throws Exception{
        ProductResponseDTO product = this.productService.selectOne(sellerProductId);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("product/purchase");
        mav.addObject("product",product);
        mav.addObject("buyProductCount",buyProductCount);
        return mav;
    }
    
    //상품 구매하기
    @PostMapping("/purchase/{sellerProductId}")
    public ModelAndView purchaseProduct(@PathVariable Long sellerProductId, ShopOrderRequestDTO orderRequestDTO) throws Exception{
        this.productService.purchaseProduct(sellerProductId,orderRequestDTO);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/order/list");
        return mav;
    }
}
