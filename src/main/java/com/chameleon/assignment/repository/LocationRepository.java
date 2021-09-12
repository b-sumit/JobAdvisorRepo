package com.chameleon.assignment.repository;

import com.chameleon.assignment.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

  @Query("select location.id from LocationEntity location where location.name IN ?1")
  List<Integer> fetchLocationEntities(List<String> locations);

}
