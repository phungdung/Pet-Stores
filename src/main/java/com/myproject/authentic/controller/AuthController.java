package com.myproject.authentic.controller;

import com.myproject.authentic.model.JwtRequest;
import com.myproject.authentic.model.JwtResponse;
import com.myproject.authentic.model.JwtUserDetails;
import com.myproject.authentic.repository.MemberAccountRepository;
import com.myproject.authentic.security.JwtAuthenticationProvider;
import com.myproject.common.Constant;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/account")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;
    @Autowired
    private MemberAccountRepository memberAccountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(path = "/signup")
    public ResponseEntity<ResultInsideDTO> registerAccount(@RequestBody JwtRequest jwtRequest) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        if (memberAccountRepository.existsByEmail(jwtRequest.getEmail())) {
            resultInsideDTO.setKey(Constant.RESPONSE_KEY.ERROR);
            resultInsideDTO.setMessages("Error: Email is already in use!");
            return new ResponseEntity<>(resultInsideDTO, HttpStatus.BAD_REQUEST);
        }
        // Create new user's account
        MemberDTO user = new MemberDTO(jwtRequest.getEmail(),
                passwordEncoder.encode(jwtRequest.getPassword()));
        memberAccountRepository.save(user.toEntity());
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/signin")
    public ResponseEntity<?> loginAccount(@RequestBody JwtRequest jwtRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtAuthenticationProvider.generateJwtToken(authentication);
        JwtUserDetails userDetails = (JwtUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return new ResponseEntity<>(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getEmail(),
                roles), HttpStatus.OK);
    }

}
