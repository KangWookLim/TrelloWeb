package com.example.trelloweb.workspace.wsmem.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class WS_MEM_Pk implements Serializable {
    private String uservo;
    private Long WSID;
}
