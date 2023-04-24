package uz.pdp.springbootprojectprocesses.payload;

import lombok.Data;
import uz.pdp.springbootprojectprocesses.entity.enums.AddType;
import uz.pdp.springbootprojectprocesses.entity.enums.WorkSpacePermissionName;

import java.util.UUID;

@Data
public class AddRemovePermissionDto {

    private  UUID     roleId; // WorkSpaceRole ning Id si
    private  WorkSpacePermissionName permissionName;
    private  AddType  addType;
}
