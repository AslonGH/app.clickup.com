package uz.pdp.springbootprojectprocesses.payload;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterDto {

    @NotNull
    private String  fullName;

    @NotNull
    private String  email;

    @NotNull
    private String  password;

}
