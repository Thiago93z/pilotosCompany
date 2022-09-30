package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Model.UserClient;
import com.Pilotos.pilotosCompany.Services.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class WebController {

        @Autowired
        UserClientService userClientService;


        @GetMapping("/")
        public String index(Model model, @AuthenticationPrincipal OidcUser principal, Model newModel){

            if(principal!=null) {
                newModel.addAttribute("profile", principal.getClaims());
                UserClient userClient = this.userClientService.getOrCreateUser(principal.getClaims());
                model.addAttribute("userClient", userClient);
                System.out.println(userClient.getRol());
                System.out.println(principal.getClaims());
            }
            return "index";
        }

    }

