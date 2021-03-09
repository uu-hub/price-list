package com.bytecheng.mall.auth.service;

import com.bytecheng.mall.common.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther zmsoft
 * @Created 2021/3/3 21:35
 */
@FeignClient("mall-eden-admin")
@Service
public interface UmsAdminService {

    @GetMapping("/admin/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);
}
