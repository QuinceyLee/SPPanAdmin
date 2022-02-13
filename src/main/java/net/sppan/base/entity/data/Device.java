package net.sppan.base.entity.data;

import net.sppan.base.entity.support.BaseEntity;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;


@MappedSuperclass
@DynamicInsert
public class Device extends BaseEntity{

    @Id
    int deviceId;

    Timestamp time;

    public Device() {
    }

    public Device(String data) {
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }
}
