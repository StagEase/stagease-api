package com.api.stagease.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UBSDTO extends AbstractDTO{
    private String nomeUBS;
    private String email;
    private List<AreaDTO> areas;

}
