package mainpackage.PastTask.ArgumentsGETPOST;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService productService){
        service = productService;
        Product p = new Product();
        p.setName("Bread");
        p.setPrice(100.50);
        service.addProduct(p);
    }

    @GetMapping("/products")
    public String checkProducts(Model model){
        var products = service.findAll();
        model.addAttribute("basket",products);
        return "products.html";
    }



    @PostMapping(path = "/products")
    public String addProduct(@RequestParam String name,
                           @RequestParam double price,
                           Model model){
        var product = new Product();
        product.setName(name);
        product.setPrice(price);

        service.addProduct(product);

        var products = service.findAll();
        model.addAttribute("basket",products);
        return "products.html";
    }
}
