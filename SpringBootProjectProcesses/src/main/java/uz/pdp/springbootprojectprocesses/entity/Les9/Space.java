package uz.pdp.springbootprojectprocesses.entity.Les9;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Attachment;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Icon;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Space extends AbsUUIDEntity {
    // DEPARTMENT YANI ISHXONADAGI BITTA BO'LIM, Space WorkSpacening icida boladi

    @Column(nullable = false)
    private String   name;

    private String   color;

    @ManyToOne
    private WorkSpace workSpace;

    private String  initialLetter;

    @OneToOne
    private Icon icon;

    @OneToOne
    private Attachment avatar;

    @OneToOne
    private User owner;


    // Space (department) private yoki  public ekanligi, Agar private bo'lsa, tasklarni Space dagi odamlargina ko'ra oladi,
    // Ishxonadagi qolgan odamlar  korolmaydi
    private String accessType;


}
