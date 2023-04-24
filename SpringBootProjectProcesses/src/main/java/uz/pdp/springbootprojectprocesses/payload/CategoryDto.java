package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class CategoryDto {


    @NotNull
    private String  name;

    private UUID    projectId;

    private String  accessType;

    private boolean archived;

    private String  color;


}
