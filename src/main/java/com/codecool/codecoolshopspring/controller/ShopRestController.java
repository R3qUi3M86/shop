package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.model.dto.OrderDTO;
import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import com.codecool.codecoolshopspring.model.dto.SupplierDTO;
import com.codecool.codecoolshopspring.service.ShopDTOService;
import com.codecool.codecoolshopspring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController // - using this makes controler not require @ResponseBody annotation in each function that returns JSON
public class ShopRestController {
    private final ShopService service;
    private final DTOService serviceDTO;

    @Autowired
    public ShopRestController(ShopService service, DTOService serviceDTO) {
        this.service = service;
        this.serviceDTO = serviceDTO;
    }

    @GetMapping("/product/filter")
    public List<ProductDTO> getProductsDTObyFilter(@RequestParam(defaultValue = "0") int supplierId, @RequestParam(defaultValue = "0") int categoryId) {
        return serviceDTO.getProductDTOService().getProductsDTOForFilter(supplierId,categoryId);
    }

    @GetMapping("/category/findAll")
    public List<ProductCategoryDTO> getAllCategoryNames() {
        return serviceDTO.getProductCategoryDTOService().getAll();
    }

    @GetMapping("/supplier/findAll")
    public List<SupplierDTO> getAllSupplierNames() {
        return serviceDTO.getSupplierDTOService().getAll();
    }

    @PostMapping("/cart/addProduct")
    public Map<String, Integer> addProductToCart(@RequestBody Map<String, Object> payload){
        String userName = (String) payload.get("userName");
        Integer prodId = Integer.parseInt((String) payload.get("productId"));
        return service.addProductToOrder(userName, prodId);
    }

    @PostMapping("/cart/removeProduct")
    public Map<String, Integer> removeProductFromCart(@RequestBody Map<String, Object> payload){
        String userName = (String) payload.get("userName");
        Integer prodId = Integer.parseInt((String) payload.get("productId"));
        return service.removeProductFromOrder(userName, prodId);
    }

    @PostMapping("/order/find")
    public Map<String, Object> getUserOrder(@RequestBody Map<String, Object> payload){
        Optional<Order> order =  service.getUserOrder((String) payload.get("userName"));
        Map<String, Object> response = new HashMap<>();
        if (order.isPresent()) {
            OrderDTO orderDTO = new OrderDTO(order.get());
            response.put("order", orderDTO);
            response.put("products", serviceDTO.getProductsDTOList(order.get().getProducts().keySet()));
        } else {
            response.put("order", "not found");
        }
        return response;
    }

    @PostMapping("/order/clear")
    public Map<String, String> emptyCurrentOrder(@RequestBody Map<String, Object> payload){
        return service.clearUserOrder((String) payload.get("userName"));
    }
}
