package com.Pilotos.pilotosCompany.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;

import java.sql.SQLOutput;

@Controller
    public class HomeController {

        @GetMapping("/")
        public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
            if(principal!=null) {
                System.out.println(principal.getClaims());
            }
            return "index";
        }

    }
