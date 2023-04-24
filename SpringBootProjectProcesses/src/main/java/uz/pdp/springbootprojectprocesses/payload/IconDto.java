package uz.pdp.springbootprojectprocesses.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Attachment;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.UUID;


@Data
public class IconDto  {

    private UUID attachmentID;

    private String color;

    private String initialLetter;

    private UUID iconID;
}
