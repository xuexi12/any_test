package com.test.module.service.impl;

import com.test.module.exception.RemoteAccessException;
import com.test.module.service.RemoteService;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RemoteServiceImpl implements RemoteService {

    @Override
    @Retryable(retryFor = RemoteAccessException.class)
    public String testRemote(int tag) {
        System.out.println("testRemote：" + tag);
        if (tag > 0) {
            throw new RemoteAccessException("远程调用异常");
        }

        return "remote";
    }

    @Recover
    public String recover(RemoteAccessException e) {
        // 恢复操作
        return "recover";
    }
}
