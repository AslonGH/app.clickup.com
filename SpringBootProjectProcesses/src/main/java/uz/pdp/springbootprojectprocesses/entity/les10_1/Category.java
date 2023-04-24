package uz.pdp.springbootprojectprocesses.entity.les10_1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;
import uz.pdp.springbootprojectprocesses.entity.Les9.Project;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Category extends AbsUUIDEntity {
 // Category (ClickUp da First Step,List deb nomlagan edik ): Tasklarning majmuasi ya'ni Catgegory ichida tasklar boladi.
 // Category : Space yoki Projet(Folder) ga tegishli bzw. Ichida  bo'lishi mumkin
 // Butun Project ga qoshilgan User Category ga ham arlasha olishi mumkin. Faqat bitta Category bo'lib boshqasiga
 // aralashmasligi ham mumkin,ya'ni Project emas faqat bir Categoryga  User qoshilishi mumkin.

    @Column(nullable = false)
    private String  name;

    @ManyToOne
    private Project project;

    private String  accessType;

    private boolean archived;

    private String  color;

}
