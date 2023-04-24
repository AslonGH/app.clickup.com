package uz.pdp.springbootprojectprocesses.entity.Les9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.enums.TaskPermission;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ProjectUser extends AbsUUIDEntity {

    @ManyToOne
    private Project project;

    @OneToOne
    private User user;      // ProjectUserning ozi

    private TaskPermission  taskPermission;

}
