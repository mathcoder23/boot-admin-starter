package com.pettyfox.platform_example.message.interfaces.facade;

import com.pettyfox.platform_example.message.domain.biz.AuthorizeBiz;
import com.pettyfox.platform_example.message.domain.biz.MessageConfigBiz;
import com.pettyfox.platform_example.message.domain.service.MessageSubscribeService;
import com.pettyfox.platform_example.message.interfaces.dto.SubscribeParamDTO;
import com.pettyfox.platform_example.message.interfaces.dto.vo.MessageConnectConfigVo;
import org.pettyfox.base.comm.web.RestObjectResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WebsocketConfigController extends BaseController {

    @Resource
    private AuthorizeBiz authorizeBiz;

    @Resource
    private MessageConfigBiz messageConfigBiz;

    @Resource
    private MessageSubscribeService messageSubscribeService;

    @PostMapping("/websocket/getConfig")
    public RestObjectResponse<MessageConnectConfigVo> getConfig() {
        MessageConnectConfigVo vo = new MessageConnectConfigVo();
        vo.setServerIp(messageConfigBiz.getWebsocketIp());
        vo.setProto(messageConfigBiz.getWebsocketProto());
        vo.setServerPort(messageConfigBiz.getWebsocketPort());
        vo.setUri("/message");
        vo.setToken(authorizeBiz.createToken(null, null));
        return RestObjectResponse.ok(vo);
    }

    @PostMapping("/websocket/subscribeMessage")
    public RestObjectResponse<String> subscribeMessage(@RequestBody SubscribeParamDTO dto) {
        messageSubscribeService.subscribeMessage(dto);
        return RestObjectResponse.ok("ok");
    }

    @PostMapping("/websocket/unsubscribeMessage")
    public RestObjectResponse<String> unsubscribeMessage(@RequestBody SubscribeParamDTO dto) {
        messageSubscribeService.unsubscribeMessage(dto);
        return RestObjectResponse.ok("ok");
    }
}
