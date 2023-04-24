package uz.pdp.springbootprojectprocesses.entity.template;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@Data
@MappedSuperclass       // Classs ni Super Class sifatida ko'rsin
public abstract class AbsUUIDEntity extends AbsMainEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    // @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;  // UUID Long dan ham uzun bolsa

    /*
    // UUID ning Type i
    @Id
    @GeneratedValue(generator = "uuid2")
    @Type(type = "org.hibernate.PostgresUUIDType") ??
    @GenericGenerator(name="uuid2",strategy = "org.hibernate.uuid.UUIDGenerator")
    private UUID uuid;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private UUID uuid;


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", insertable = false, updatable = false, nullable = false)
    private UUID id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="uuid-char")
    @Column(name="id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private String id;
    */
}
