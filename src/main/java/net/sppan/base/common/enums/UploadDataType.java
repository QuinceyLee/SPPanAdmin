package net.sppan.base.common.enums;

import lombok.Getter;

@Getter
public enum UploadDataType {
    MODBUS(1,"modbus"),;


    final int dataType;
    final String name;

    UploadDataType(int dataType, String name) {
        this.dataType = dataType;
        this.name = name;
    }
}
