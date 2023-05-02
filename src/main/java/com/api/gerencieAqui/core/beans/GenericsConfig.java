package com.api.gerencieAqui.core.beans;

import com.api.gerencieAqui.core.generic.filter.GenericSpec;
import com.api.gerencieAqui.core.generic.model.GenericEntity;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericsConfig {

    @Bean
    public GenericSpec<?> genericSpec(){
        return new EspecificacaoGenerica();
    }

    static class EspecificacaoGenerica extends GenericSpec<ObjetoGenerico>{

    }

    static class ObjetoGenerico implements GenericEntity {

        @Override
        public UUID getId() {
            return null;
        }
        // @Override
        // public String getCodigo() {
        //     return null;
        // }
        // @Override
        // public void setCodigo(String codigo) {

        // }
        @Override
        public String getName() {
            return null;
        }
    }
}
