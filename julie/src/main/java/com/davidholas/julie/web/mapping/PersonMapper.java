package com.davidholas.julie.web.mapping;

import com.davidholas.julie.dto.PersonDto;
import com.davidholas.julie.persistence.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto mapToDto(Person person);

    Person mapToEntity(PersonDto dto);

    List<PersonDto> mapToDtoList(List<Person> persons);
}
