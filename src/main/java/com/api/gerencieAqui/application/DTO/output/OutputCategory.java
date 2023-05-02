package com.api.gerencieAqui.application.DTO.output;

import java.util.UUID;

import com.api.gerencieAqui.core.generic.model.DataTransferObject;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class OutputCategory implements DataTransferObject {
    private UUID id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String urlPhoto;
}
