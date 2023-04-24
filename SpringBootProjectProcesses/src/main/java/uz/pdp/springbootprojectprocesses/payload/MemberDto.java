package uz.pdp.springbootprojectprocesses.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import uz.pdp.springbootprojectprocesses.entity.enums.AddType;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // FIELDNI QIYMATI null BOLSA CLIENTga BERMASLIK UCHUN
public class MemberDto {

   private  UUID    id;        // UserId
   private  UUID    roleId;    // WorkSpaceRoleId
   private  AddType addType;

   private String    fullName;
   private String    email;
   private String    roleName;
   private Timestamp lastActive;

}
