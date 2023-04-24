package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import uz.pdp.springbootprojectprocesses.entity.enums.TaskPermission;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
public class CategoryUserDto {

    @NotNull
    private String   name;

    private UUID categoryID;

    private UUID userID;

    private TaskPermission taskPermission;

}
