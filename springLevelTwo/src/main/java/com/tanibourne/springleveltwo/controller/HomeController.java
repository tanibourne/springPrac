package com.tanibourne.springleveltwo.controller;


import com.tanibourne.springleveltwo.domain.UserRoleEnum;
import com.tanibourne.springleveltwo.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method= {RequestMethod.GET, RequestMethod.POST})
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());

        if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
            model.addAttribute("admin_role", true);
        }

        return "index";
    }
}


//@RequestMapping(value = "/board/view.do", method= {RequestMethod.GET, RequestMethod.POST})