package net.sppan.base.controller.admin.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sppan.base.controller.BaseController;
import net.sppan.base.service.system.IRoleService;
import net.sppan.base.service.system.IUserService;

@Controller
@RequestMapping("/admin/honeyed")
public class HoneyController extends BaseController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/honeyed/index";
    }

}
