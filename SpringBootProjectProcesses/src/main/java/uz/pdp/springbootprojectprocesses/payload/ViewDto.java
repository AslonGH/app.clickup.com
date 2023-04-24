package uz.pdp.springbootprojectprocesses.payload;

import lombok.Data;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Icon;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class ViewDto {

    @NotNull
    private String name;

    private UUID iconID;

}
