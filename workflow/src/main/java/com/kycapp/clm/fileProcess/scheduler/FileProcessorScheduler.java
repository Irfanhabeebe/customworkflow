package com.kycapp.clm.fileProcess.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kycapp.clm.fileProcess.service.FileProcessorService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FileProcessorScheduler {

    private FileProcessorService fileProcessorService;

    // Run the scheduler every hour, you can adjust the cron expression based on your needs
    @Scheduled(fixedRate = 5000)
    public void processKYCRefreshFile() {
        fileProcessorService.processKycRefreshFile();
    }
}