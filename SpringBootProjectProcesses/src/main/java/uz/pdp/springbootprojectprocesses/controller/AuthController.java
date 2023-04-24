package uz.pdp.springbootprojectprocesses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.LoginDto;
import uz.pdp.springbootprojectprocesses.payload.RegisterDto;
import uz.pdp.springbootprojectprocesses.security.JwtProvider;
import uz.pdp.springbootprojectprocesses.serviceImp.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

     @Autowired
     AuthService authService;

     @Autowired
     AuthenticationManager authenticationManager;

     @Autowired
     JwtProvider jwtProvider;




    @PostMapping("/register")
    public HttpEntity<?>registerUser(@Valid @RequestBody RegisterDto registerDto){

        ApiResponse apiResponse = authService.registerUser(registerDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PostMapping("/login")
    public HttpEntity<?>loginUser(@Valid  @RequestBody LoginDto loginDto){
        try {
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                 loginDto.getEmail(),
                 loginDto.getPassword()
         ));
            User user = (User) authentication.getPrincipal();
          String token = jwtProvider.generateToken(user.getEmail());
          return ResponseEntity.ok(token);

        } catch (Exception e) {
        return ResponseEntity.ok(new ApiResponse("Parol yoki login xato",false));
       }
    }


    @PutMapping("/verifyEmail")
    public HttpEntity<?>verifyEmail(@RequestParam String    email, @RequestParam String emailCode){
    ApiResponse apiResponse = authService.verifyEmail(email, emailCode);
    return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


}
