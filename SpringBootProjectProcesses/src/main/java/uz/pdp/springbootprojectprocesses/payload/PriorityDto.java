package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class PriorityDto {


    @NotNull
    private String name;

    private UUID iconID;

}
