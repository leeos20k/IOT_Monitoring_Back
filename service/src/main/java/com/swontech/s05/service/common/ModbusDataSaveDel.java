package com.swontech.s05.service.common;

import com.swontech.s05.service.repository.s052.S052030011Repository;
import com.swontech.s05.service.repository.s052.S052030062Repository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ModbusDataSaveDel {
    private final S052030062Repository repository;
    public ModbusDataSaveDel(S052030062Repository repository) {
        this.repository = repository;
    }

//    @Scheduled(cron = "0 0/10 * * * *")
    public void dataSaveDelete() {
        repository.CreateEnergyMinCollect();
        repository.CreateEnergyHourCollect();
        repository.CreateEnergyDayCollect();
        repository.DeletePump010();
        repository.DeleteSlave030();
    }



}
