package net.sppan.base.entity.monitor;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sppan.base.entity.support.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_device_warn")
@DynamicInsert()
public class DeviceMonitor extends BaseEntity {

    private static final long serialVersionUID = -2501187332312275742L;

    public DeviceMonitor(String data) {

    }

    @Id
    int id;

    String uid;

    String proto;

    String msg;

    Timestamp time;

    String extra;

    public DeviceMonitor() {

    }
}
