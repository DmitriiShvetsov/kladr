package com.test.kladr.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Kladr {
    
    private Long id;

    private Long codeKladr;

    private Long codeRegion;

    private Long indexPost;

    private Long codeOkato;

    private Long codeTax;

    private String address;

}