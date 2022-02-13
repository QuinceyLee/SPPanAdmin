package net.sppan.base.dao.monitor;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.AttackedMsg;
import net.sppan.base.entity.monitor.DeviceMonitor;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeviceMonitorDao extends IBaseDao<DeviceMonitor,Integer> {
}
