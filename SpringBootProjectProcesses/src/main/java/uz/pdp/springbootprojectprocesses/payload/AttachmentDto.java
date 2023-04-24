package uz.pdp.springbootprojectprocesses.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
public class AttachmentDto {


    @NotNull
    private String name;

    private String originalName;

    private Long   size;

    private String contentType;      // JPN..

}
