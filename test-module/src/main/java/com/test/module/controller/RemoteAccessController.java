package com.test.module.controller;

import com.test.module.service.RemoteService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remote")
public class RemoteAccessController {

    @Resource
    private RemoteService remoteService;

    @RequestMapping("/test")
    public String test(int tag) {
        return remoteService.testRemote(tag);
    }
}
