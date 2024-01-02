package com.example.trelloweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/home")
    public ModelAndView mainPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/home");
        return view;
    }
<<<<<<< Updated upstream
    @RequestMapping("/")
    public String toHome() {
        return "redirect:/home";
    }



    //테스트용
   /* @GetMapping ("/test")
    public ModelAndView test() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/aboutViews");
        return view;
    }*/

=======
>>>>>>> Stashed changes
}

