package com.example.thiscompany.request;

import com.example.thiscompany.model.OfficeLocation;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfficeReturnRQ {

    private Long id;

    private OfficeLocation location;

}
