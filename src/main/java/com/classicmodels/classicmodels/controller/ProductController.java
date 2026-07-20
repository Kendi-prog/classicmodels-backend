package com.classicmodels.classicmodels.controller;

import com.classicmodels.classicmodels.DTOs.ProductDTO;
import com.classicmodels.classicmodels.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOS = productService.findAll();
        return ResponseEntity.ok(productDTOS);
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<Optional<ProductDTO>> getById(@PathVariable String productCode) {
        Optional<ProductDTO> productDTO = productService.findById(productCode);
        if(productDTO.isPresent()) {
            return ResponseEntity.ok(productDTO);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        ProductDTO productDTOSaved = productService.save(productDTO);
        return ResponseEntity.ok(productDTOSaved);
    }

//    @PutMapping("/{productCode}")
//    public ResponseEntity<ProductDTO> update(@PathVariable String productCode, @RequestBody ProductDTO updatedProductDTO) {
//        return productService.findById(productCode)
//                .map(product -> {
//                    updatedProductDTO.setProductCode(productCode);
//                    return ResponseEntity.ok(productService.save(updatedProductDTO));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }

    @PutMapping("/{productCode}")
    public ResponseEntity<ProductDTO> update(@PathVariable String productCode,
                                             @RequestBody ProductDTO updatedProductDTO) {
        try {
            ProductDTO updated = productService.updateProduct(productCode, updatedProductDTO);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{productCode}")
    public ResponseEntity<String> delete(@PathVariable String productCode) {
        try {
            productService.deleteById(productCode);
            return ResponseEntity.ok("Product deleted successfully.");
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(409)
                    .body("Cannot delete product because it is used in existing orders.");
        }
    }

}

