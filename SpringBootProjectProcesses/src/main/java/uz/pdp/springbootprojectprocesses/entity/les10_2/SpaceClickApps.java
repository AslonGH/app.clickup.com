package uz.pdp.springbootprojectprocesses.entity.les10_2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.Les9.Space;
import uz.pdp.springbootprojectprocesses.entity.les10_2.ClickApps;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SpaceClickApps extends AbsUUIDEntity {    //Space va ClicksApps ni birlashgan joyi


    @ManyToOne
    private Space space;

    @OneToOne
    private ClickApps clickApps;  // yani name desa boladi

}
