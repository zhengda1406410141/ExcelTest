package upupoo.com.service.impl;

import jxl.Sheet;
import jxl.Workbook;
import org.springframework.stereotype.Service;
import upupoo.com.entity.ExcelEntity;
import upupoo.com.service.ExcellService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcellServiceImpl implements ExcellService {
    @Override
    public List<ExcelEntity> readExcel() {
        System.out.println("readExcel被调用");
            // 创建WorkBook对象
            Workbook workbook = null;
            try {
                workbook = Workbook.getWorkbook(new File("G:\\BaiduYunDownload\\test.xls"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 获取第一个Sheet
            Sheet sheet = workbook.getSheet(0);
            // 遍历数据 i = 行  j =列
            List<ExcelEntity> entityList = new ArrayList<>();

            for (int i = 0; i < 500; i++) {
                // 根据坐标为Entity属性赋值
                ExcelEntity excelEntity = new ExcelEntity();
                excelEntity.setName(sheet.getCell(0, i).getContents());
                excelEntity.setAge(Integer.parseInt(sheet.getCell(1, i).getContents()));
                excelEntity.setWorkAge(Integer.parseInt(sheet.getCell(2, i).getContents()));
                excelEntity.setWages(Integer.parseInt(sheet.getCell(3, i).getContents()));
                excelEntity.setPhone(Long.parseLong(sheet.getCell(4, i).getContents()));
                excelEntity.setEmail(sheet.getCell(5, i).getContents());
                entityList.add(excelEntity);
            }
            return entityList;
    }
}
