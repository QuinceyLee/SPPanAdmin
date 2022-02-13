package net.sppan.base.service.data;

import net.sppan.base.entity.data.Device;
import net.sppan.base.service.support.IBaseService;

import java.util.List;

public interface IDataService extends IBaseService<Device, Integer> {

    void save(Device device, int type);

    List<? extends Device> findNewest(int type, int num);

}
