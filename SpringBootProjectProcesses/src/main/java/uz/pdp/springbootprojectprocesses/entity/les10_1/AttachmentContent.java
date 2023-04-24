package uz.pdp.springbootprojectprocesses.entity.les10_1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AttachmentContent {
    // MAHSULOTNING RASMINI DB DA SAQLASH uchun AttachmentContent.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String  name;

    private byte[]  bytes;

    @OneToOne
    private Attachment attachment;

}
