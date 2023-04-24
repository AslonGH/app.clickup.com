package uz.pdp.springbootprojectprocesses.payload;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)   // QIYMAT BERILMASA CLIENT GA CHIQMASIN
public class  WorkSpaceDto {

    private Long    id;

    @NotNull
    private String  name;

    @NotNull
    private String  color;

    private UUID    avatarId;

    private UUID    ownerId;

    private String  initialLetter;

}
