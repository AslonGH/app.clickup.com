package uz.pdp.springbootprojectprocesses.entity.les10_1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Attachment extends AbsUUIDEntity {    //  File Rasm formatda


    @Column(nullable = false)
    private String  name;

    private String  originalName;

    private Long    size;

    private String  contentType;      // JPN..

}
