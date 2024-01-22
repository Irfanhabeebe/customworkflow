package com.kycapp.clm.fileProcess.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.kycapp.clm.fileProcess.dto.KycRefreshFileDto;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FileProcessorService {

    // FileProcessorConfig fileProcessorConfig;
    Environment environment;
    private RabbitTemplate rabbitTemplate;

    public void processKycRefreshFile() {
        String filePath = environment.getProperty("kycRereshFile.path");
        String fileName = environment.getProperty("kycRereshFile.name");
        String archiveFolderPath = environment.getProperty("kycRefreshArchival.path");
        Path sourcePath = Paths.get(filePath, fileName);
        if (Files.exists(sourcePath)) {
            try {
                // Process the file
                List<KycRefreshFileDto> kycRefreshFileDtos = mapKycFileToDto(filePath + fileName);
                kycRefreshFileDtos.stream().forEach(kycRefreshFileDto -> rabbitTemplate
                        .convertAndSend("KycRefreshFileProcessQueue", kycRefreshFileDto));
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                String archivedFileName = "archive_" + timestamp + "_" + sourcePath.getFileName();
                Path destinationPath = Paths.get(archiveFolderPath, archivedFileName);
                Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

                // Additional logic if needed after processing and moving the file
            } catch (IOException e) {
                // Handle exception
                e.printStackTrace();
            }
        }
    }

    public List<KycRefreshFileDto> mapKycFileToDto(String filePath) throws IOException {
        List<KycRefreshFileDto> dtoList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Parse the line and create DTO objects, then add them to the list
                KycRefreshFileDto dto = parseDTOFromLine(line);
                if (dto.getRecordType().equals("D")) {
                    dtoList.add(dto);
                }
            }
        }
        return dtoList;
    }

    public KycRefreshFileDto parseDTOFromLine(String line) {
        String[] parts = line.split("\\|");
        KycRefreshFileDto dto = new KycRefreshFileDto();
        dto.setRecordType(parts[0].trim());
        if (parts[0].trim().equals("D")) {
            String[] cifNumberParts = parts[1].split("\\+");
            dto.setCifNumber(cifNumberParts[1].trim());
            if (!parts[2].isBlank() && !parts[2].isEmpty()) {
                cifNumberParts = parts[2].split("+");
                dto.setParentCifNumber(cifNumberParts[1].trim());
            }
            dto.setBusinessPartnerName(parts[3].trim());
            dto.setPartyTypeCode(parts[4].trim());
            dto.setPartyType(parts[5].trim());
            dto.setPartySubType(parts[6].trim());
            dto.setBusinessUnit(parts[7].trim());
            dto.setRiskRating(parts[8].trim());
            dto.setFirstName(parts[9].trim());
            dto.setLastName(parts[10].trim());
            dto.setMiddleName(parts[11].trim());
            dto.setDirestCustFlag(parts[12].trim());
        }

        return dto;
    }

}
