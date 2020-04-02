package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.address.AddressDto;

import javax.validation.Valid;
import java.util.List;

public interface IAddressService {

    List<AddressDto> findAddresses(String search);

    AddressDto findAddressById(int addressId);

    AddressDto create(@Valid AddressDto addressDto);

    AddressDto update(@Valid AddressDto addressDto);

    void remove(int addressId);
}
