package com.example.examenyoussefchanane.Controller;

import com.example.examenyoussefchanane.Entity.Category;
import com.example.examenyoussefchanane.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping(value = "createCategory")
    public String createCategory(){
        return "CategoryCrud/add.jsp";
    }
    @PostMapping(value = "storeCategory")
    public String storeCategory(@RequestParam("name") String name, Model model){

        Category category=new Category();
        category.setName(name);
        System.out.println(category);
        categoryRepository.save(category);

        //model.addAttribute("client",st);
        return "redirect:/indexCategory";
    }
    @GetMapping(value = "indexCategory")
    public String indexCategory(Model model){
        List<Category> categories=(List <Category>) categoryRepository.findAll();
        model.addAttribute("categories",categories);
        System.out.println(categories);
        return "CategoryCrud/index.jsp";
    }
    @GetMapping(value = "deleteCategory")
    public String delete(@RequestParam(value="id") Long id){
        categoryRepository.deleteById(id);
        return "redirect:/indexCategory";
    }
    @GetMapping(value = "editCategory")
    public  String edit(@RequestParam(value = "id") Long id,Model model){


        Optional<Category> category = categoryRepository.findById(id);
        System.out.println(category);
        model.addAttribute("category",category.get());

        return "CategoryCrud/edit.jsp";

    }
    @PostMapping(value="updateCategory")
    public String updateCategory(@RequestParam(value="name")String name, @RequestParam(value="id")Long id){

        Optional<Category> p=categoryRepository.findById(id);
        p.get().setName(name);
        categoryRepository.save(p.get());
        return "redirect:/indexCategory";

    }
}
