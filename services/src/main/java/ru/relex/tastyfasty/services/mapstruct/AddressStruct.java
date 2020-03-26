package ru.relex.tastyfasty.services.mapstruct;

import org.mapstruct.Mapper;
import ru.relex.tastyfasty.db.model.Address;
import ru.relex.tastyfasty.services.dto.address.AddressDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressStruct {

    AddressDto toDto(Address address);

    Address fromDto(AddressDto addressDto);

    List<AddressDto> toDto(List<Address> addresses);

    List<Address> fromDto(List<AddressDto> addressDtos);
}
