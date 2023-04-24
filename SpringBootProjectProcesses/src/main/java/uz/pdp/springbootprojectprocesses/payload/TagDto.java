package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class TagDto {

    @NotNull
    private String  name;

    private String  color;

    private Long    workSpaceID;
}
