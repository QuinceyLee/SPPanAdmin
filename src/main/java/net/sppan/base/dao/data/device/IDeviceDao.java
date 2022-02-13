package net.sppan.base.dao.data.device;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.data.Device;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface IDeviceDao extends IBaseDao<Device, Integer> {
    List<? extends Device> findNewest(int num);
}
