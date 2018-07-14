package com.zhenghao.alerts;

import com.zhenghao.domain.Spittle;

public interface AlertService {
    void sendSpittleAlert(Spittle spittle);
    Spittle receiveSpittleAlert();
}
