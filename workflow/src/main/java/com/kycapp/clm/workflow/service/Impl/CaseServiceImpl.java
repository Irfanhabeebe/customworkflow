package com.kycapp.clm.workflow.service.Impl;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kycapp.clm.businessPartner.entity.BusinessPartner;
import com.kycapp.clm.workflow.entity.Case;
import com.kycapp.clm.workflow.entity.CaseType;
import com.kycapp.clm.workflow.entity.Stage;
import com.kycapp.clm.workflow.entity.StageConfig;
import com.kycapp.clm.workflow.entity.Task;
import com.kycapp.clm.workflow.entity.TaskConfig;
import com.kycapp.clm.workflow.mapper.CaseMapper;
import com.kycapp.clm.workflow.mapper.StageMapper;
import com.kycapp.clm.workflow.mapper.TaskMapper;
import com.kycapp.clm.workflow.repository.CaseRepository;
import com.kycapp.clm.workflow.repository.StageRepository;
import com.kycapp.clm.workflow.repository.TaskRepository;
import com.kycapp.clm.workflow.service.ICaseService;
import com.kycapp.clm.workflow.service.ICaseTypeService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CaseServiceImpl implements ICaseService{


    ICaseTypeService caseTypeService;
    CaseRepository caseRepository;
    StageRepository stageRepository;
    TaskRepository taskRepository;
    CaseMapper caseMapper;
    StageMapper stageMapper;
    TaskMapper taskMapper;
    private Queue queue;
	private RabbitTemplate rabbitTemplate;

    @Transactional
    public void startWorkflow(BusinessPartner businessPartner,int caseTypeId) {
        
        CaseType caseType = caseTypeService.get(caseTypeId);
        Case case1 = caseMapper.mapToCase(caseType);
        case1.setBusinessPartner(businessPartner);
        caseRepository.save(case1);

        for (StageConfig stageConfig : caseType.getCaseStageConfigs()) {
            Stage stage = stageMapper.mapToStage(stageConfig, case1);
            stageRepository.save(stage);

            boolean firstTask = true;
            for (TaskConfig taskConfig : stageConfig.getTaskConfigurations()) {
                Task task = taskMapper.mapToTask(taskConfig, stage);
                if ( firstTask ){
                    task.setTaskStatus(2);
                    firstTask=false;
                }
                taskRepository.save(task);
                if (task.getTaskOrder()==1 ){
                    rabbitTemplate.convertAndSend(queue.getName(), task);
                }
            }
        }       
    }
    
}
