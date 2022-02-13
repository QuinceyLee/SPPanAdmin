package net.sppan.base.service.monitor.impl;

import net.sppan.base.dao.monitor.IDeviceMonitorDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.monitor.DeviceMonitor;
import net.sppan.base.service.monitor.IDeviceMonitorService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IDeviceMonitorServiceImpl extends BaseServiceImpl<DeviceMonitor,Integer> implements IDeviceMonitorService {


    @Autowired
    IDeviceMonitorDao iDeviceMonitorDao;

    @Override
    public IBaseDao<DeviceMonitor, Integer> getBaseDao() {
        return iDeviceMonitorDao;
    }
}
