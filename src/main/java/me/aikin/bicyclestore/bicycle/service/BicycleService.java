package me.aikin.bicyclestore.bicycle.service;

import me.aikin.bicyclestore.bicycle.api.playload.BicycleResponse;
import me.aikin.bicyclestore.bicycle.domain.Bicycle;
import me.aikin.bicyclestore.bicycle.repository.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BicycleService {

    @Autowired
    private BicycleRepository bicycleRepository;

    public List<BicycleResponse> getBicycleResponses() {
        List<Bicycle> bicycles = bicycleRepository.findAll();
        return bicycles.stream()
            .map(bicycle -> BicycleResponse.builder()
                .name(bicycle.getName())
                .description(bicycle.getDescription())
                .build()
            )
            .collect(Collectors.toList());
    }

}
