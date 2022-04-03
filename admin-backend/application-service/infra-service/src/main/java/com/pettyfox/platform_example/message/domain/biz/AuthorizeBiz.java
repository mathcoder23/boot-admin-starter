package com.pettyfox.platform_example.message.domain.biz;


public interface AuthorizeBiz {

    String createToken(Long userId, String username);

    boolean checkToken(String token);
}
