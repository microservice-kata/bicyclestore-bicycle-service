package me.aikin.bicyclestore.bicycle.repository;

import me.aikin.bicyclestore.bicycle.domain.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Long> {

}
