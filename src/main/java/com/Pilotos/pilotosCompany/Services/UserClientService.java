package com.Pilotos.pilotosCompany.Services;

import com.Pilotos.pilotosCompany.Model.UserClient;
import com.Pilotos.pilotosCompany.Repository.UserClientRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class UserClientService {
    private UserClientRepository repository;

    public UserClientService(UserClientRepository repository){
        this.repository = repository;
    }

    public UserClient createUserClient (UserClient newUserClient){
        return this.repository.save(newUserClient);
    }

    public UserClient findUserByEmail (String email){
        return this.repository.findByEmail(email);
    }
    public UserClient getOrCreateUser(Map<String, Object> userData){
            String email = (String) userData.get("email");

            UserClient userClient = findUserByEmail(email);
            if(userClient==null) {
                String name = (String) userData.get("nickname");
                String image = (String) userData.get("picture");
                String auth0Id = (String) userData.get("sub");

                UserClient newUserClient = new UserClient(email = email, image = image, auth0Id = auth0Id);

                return createUserClient(newUserClient);
            }
            System.out.println(userClient);
            return userClient;
    }


}
