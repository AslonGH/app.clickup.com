package uz.pdp.springbootprojectprocesses.entity.les10_1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.Les9.WorkSpace;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tag extends AbsUUIDEntity {

    @Column(nullable = false)
    private String name;

    private String color;

    @ManyToOne
    private WorkSpace workSpace;
}
