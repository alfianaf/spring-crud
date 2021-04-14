package com.alfian.latihanspring.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PendidikanDto {
    private String kodePendidikan;
    private String jenjang;
    private String institusi;
    private String username;
}
