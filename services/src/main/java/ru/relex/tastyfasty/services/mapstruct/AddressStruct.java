package ru.relex.tastyfasty.services.mapstruct;

import ru.relex.tastyfasty.db.model.Address;
import ru.relex.tastyfasty.services.dto.address.AddressDto;

import java.util.List;

public interface AddressStruct {

    AddressDto toDto(Address address);

    Address fromDto(AddressDto addressDto);

    List<AddressDto> toDto(List<Address> addresses);

    List<Address> fromDto(List<AddressDto> addressDtos);
}
