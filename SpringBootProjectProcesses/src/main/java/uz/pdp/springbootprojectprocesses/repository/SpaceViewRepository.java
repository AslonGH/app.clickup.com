package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_2.SpaceView;
import uz.pdp.springbootprojectprocesses.payload.SpaceViewDto;

import java.util.List;
import java.util.UUID;

public interface SpaceViewRepository extends JpaRepository<SpaceView, UUID> {


    List<SpaceView> findAllBySpaceId(UUID space_id);


}
