package com.ashop.controller;

import com.ashop.data.dto.response.ShopOrderResponseDTO;
import com.ashop.service.impl.ShopOrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class ShopOrderController {

    private final ShopOrderServiceImpl shopOrderService;

    public ShopOrderController(ShopOrderServiceImpl shopOrderService) {
        this.shopOrderService = shopOrderService;
    }

    //주문 목록 전체 조회
    @GetMapping("/list")
    public ModelAndView selectOrderList(HttpServletRequest request) throws Exception {
        //HttpSession session = request.getSession();
        //Integer customId = (Integer) session.getAttribute("customId");
        //List<ShopOrderResponseDTO> orderList = this.shopOrderService.selectOrderList(customId);
        List<ShopOrderResponseDTO> orderList = this.shopOrderService.selectOrderList();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("order/list");
        mav.addObject("orderList",orderList);
        return mav;
    }

}
