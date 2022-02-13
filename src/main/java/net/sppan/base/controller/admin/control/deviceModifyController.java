package net.sppan.base.controller.admin.control;


import net.sppan.base.entity.data.Device;
import net.sppan.base.entity.data.ModbusDevice;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Collections;

@Controller
@RequestMapping("/control")
@RequiresGuest
public class deviceModifyController {

    @Resource
    RestTemplate restTemplate;

    @RequestMapping(value = {"/write"})
    public void save(@RequestParam String data) {
        String url = "http://localhost:2890/in";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_PLAIN);
        httpHeaders.setAccept(Collections.singletonList(MediaType.ALL));
        httpHeaders.setConnection("keep-alive");
        HttpEntity<String> entity = new HttpEntity<>(data, httpHeaders);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        System.out.println(response.getBody());
    }

}
