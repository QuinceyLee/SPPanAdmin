package net.sppan.base.controller.admin.data;


import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.sppan.base.common.enums.UploadDataType;
import net.sppan.base.entity.data.Device;
import net.sppan.base.entity.data.ModbusDevice;
import net.sppan.base.service.data.IDataService;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/data")
@RequiresGuest
public class DataController {


    @Autowired
    IDataService iDataService;

    @RequestMapping(value = {"/save"})
    public String save(@RequestParam("data") String data) {
        Device device = new ModbusDevice(data);
        int id = 1;
        iDataService.save(device, id);
        System.out.println(data);
        return "admin/honeyed/index";
    }

    @RequestMapping(value = {"/read"},method = RequestMethod.GET)
    @ResponseBody
    public String read(@RequestParam int type, @RequestParam int num) {
        List<? extends Device> deviceList = iDataService.findNewest(type,num);

        System.out.println();

        return null;
    }

}
