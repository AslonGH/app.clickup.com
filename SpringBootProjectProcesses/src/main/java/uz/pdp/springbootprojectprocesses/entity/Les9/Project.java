package uz.pdp.springbootprojectprocesses.entity.Les9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.Les9.Space;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Project extends AbsUUIDEntity {

    // User Project da faqat edit qila olishi va Project ichidagi Category esa full(hamma) ish ni qila olishi mumkin.
    // Yoki Comment yoza olishi mumkin
    // Space ichidagi  Project (Loyiha), Project ichida Category boladi.
    @Column(nullable = false)
    private String  name;

    @ManyToOne
    private Space space;

    private String  accessType;     // private yoki public  bolad. private bolsa faqat project ga tegishli odamlar kora oladi

    private boolean archived;

    private String  color;
}
