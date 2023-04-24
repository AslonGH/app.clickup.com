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
public class Icon extends AbsUUIDEntity {

    private String color;

    private String initialLetter;

    @OneToOne
    private Attachment attachment;

    @OneToOne
    private Icon  icon;
}
