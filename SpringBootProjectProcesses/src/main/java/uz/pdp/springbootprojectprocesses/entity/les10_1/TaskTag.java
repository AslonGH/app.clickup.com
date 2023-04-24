package uz.pdp.springbootprojectprocesses.entity.les10_1;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TaskTag extends AbsUUIDEntity {

    // Qizil bayroqcha

    @ManyToOne
    private Task task;

    @OneToOne
    private Tag tag;

}
