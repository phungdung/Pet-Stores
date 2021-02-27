package com.myproject.business;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.common.utils.DataUtil;
import com.myproject.data.dto.ManagerDTO;
import com.myproject.repository.ManagerRepository;
import com.myproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ManagerBusinessImpl implements ManagerBusiness {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public ManagerDTO findManagerById(Long managerId) {
        log.info("findManagerById", managerId);
        return managerRepository.findManagerById(managerId);
    }

//    @Override
//    public ResultInsideDTO insertEmployee(EmployeeDTO employeeDTO) {
//        log.info("insertEmployee", employeeDTO);
//        return employeeRepository.insertEmployee(employeeDTO);
//    }
//
//    @Override
//    public ResultInsideDTO updateMemberInfo(MemberDTO memberDTO) {
//        log.info("updateMemberInfo", memberDTO);
//        return memberRepository.updateMemberInfo(memberDTO);
//    }
//
    @Override
    public ResultInsideDTO deleteById(String checkInputSearch, Long managerId) {
        log.info("deleteManagerById", managerId);
        if (!DataUtil.isNullOrEmpty(checkInputSearch) && "1".equals(checkInputSearch)) {
            return managerRepository.deleteManagerById(managerId);
        }
        return memberRepository.deleteMemberById(managerId);
    }

    @Override
    public Datatable getDatatable(ManagerDTO managerDTO) {
        log.info("getDatatable", managerDTO);
        if (!DataUtil.isNullOrEmpty(managerDTO)) {
            if (!DataUtil.isNullOrEmpty(managerDTO.getCheckInputSearch()) && "1".equals(managerDTO.getCheckInputSearch())) {
                return managerRepository.getDatatableManager(managerDTO);
            } else {
                return memberRepository.getDatatable(managerDTO);
            }
        }
        return new Datatable();
    }

//    @Override
//    public List<Map<String, Object>> getListEmployeeMap() {
//        log.info("getListEmployeeMap");
//        return employeeRepository.getListEmployeeMap();
//    }
//
//    @Override
//    public List<EmployeeDTO> getListDataExport(EmployeeDTO employeeDTO) {
//        log.info("getListDataExport", employeeDTO);
//        return employeeRepository.getListDataExport(employeeDTO);
//    }
//
//    @Override
//    public File exportData(EmployeeDTO employeeDTO) throws Exception {
//        List<EmployeeDTO> employeeDTOList = employeeRepository.getListDataExport(employeeDTO);
//        return exportTemplate(employeeDTOList, "EXPORT");
//    }
//
//    private File exportTemplate(List<EmployeeDTO> dtoList, String key) throws Exception {
//        String fileNameOut;
//        String subTitle = null;
//        String sheetName = I18n.getLanguage("language.employee.title");
//        String title = I18n.getLanguage("language.employee.title");
//        List<ConfigFileExport> fileExportList = new ArrayList<>();
//        List<ConfigHeaderExport> headerExportList;
//        if ("RESULT_IMPORT".equalsIgnoreCase(key)) {
//            headerExportList = readerHeaderSheet("code"
//                    , "username"
//                    , "fullName"
//                    , "email"
//                    , "birthday"
//                    , "gender"
//                    , "address");
//            fileNameOut = "EMPLOYEE_RESULT_IMPORT";
//        } else {
//            headerExportList = readerHeaderSheet("code"
//                    , "username"
//                    , "fullName"
//                    , "email"
//                    , "birthday"
//                    , "gender"
//                    , "address");
//            fileNameOut = "EMPLOYEE_EXPORT";
//            subTitle = String.valueOf(new Date());
//        }
//        Map<String, String> fieldSplit = new HashMap<>();
//        ConfigFileExport configFileExport = new ConfigFileExport(
//                dtoList,
//                sheetName,
//                title,
//                subTitle,
//                7,
//                3,
//                9,
//                true,
//                "language.employee",
//                headerExportList,
//                fieldSplit,
//                "",
//                I18n.getLanguage("language.common.firstLeftHeaderTitle"),
//                I18n.getLanguage("language.common.secondLeftHeaderTitle"),
//                I18n.getLanguage("language.common.firstRightHeaderTitle"),
//                I18n.getLanguage("language.common.secondRightHeaderTitle"));
//        configFileExport.setLangKey("i18n/vi");
//        List<CellConfigExport> lstCellSheet = new ArrayList<>();
//        CellConfigExport cellSheet;
//        cellSheet = new CellConfigExport(7,
//                0,
//                0,
//                "OK",
//                "HEAD",
//                "STRING");
//        lstCellSheet.add(cellSheet);
//        configFileExport.setLstCreateCell(lstCellSheet);
//        fileExportList.add(configFileExport);
//        //cấu hình đường dẫn
//        String fileTemplate = "template" + File.separator + "TEMPLATE_EXPORT.xlsx";
//        String rootPath = "tempFolder" + File.separator;
//        File fileExport = CommonExport.exportExcel(
//                fileTemplate,
//                fileNameOut,
//                fileExportList,
//                rootPath,
//                new String[]{}
//        );
//        return fileExport;
//    }
//
//    private List<ConfigHeaderExport> readerHeaderSheet(String... col) {
//        List<ConfigHeaderExport> configHeaderExports = new ArrayList<>();
//        for (int i = 0; i < col.length; i++) {
//            configHeaderExports.add((new ConfigHeaderExport(col[i]
//                    , "LEFT"
//                    , false
//                    , 0
//                    , 0
//                    , new String[]{}
//                    , new String[]{}
//                    , "STRING")));
//        }
//        return configHeaderExports;
//    }

}
