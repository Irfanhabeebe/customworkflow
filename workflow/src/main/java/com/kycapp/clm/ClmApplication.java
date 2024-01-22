package com.kycapp.clm;

import java.util.List;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;

import com.kycapp.clm.businessPartner.entity.Individual;
import com.kycapp.clm.businessPartner.repository.BusinessPartnerRepository;
import com.kycapp.clm.businessPartner.repository.IndividualRepository;
import com.kycapp.clm.workflow.entity.CaseType;
import com.kycapp.clm.workflow.entity.StageConfig;
import com.kycapp.clm.workflow.entity.Task;
import com.kycapp.clm.workflow.entity.TaskConfig;
import com.kycapp.clm.workflow.service.ICaseService;
import com.kycapp.clm.workflow.service.ICaseTypeService;
import com.kycapp.clm.workflow.service.IStageConfigService;
import com.kycapp.clm.workflow.service.ITaskConfigService;

import lombok.AllArgsConstructor;

@EnableScheduling
@SpringBootApplication
@AllArgsConstructor
public class ClmApplication implements CommandLineRunner {


	ICaseTypeService caseTypeService;
	IStageConfigService stageConfigService;
	ITaskConfigService taskConfigService;
	ICaseService caseService;
	BusinessPartnerRepository businessPartnerRepository;
	IndividualRepository individualRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CaseType> caseTypes = List.of(new CaseType("Onboarding"));
		Individual individual = new Individual();
		individual.setName("Irfan habee");
		individual.setFirstName("Irfan");
		//individual.setPartnerType("Individual");
		businessPartnerRepository.save(individual);
		Individual individual1 = new Individual();
		individual1.setName("Irshad E");
		individual1.setFirstName("Irshad");
		individualRepository.save(individual1);

		for (CaseType caseType : caseTypes) {
			caseType = caseTypeService.save(caseType);
			List<StageConfig> stageConfigs = List.of(new StageConfig(caseType, "Initial data setup", 0));
			// new StageConfig(caseType,"New Data Capture",1));
			for (StageConfig stageConfig : stageConfigs) {

				stageConfig = stageConfigService.save(stageConfig);
				List <TaskConfig> taskConfigs = List.of( new TaskConfig.Builder("Retrieve data from SAP")
				.description("Retrieve data from SAP")
				.build());
				
						//new TaskConfig(stageConfig, "Retrieve data from SAP", "com.kycapp.clm.executers.RetreiveData", 1),
					//	new TaskConfig(stageConfig, "Publish Message", "com.kycapp.clm.executers.PublishMessage", 2));

				for (TaskConfig taskConfig : taskConfigs) {
					taskConfig = taskConfigService.save(taskConfig);

				}
			}
		}
		//for (int i = 0; i < 1000; i++) {
			caseService.startWorkflow(individual,1);
			caseService.startWorkflow(individual1,1);
		//}

	}
}
