package com.ayigroup.mepv.security.auth;

import com.ayigroup.mepv.security.resgistration.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ayigroup.mepv.security.auth.AppUserRole.*;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userNickName) throws UsernameNotFoundException {
        return appUserRepository.findByUserNickName(userNickName)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("usuario %s no se encuentra registrado", userNickName)));
    }

    public AppUser signUpUser(RegistrationRequest request) {
        AppUser appUser = new AppUser(USER.getGrantedAuthorities());
        appUser.setUserNickName(request.getRequestUser());
        appUser.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        appUser.setAppUserRole(USER);


        boolean userExits = appUserRepository
                .findByUserNickName(appUser.getUsername())
                .isPresent();

        if (userExits) {
            throw new IllegalStateException("usuario no disponible");
        }
        return appUserRepository.save(appUser);
    }

    @Bean
    private AppUser adminRegister() {
        AppUser admin = new AppUser(ADMIN.getGrantedAuthorities());
        admin.setUserNickName("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setAppUserRole(ADMIN);
        return appUserRepository.save(admin);
    }
}
