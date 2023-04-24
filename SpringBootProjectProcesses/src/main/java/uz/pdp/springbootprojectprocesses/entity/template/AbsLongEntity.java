package uz.pdp.springbootprojectprocesses.entity.template;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass     // Classs ni Super Class sifatida ko'rsin
public abstract class AbsLongEntity extends AbsMainEntity{

    // UUID ning Type i
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

}
