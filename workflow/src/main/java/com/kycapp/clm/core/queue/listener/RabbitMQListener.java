package com.kycapp.clm.core.queue.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.kycapp.clm.fileProcess.dto.KycRefreshFileDto;
import com.kycapp.clm.integration.service.ProcessFileRecord;
import com.kycapp.clm.workflow.entity.Task;
import com.kycapp.clm.workflow.service.ITaskService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class RabbitMQListener {

    ITaskService taskService;
    ProcessFileRecord processFileRecord; 

    @RabbitListener(queues = "TaskProcessQueue")
    public void processMessage(Task task) {
       // System.out.println("Received Message: " + task.toString());
        taskService.processTaskAsync(task);
    }

    @RabbitListener(queues = "KycRefreshFileProcessQueue")
    public void processKycRefreshFileRecord(KycRefreshFileDto kycRefreshFileDto) {
       //System.out.println("Received Message: " + kycRefreshFileDto.getBusinessPartnerName());
        //taskService.processTaskAsync(task);
        processFileRecord.processKycRefreshRecord(kycRefreshFileDto);
    }
}

