package me.aikin.bicyclestore.bicycle.api;

import lombok.extern.slf4j.Slf4j;
import me.aikin.bicyclestore.bicycle.api.playload.BicycleResponse;
import me.aikin.bicyclestore.bicycle.security.principal.CurrentUser;
import me.aikin.bicyclestore.bicycle.security.principal.UserPrincipal;
import me.aikin.bicyclestore.bicycle.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/bicycles")
public class BicycleController {

    @Autowired
    private BicycleService bicycleService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<BicycleResponse> bicycles(@CurrentUser UserPrincipal currentUser) {
        return bicycleService.getBicycleResponses();
    }


}
