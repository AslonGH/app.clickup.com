package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.RegisterDto;
import uz.pdp.springbootprojectprocesses.repository.UserRepository;
import uz.pdp.springbootprojectprocesses.entity.enums.SystemRoleName;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JavaMailSender javaMailSender;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email+" topilmadi"));
    }

    public ApiResponse registerUser(RegisterDto registerDto) {

        if (userRepository.existsByEmail(registerDto.getEmail())) return new ApiResponse("Bunday Email mavjud ",false);
        User user =new User(
                registerDto.getFullName(),registerDto.getEmail(),
                passwordEncoder.encode(registerDto.getPassword()),
                SystemRoleName.SYSTEM_ROLE_USER);

        int code = new Random().nextInt(999999); // Random dan chiqqan sonni 999999 ga kopaytiradi.
        user.setEmailCode(String.valueOf(code).substring(0,4));
        userRepository.save(user);
        sendEMail(user.getEmailCode(), user.getEmail());
        return new ApiResponse("User saved",true);
    }

    // SimpleMailMessage Classi orqali Userning Emailiga tasdialash Linkini jönatamiz
    public void sendEMail(String emailCode, String sendingEmail){
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("test@gmail.com"); // JÖNATILADIGAN EMAIL(IXTIYORIY EMAILNI YOZSA BÖLADI)
            mailMessage.setTo(sendingEmail);
            mailMessage.setSubject("Accountni tasdiqlash");
            mailMessage.setText(emailCode);
            javaMailSender.send(mailMessage);
        }catch (Exception ignored){

        }
    }

    public ApiResponse verifyEmail(String email, String emailCode) {

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            if (emailCode.equals(user.getEmailCode())){
                user.setEnabled(true);
                userRepository.save(user);
                return new ApiResponse("Acount aktivlashtirildi",true);
            }
            return new ApiResponse("Kod xato",false);
        }
        return new ApiResponse("Bunday User mavju emas",false);
    }

}
