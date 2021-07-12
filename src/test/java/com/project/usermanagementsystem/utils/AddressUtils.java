package com.project.usermanagementsystem.utils;

import com.project.usermanagementsystem.api.dto.AddressDTO;
import com.project.usermanagementsystem.domain.model.Address;

public class AddressUtils {

    private static final String NUMBER = "100";
    private static final String ADDRESS = "Rua das Pipas";
    private static final String NEIGHBORHOOD = "Jatiúca";
    private static final String CITY = "Maceió";
    private static final String STATE = "Alagoas";
    private static final String POSTAL_CODE = "57039-800";
    private static final long ADDRESS_ID = 1L;

    public static AddressDTO createFakeDTO() {
        return AddressDTO.builder()
                .number(NUMBER)
                .address(ADDRESS)
                .neighborhood(NEIGHBORHOOD)
                .city(CITY)
                .state(STATE)
                .postalCode(POSTAL_CODE)
                .build();
    }

    public static Address createFakeEntity() {
        return Address.builder()
                .id(ADDRESS_ID)
                .number(NUMBER)
                .address(ADDRESS)
                .neighborhood(NEIGHBORHOOD)
                .city(CITY)
                .state(STATE)
                .postalCode(POSTAL_CODE)
                .build();

    }
}
