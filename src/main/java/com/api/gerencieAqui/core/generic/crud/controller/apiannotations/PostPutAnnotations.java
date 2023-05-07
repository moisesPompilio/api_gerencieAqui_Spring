package com.api.gerencieAqui.core.generic.crud.controller.apiannotations;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public interface PostPutAnnotations<InputModel, OutputModel> {

    @PostMapping
    public OutputModel salvar(@RequestBody @Valid InputModel inputModel);

    @PostMapping("salvarLista")
    public List<OutputModel> salvarLista(@RequestBody @Valid List<InputModel> inputModel);

    @PutMapping("/{id}")
    public OutputModel atualizar(@PathVariable String id, @RequestBody @Valid InputModel inputModel);

    @PatchMapping("/{id}")
    public OutputModel atualizarParcial(@PathVariable String id, @RequestBody HashMap<String, Object> fields);

}
