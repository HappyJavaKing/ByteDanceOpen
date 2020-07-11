package com.yyd.open.api.impl;

import cn.hutool.json.JSONUtil;
import com.yyd.open.api.IByteDanceOpenMiniProgramInfoService;
import com.yyd.open.api.IByteDanceOpenMiniProgramService;
import com.yyd.open.api.request.appinfo.AppQrCodeRequest;
import com.yyd.open.api.response.appinfo.AppInfoResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yangyidian
 * @date 2020/07/02
 **/
@Slf4j
public class ByteDanceOpenMiniProgramInfoServiceImpl implements IByteDanceOpenMiniProgramInfoService {

    private IByteDanceOpenMiniProgramService byteDanceOpenMiniProgramService;

    public ByteDanceOpenMiniProgramInfoServiceImpl(IByteDanceOpenMiniProgramService byteDanceOpenMiniProgramService) {
        this.byteDanceOpenMiniProgramService = byteDanceOpenMiniProgramService;
    }

    @Override
    public AppInfoResponse getAppInfo() {
        String response = byteDanceOpenMiniProgramService.get(APP_INFO_URL);
        return JSONUtil.toBean(response, AppInfoResponse.class);
    }

    @Override
    public byte[] getAppQrCode(AppQrCodeRequest request) {
        return byteDanceOpenMiniProgramService.post(APP_QRCODE_URL, request, byte[].class);
    }
}