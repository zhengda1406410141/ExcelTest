package upupoo.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import upupoo.com.entity.ExcelEntity;
import upupoo.com.service.ExcellService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("excel")
public class ExcelController {

    @Resource
    private ExcellService excellService;

    @RequestMapping("index")
    public String getDate(Model model){
        List<ExcelEntity> entityList = excellService.readExcel();
        model.addAttribute("list", entityList);
        return "/list.jsp";
    }

    @RequestMapping("test")
    @ResponseBody
    public String TestProject(){
        return "hello world";
    }

    @RequestMapping("getData")
    @ResponseBody
    public List<ExcelEntity> getData(Model model){
        System.out.println("getData被调用");
        List<ExcelEntity> entityList = excellService.readExcel();
        model.addAttribute("entitys", entityList);
        return entityList;
    }
}
