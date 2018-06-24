package me.aikin.bicyclestore.bicycle.api;

import lombok.extern.slf4j.Slf4j;
import me.aikin.bicyclestore.bicycle.api.playload.BicycleResponse;
import me.aikin.bicyclestore.bicycle.security.principal.CurrentUser;
import me.aikin.bicyclestore.bicycle.security.principal.UserPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/bicycles")
public class BicycleController {

    @GetMapping
    public List<BicycleResponse> bicycles(@CurrentUser UserPrincipal currentUser) {
        BicycleResponse bicycleResponse = BicycleResponse.builder()
            .name(currentUser.getName())
            .build();

        return Arrays.asList(bicycleResponse);
    }
}
