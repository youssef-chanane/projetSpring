package com.example.examenyoussefchanane.Controller;

import com.example.examenyoussefchanane.Entity.Category;
import com.example.examenyoussefchanane.Entity.Product;
import com.example.examenyoussefchanane.Repository.CategoryRepository;
import com.example.examenyoussefchanane.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping(value = "createProduct")
    public String createProduct( Model model)
    {
        List<Category> categories=(List <Category>) categoryRepository.findAll();
        model.addAttribute("categories",categories);
        return "ProductCrud/add.jsp";
    }
    @PostMapping(value = "storeProduct")
    public String storeProduct(@RequestParam("name") String name,@RequestParam("price") Integer price,@RequestParam("category") Integer categoryId, Model model){

        Optional<Category> category = categoryRepository.findById(Long.valueOf(categoryId));
        Product product=new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        product.setCategory(category.get());
        System.out.println(product);
        productRepository.save(product);

        //model.addAttribute("client",st);
        return "redirect:/indexProduct";
    }
    @GetMapping(value = "indexProduct")
    public String indexProduct(Model model){
        List<Product> products=(List <Product>) productRepository.findAll();
        model.addAttribute("products",products);
        System.out.println(products);
        return "ProductCrud/index.jsp";
    }
    @GetMapping(value = "Products")
    public String Products(Model model){
        List<Product> products=(List <Product>) productRepository.findAll();
        model.addAttribute("products",products);
        System.out.println(products);
        return "show/productIndex.jsp";
    }
    @GetMapping(value = "deleteProduct")
    public String delete(@RequestParam(value="id") Long id){
        productRepository.deleteById(id);
        return "redirect:/indexProduct";
    }
    @GetMapping(value = "editProduct")
    public  String edit(@RequestParam(value = "id") Long id,Model model){


        Optional<Product> product = productRepository.findById(id);
        System.out.println(product);
        model.addAttribute("product",product.get());

        return "ProductCrud/edit.jsp";

    }
    @PostMapping(value="updateProduct")
    public String updateProduct(@RequestParam(value="name")String name,@RequestParam(value="price")Integer price, @RequestParam(value="id")Long id){

        Optional<Product> p=productRepository.findById(id);
        p.get().setProductPrice(price);
        p.get().setProductName(name);
        productRepository.save(p.get());
        return "redirect:/indexProduct";

    }
}
