package uz.pdp.springbootprojectprocesses.entity.Les9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.enums.WorkSpacePermissionName;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class WorkSpacePermission extends AbsUUIDEntity {      // LAVOZIM VA HUQUQ NI BIRLASHTIRADIGAN TABLE


    // 4ta Doimiy lavozim: OWNER,ADMIN,MEMBER,GUEST BO'LADI.QO'SHIMCHA: MEHMON, DIRECTOR..KABI XOXLAGANCHA OCHISH MUMKIN
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private WorkSpaceRole workSpaceRole;  //O'RINBOSAR


    // MAVJUD BOLGAN 4 ta ROLNING, OWNER dn tashqari  3 lasidan EXTEND QILADI.
    @Enumerated(EnumType.STRING)
    private WorkSpacePermissionName  permissionName;  //add member, remover member

}
