package uz.pdp.springbootprojectprocesses.entity.les10_2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Task;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TaskHistory extends AbsUUIDEntity {

    @ManyToOne
    private Task task;
    private String changeFieldName;
    private Boolean before;
    private Boolean after;
    private LocalDate date;
}
