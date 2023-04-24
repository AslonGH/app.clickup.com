package uz.pdp.springbootprojectprocesses.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskAttachmentDto {


    private UUID   taskID;

    private UUID   attachmentID;

    private Boolean   pinCoverImage;

}
