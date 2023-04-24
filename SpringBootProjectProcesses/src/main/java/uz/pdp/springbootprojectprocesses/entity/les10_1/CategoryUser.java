package uz.pdp.springbootprojectprocesses.entity.les10_1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.enums.TaskPermission;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CategoryUser extends AbsUUIDEntity {


    @Column(nullable = false)
    private String   name;

    @ManyToOne
    private Category category;

    @OneToOne
    private User user;

    @Enumerated(value=EnumType.STRING)
    private TaskPermission taskPermission;

}
