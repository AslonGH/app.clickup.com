package uz.pdp.springbootprojectprocesses.entity.Les9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;
import javax.persistence.*;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class WorkSpaceUser  extends AbsUUIDEntity {         // KOMPANIYA XODIMLARI;

    // BIR WorkSpaceUser boshqa WorkSpace larda ham ishlashi mumkin
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private WorkSpace workSpace;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private WorkSpaceRole workSpaceRole;


    @Column(nullable = false)
    private Timestamp dateInvited;

    private Timestamp dateJoined;

}
