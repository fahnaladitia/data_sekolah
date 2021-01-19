package net.data.sekolah.service;

import net.data.sekolah.model.User;
import net.data.sekolah.repositories.MyUserDetails;
import net.data.sekolah.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("Could Not Find User");
        }
        return new MyUserDetails(user);
    }
}
