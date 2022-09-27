package com.Pilotos.pilotosCompany.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;

    @Controller
    public class HomeController {

        @GetMapping("/index")
        public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
            return "index";
        }

    }
