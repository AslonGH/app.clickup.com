package uz.pdp.springbootprojectprocesses.entity.Les9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.enums.WorkSpaceRoleName;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"work_space_id","name"}))
public class WorkSpaceRole  extends AbsUUIDEntity {


    // 4ta Doimiy lavozim: OWNER,ADMIN,MEMBER,GUEST BO'LADI.QO'SHIMCHA: MEHMON, DIRECTOR..KABI XOXLAGANCHA OCHISH MUMKIN
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private WorkSpace  workSpace;

    @Column(nullable = false)
    private String   name;

    // MAVJUD BOLGAN 4 ta ROLNING, OWNER dn tashqari  3 lasidan EXTEND QILADI. VA UNING HAMMA HUQUQLARINI OZLASHTIRADI.
    @Enumerated(EnumType.STRING)
    private WorkSpaceRoleName  extendsRole;



}
