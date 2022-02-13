package net.sppan.base.controller.admin.monitor;


import net.sppan.base.entity.data.Device;
import net.sppan.base.entity.data.ModbusDevice;
import net.sppan.base.entity.monitor.DeviceMonitor;
import net.sppan.base.service.monitor.IDeviceMonitorService;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/warn")
@RequiresGuest
public class DeviceMonitorController {

    @Autowired
    IDeviceMonitorService iDeviceMonitorService;

    @RequestMapping(value = {"/write"})
    public String save(@RequestParam String data) {
        DeviceMonitor monitor = new DeviceMonitor(data);
        iDeviceMonitorService.save(monitor);
        System.out.println(data);
        return "admin/honeyed/index";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DeviceMonitor> listAll() {
        return iDeviceMonitorService.findAll();
    }

}
