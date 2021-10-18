package com.example.thiscompany.request;

import com.example.thiscompany.model.OfficeLocation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OfficeCreationRQ {

    @Enumerated(EnumType.STRING)
    private OfficeLocation location;
}
