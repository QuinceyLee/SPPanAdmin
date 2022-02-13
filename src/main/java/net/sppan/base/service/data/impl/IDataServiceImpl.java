package net.sppan.base.service.data.impl;

import com.google.common.collect.Maps;
import net.sppan.base.common.enums.UploadDataType;
import net.sppan.base.dao.data.device.IDeviceDao;
import net.sppan.base.dao.data.device.IModbusDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.data.Device;
import net.sppan.base.service.data.IDataService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IDataServiceImpl extends BaseServiceImpl<Device, Integer> implements IDataService {

    @Autowired
    IModbusDao iModbusDao;

    IDeviceDao iDeviceDao;


    Map<Integer, IBaseDao<Device, Integer>> daoMap = Maps.newHashMap();

    @PostConstruct
    private void initMap() {
        daoMap = new HashMap<Integer, IBaseDao<Device, Integer>>() {
            {
                put(UploadDataType.MODBUS.getDataType(), iModbusDao);
            }
        };
    }


    @Override
    public IBaseDao<Device, Integer> getBaseDao() {
        return iDeviceDao;
    }


    @Override
    public void save(Device device, int type) {
        initDao(type);
        this.save(device);
    }

    @Override
    public List<? extends Device> findNewest(int type, int num) {
        return initDao(type).findNewest(num);
    }

    private IDeviceDao initDao(int type) {
        iDeviceDao = (IDeviceDao) daoMap.get(type);
        return iDeviceDao;
    }
}
