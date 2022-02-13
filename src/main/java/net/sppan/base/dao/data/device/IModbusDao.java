package net.sppan.base.dao.data.device;

import net.sppan.base.entity.data.Device;
import net.sppan.base.entity.data.ModbusDevice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IModbusDao extends IDeviceDao {


    @Override
    @Query(nativeQuery = true,value = "select * FROM tb_device_modbus order by `time` desc  limit :num")
    List<ModbusDevice> findNewest(@Param("num") int num);
}
