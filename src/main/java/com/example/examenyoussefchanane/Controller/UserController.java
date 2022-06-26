package com.example.examenyoussefchanane.Controller;

import com.example.examenyoussefchanane.Entity.Category;
import com.example.examenyoussefchanane.Entity.User;
import com.example.examenyoussefchanane.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "indexUsers")
    public String indexCategory(Model model){
        List<User> users=(List <User>) userRepository.findAll();
        model.addAttribute("users",users);
        System.out.println(users);
        return "user/index.jsp";
    }
    @GetMapping(value = "deleteUser")
    public String delete(@RequestParam(value="id") Long id){
        userRepository.deleteById(id);
        return "redirect:/indexUsers";
    }
}
