package dev.ramana.productservice.Controllers;

import dev.ramana.productservice.Services.FakeStoreProductService;
import dev.ramana.productservice.Services.ProductService;
import dev.ramana.productservice.dtos.GenericProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<GenericProductDTO> getAllProductsById(Long id){
        return productService.getAllProductsById(id);
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id){

        return productService.getProductById(id);
    }

    @PutMapping("{id}")
    public GenericProductDTO updateProductById(@RequestBody GenericProductDTO genericProductDTO, @PathVariable("id")Long id){
        //@RequestBody annotation is responsible for binding the HTTPRequest body to the body of the web request
        return productService.updateProductById(genericProductDTO, id);
    }
    @PostMapping()
    public  GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDTO){
        //@RequestBody annotation is responsible for binding the HTTPRequest body to the body of the web request
        return productService.createProduct(genericProductDTO);

    }

    @DeleteMapping("{id}")
    public GenericProductDTO deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }


}
