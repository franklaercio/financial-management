package com.ufrn.financial.models.mappers;

import com.ufrn.financial.models.Person;
import com.ufrn.financial.models.dtos.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpf", source = "cpf", qualifiedByName = "removeCPFMask")
    Person createToModel(PersonDTO personDTO);

    @Mapping(target = "cpf", source = "cpf", qualifiedByName = "removeCPFMask")
    Person updateToModel(PersonDTO personDTO);

    @Mapping(target = "cpf", source = "cpf", qualifiedByName = "applyCPFMask")
    PersonDTO modelToDTO(Person person);

    @Named("removeCPFMask")
    default String removeCPFMask(String cpfComMascara) {
        return cpfComMascara.replaceAll("\\.|-", "");
    }

    @Named("applyCPFMask")
    default String applyCPFMask(String cpfSemMascara) {
        return cpfSemMascara.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
