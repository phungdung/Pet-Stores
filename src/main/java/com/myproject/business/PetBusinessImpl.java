package com.myproject.business;

import com.myproject.common.CommonExport;
import com.myproject.common.I18n;
import com.myproject.common.config.CellConfigExport;
import com.myproject.common.config.ConfigFileExport;
import com.myproject.common.config.ConfigHeaderExport;
import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.PetDTO;
import com.myproject.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Slf4j
@Service
public class PetBusinessImpl implements PetBusiness {
    @Autowired
    private PetRepository petRepository;

    @Override
    public PetDTO findPetById(Long petId) {
        log.info("findPetById", petId);
        return petRepository.findPetById(petId);
    }

    @Override
    public ResultInsideDTO insertPet(PetDTO petDTO) {
        log.info("insertPet", petDTO);
        return petRepository.insertPet(petDTO);
    }

    @Override
    public ResultInsideDTO updatePetInfo(PetDTO petDTO) {
        log.info("updatePetInfo", petDTO);
        return petRepository.updatePetInfo(petDTO);
    }

    @Override
    public ResultInsideDTO deletePetById(Long petId) {
        log.info("deletePetById", petId);
        return petRepository.deletePetById(petId);
    }

    @Override
    public Datatable getDatatablePet(PetDTO petDTO) {
        log.info("getDatatablePet", petDTO);
        return petRepository.getDatatablePet(petDTO);
    }


    @Override
    public File exportData(PetDTO petDTO) throws Exception {
        List<PetDTO> employeeDTOList = petRepository.getListDataExport(petDTO);
        return exportTemplate(employeeDTOList, "EXPORT");
    }

    private File exportTemplate(List<PetDTO> dtoList, String key) throws Exception {
        String fileNameOut;
        String subTitle = null;
        String sheetName = I18n.getLanguage("language.employee.title");
        String title = I18n.getLanguage("language.employee.title");
        List<ConfigFileExport> fileExportList = new ArrayList<>();
        List<ConfigHeaderExport> headerExportList;
        if ("RESULT_IMPORT".equalsIgnoreCase(key)) {
            headerExportList = readerHeaderSheet("code"
                    , "username"
                    , "fullName"
                    , "email"
                    , "birthday"
                    , "gender"
                    , "address");
            fileNameOut = "EMPLOYEE_RESULT_IMPORT";
        } else {
            headerExportList = readerHeaderSheet("code"
                    , "username"
                    , "fullName"
                    , "email"
                    , "birthday"
                    , "gender"
                    , "address");
            fileNameOut = "EMPLOYEE_EXPORT";
            subTitle = String.valueOf(new Date());
        }
        Map<String, String> fieldSplit = new HashMap<>();
        ConfigFileExport configFileExport = new ConfigFileExport(
                dtoList,
                sheetName,
                title,
                subTitle,
                7,
                3,
                9,
                true,
                "language.employee",
                headerExportList,
                fieldSplit,
                "",
                I18n.getLanguage("language.common.firstLeftHeaderTitle"),
                I18n.getLanguage("language.common.secondLeftHeaderTitle"),
                I18n.getLanguage("language.common.firstRightHeaderTitle"),
                I18n.getLanguage("language.common.secondRightHeaderTitle"));
        configFileExport.setLangKey("i18n/vi");
        List<CellConfigExport> lstCellSheet = new ArrayList<>();
        CellConfigExport cellSheet;
        cellSheet = new CellConfigExport(7,
                0,
                0,
                "OK",
                "HEAD",
                "STRING");
        lstCellSheet.add(cellSheet);
        configFileExport.setLstCreateCell(lstCellSheet);
        fileExportList.add(configFileExport);
        //cấu hình đường dẫn
        String fileTemplate = "template" + File.separator + "TEMPLATE_EXPORT.xlsx";
        String rootPath = "tempFolder" + File.separator;
        File fileExport = CommonExport.exportExcel(
                fileTemplate,
                fileNameOut,
                fileExportList,
                rootPath,
                new String[]{}
        );
        return fileExport;
    }

    private List<ConfigHeaderExport> readerHeaderSheet(String... col) {
        List<ConfigHeaderExport> configHeaderExports = new ArrayList<>();
        for (int i = 0; i < col.length; i++) {
            configHeaderExports.add((new ConfigHeaderExport(col[i]
                    , "LEFT"
                    , false
                    , 0
                    , 0
                    , new String[]{}
                    , new String[]{}
                    , "STRING")));
        }
        return configHeaderExports;
    }

}
