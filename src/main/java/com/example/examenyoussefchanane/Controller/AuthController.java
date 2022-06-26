package com.example.examenyoussefchanane.Controller;

import com.example.examenyoussefchanane.Entity.Category;
import com.example.examenyoussefchanane.Entity.Product;
import com.example.examenyoussefchanane.Entity.User;
import com.example.examenyoussefchanane.Repository.CategoryRepository;
import com.example.examenyoussefchanane.Repository.ProductRepository;
import com.example.examenyoussefchanane.Repository.UserRepository;
import com.mysql.cj.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class AuthController {
    private static final User USER = new User();

    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "/register")
    public String register()
    {
        return "register.jsp";
    }
    @GetMapping(value = "/createUsers")
    public String createUsers()
    {
        return "user/add.jsp";
    }
    @PostMapping(value = "storeUser")
    public String storeUser(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("email") String email, Model model){

        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("role");
        System.out.println(user);
        userRepository.save(user);

        //model.addAttribute("client",st);
        return "redirect:/login";
    }
    @PostMapping(value = "storeUsers")
    public String storeUsers(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("email") String email, Model model){

        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("role");
        System.out.println(user);
        userRepository.save(user);

        //model.addAttribute("client",st);
        return "redirect:/indexUsers";
    }
    @GetMapping(value = "/login")

    public String login()
    {

        return "login.jsp";

    }
    @PostMapping(value = "/signUp")

    public String signUp(HttpSession session,@RequestParam("password") String password,@RequestParam("email") String email,Model model){
        boolean existEmail = userRepository.existsByEmail(email);
        System.out.println(existEmail);
        if(existEmail==true){
            Optional<User> user = userRepository.findByEmail(email);
            System.out.println(user.get().getPassword());

            if(!Objects.equals(user.get().getPassword(), password)){
                System.out.println("password");
                return "home.jsp";
            }else{
                session.setAttribute("role", user.get().getRole());
                if(Objects.equals(user.get().getRole(), "prodadmin")){
                    System.out.println("prodadmin");
                    return "redirect:/indexCategory";
                } else if (Objects.equals(user.get().getRole(), "useradmin")) {
                    System.out.println("useradmin");
                    return "redirect:/indexUsers";
                }else{

                    System.out.println("user");

                    return "redirect:/Products";
                }
            }
        }
        return "home.jsp";



    }

}
