package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import uz.pdp.springbootprojectprocesses.entity.enums.WorkSpaceRoleName;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
public class WorkSpaceRoleDto {

    private UUID               id;
    @NotNull
    private String             name;
    private Long               workSpaceId;
    private WorkSpaceRoleName  roleName;
    private WorkSpaceRoleName  extendsRole;

}
