package com.zhenghao.jms.alerts;

import com.zhenghao.domain.Spittle;

public interface AlertService {
    void sendSpittleAlert(Spittle spittle);
    Spittle receiveSpittleAlert();
}
