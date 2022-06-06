package com.zenithbank.integration.auth.authorisation;

import com.zenithbank.integration.config.exception.AuthorisationErrorException;
import com.zenithbank.integration.entity.flight.CoreUser;
import com.zenithbank.integration.entity.flight.QCoreUser;
import com.zenithbank.integration.services.CoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import javax.naming.AuthenticationException;
import java.util.Base64;
import java.util.Optional;

@Component
public class BasicAccessAuthenticationHandler {

    @Autowired
    CoreUserService coreUserService;

    public CoreUser getUser(NativeWebRequest nativeWebRequest){
        try {
            String authorizationCredential = nativeWebRequest
                    .getHeader(HttpHeaders.AUTHORIZATION)
                    .substring("Basic".length())
                    .trim();

            String[] decodedCredentials = new String(Base64.getDecoder()
                    .decode(authorizationCredential))
                    .split(":");

            QCoreUser qCoreUser = QCoreUser.coreUser;

            String username = decodedCredentials[0];

            if (coreUserService.isUserExist(qCoreUser.
                    userName.eq(username))){
                Optional<CoreUser> userOptional = coreUserService.findOne(
                        qCoreUser.userName.eq(decodedCredentials[0]).and(
                                qCoreUser.password.eq(decodedCredentials[1])));

                CoreUser user = userOptional.orElseThrow(()->
                        new AuthenticationException("Invalid login credentials"));

                return user;
            }

            throw new AuthenticationException("Error: Invalid credentials");

        }catch (Exception e){
            throw new AuthorisationErrorException(e.getMessage());
        }
    }
}
