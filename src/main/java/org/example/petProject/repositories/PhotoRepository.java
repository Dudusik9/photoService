package org.example.petProject.repositories;

import org.example.petProject.entity.BaseResponse;
import org.example.petProject.entity.PhotoResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface PhotoRepository extends CrudRepository<PhotoResponse, Long> {

    Optional<PhotoResponse> findById(Long id);
}
