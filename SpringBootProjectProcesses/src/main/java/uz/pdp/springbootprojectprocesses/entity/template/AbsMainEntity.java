package uz.pdp.springbootprojectprocesses.entity.template;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass     // Classs ni Super Class sifatida ko'rsin
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsMainEntity {


    @Column(updatable = false, nullable = false)
    @CreationTimestamp  // Object yaratildan vaqtni avtomatik oladi
    private Timestamp createdAt;


    @UpdateTimestamp
    private Timestamp updatedAt;

    // SecurityContexholderda kim bölib , AbstractEntity dan voris olgan
    // Class ni kim yaratgan bölsa shu yerga Id si chiqadi
    @JoinColumn(updatable = false)       // User Classni özimiz yaratganimiz uchun Column emas JoinColumn böladi
    @ManyToOne(fetch = FetchType.LAZY)   // Bir komentni 2-3 kishi yozishi mumkin
    private User createdBy;

    // @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User updatedBy;
}
