package com.myproject.authentic.business;

import com.myproject.authentic.model.*;
import com.myproject.authentic.repository.*;
import com.myproject.common.utils.DataUtil;
import com.myproject.data.dto.ManagerDTO;
import com.myproject.data.dto.MemberDTO;
import com.myproject.data.entity.ManagerEntity;
import com.myproject.data.entity.MemberEntity;
import com.myproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberAccountRepository memberAccountRepository;
    @Autowired
    private ManagerAccountRepository managerAccountRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<String> roles = new HashSet<>();
        Optional<ManagerEntity> manager = managerAccountRepository.findByEmail(username);
        if (DataUtil.isNullOrEmpty(manager)) {
            MemberEntity user = memberAccountRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
            MemberDTO memberDTO = user.toDto();
            roles.add("ROLE_USER");
            memberDTO.setRoles(roles);
            return JwtUserDetails.build(memberDTO);
        } else {
            ManagerDTO managerDTO = manager.get().toDto();
            String[] arr = managerDTO.getRoleCode().split(",");
            for (String role : arr) {
                roles.add(role);
            }
            managerDTO.setRoles(roles);
            return JwtUserDetails.build(managerDTO);
        }
    }
}
