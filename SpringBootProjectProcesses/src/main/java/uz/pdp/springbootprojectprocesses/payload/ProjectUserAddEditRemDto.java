package uz.pdp.springbootprojectprocesses.payload;

import lombok.Data;
import uz.pdp.springbootprojectprocesses.entity.enums.AddType;
import uz.pdp.springbootprojectprocesses.entity.enums.TaskPermission;

import java.util.UUID;

@Data
public class ProjectUserAddEditRemDto {

   private  UUID     projectId;

   private  UUID     userId;

   private  AddType  addType;

   private  TaskPermission taskPermission;
}
