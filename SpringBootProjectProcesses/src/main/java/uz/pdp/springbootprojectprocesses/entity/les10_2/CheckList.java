package uz.pdp.springbootprojectprocesses.entity.les10_2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Task;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CheckList extends AbsUUIDEntity {
    // CheckList Task ga tegishli boladi.(Izohga oxshash boladi), CheckListItem esa CheckList ichida boaldi.

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Task task;

}

