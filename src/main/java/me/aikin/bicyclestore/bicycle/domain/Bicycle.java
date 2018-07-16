package me.aikin.bicyclestore.bicycle.domain;

import lombok.*;
import me.aikin.bicyclestore.bicycle.domain.audit.DateAudit;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BICYCLE")
public class Bicycle extends DateAudit {

    private static final long serialVersionUID = -5589625411078684936L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String description;

    private Double price;

    private Double stock;
}
