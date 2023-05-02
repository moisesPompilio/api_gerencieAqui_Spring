package com.api.gerencieAqui.core.generic.model;

public interface DescriptiveEntity extends GenericEntity {

   String getDescricao();

   @Override
   default String getName(){
        return getDescricao();
    }

}
