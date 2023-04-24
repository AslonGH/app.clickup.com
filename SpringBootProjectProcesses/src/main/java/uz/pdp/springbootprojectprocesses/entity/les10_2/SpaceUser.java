package uz.pdp.springbootprojectprocesses.entity.les10_2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.Les9.Space;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SpaceUser extends AbsUUIDEntity {

    @ManyToOne
    private Space  space;

    @OneToOne
    private User   member;

}
