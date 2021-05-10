package com.myproject.Controllers;

import com.myproject.Entitiy.Product;
import com.myproject.Entitiy.Task;
import com.myproject.Services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    productService productService;

    @Scheduled(fixedDelay = 1000L)
    public void scheduler() {
        Logger l= Logger.getLogger("");
        l.info( "time="+LocalDateTime.now());

    }

    @GetMapping("/")
    public String productPage(Model model, Product product) {
        model.addAttribute("product", product);
        return "product.html";
    }
    @GetMapping("/view-product")
    public String viewProduct(Model model) {
        List<Product> products=this.productService.getAll();
        model.addAttribute("products", products);
        return "view-product.html";
    }
    @GetMapping("/form")
    public String productForm() {
        return "product-form.html";
    }
    @PostMapping("/save-product")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, @RequestParam("picture")MultipartFile pic) {


        if(bindingResult.hasFieldErrors("name"))
        {
            System.out.println(bindingResult.getFieldError()+"chala");
            return "product.html";
        }

    try
    {
        product.setPicture(pic.getOriginalFilename());
        Product p=this.productService.save(product);
        System.out.println(p.toString());
        if(p!=null)
        {
            File myFile=new ClassPathResource("resources/static/images").getFile();
            System.out.println(myFile.getAbsolutePath());
            Path path= Paths.get(myFile.getAbsolutePath()+File.separator+pic.getOriginalFilename());
            System.out.println(path.getFileName());
           System.out.println(Files.copy(pic.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING));
        }

    }
    catch (Exception e)
    {

    }

        return "redirect:/product/view-product";
    }

}
