package net.sppan.base.entity.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_device_modbus")
@DynamicInsert()
public class ModbusDevice extends Device {

    private String tag;

    private int modbusFunction;

    private String collectValue;

    private int startAddress;

    private int quantity;

    public ModbusDevice() {

    }


    public ModbusDevice(String data) {
        super(data);
        JSONObject modbusDevice = JSON.parseObject(data);
        this.deviceId = modbusDevice.getInteger("id");
        this.tag = modbusDevice.getString("tag");
        this.modbusFunction = modbusDevice.getInteger("function");
        this.collectValue = modbusDevice.getString("value");
        this.startAddress = modbusDevice.getInteger("address");
        this.quantity = modbusDevice.getInteger("quantity");
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
