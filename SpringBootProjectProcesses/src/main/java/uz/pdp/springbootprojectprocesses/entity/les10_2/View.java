package uz.pdp.springbootprojectprocesses.entity.les10_2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Icon;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class View  extends AbsUUIDEntity {    // TASKLARNING KORINISHI

     // Tasklarning qanaday ko'rinishi bo'yicha  view tanlanadi

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Icon icon;
}
