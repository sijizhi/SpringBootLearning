package com.example.demo.controller;

import com.example.demo.entity.JsonData;
import com.example.demo.entity.TestSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@PropertySource({"classpath:application.properties"})//加载配置文件
public class FileController {

    @Value("${web.images-path}") //通过mapping注入值
    String path ;// "C:/Users/Administrator/Desktop/"

    @Autowired
    private TestSetting testSetting;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public JsonData upload(@RequestParam("access_file") MultipartFile file,
                           @RequestParam("name")String myname){
        System.out.println("姓名为："+myname);
        if(!file.isEmpty()){
            //获取原始名字
            String fileName=file.getOriginalFilename();
            System.out.println("文件名为："+fileName);
            String suffixName=fileName.substring(fileName.indexOf("."));
            System.out.println("文件后缀名是："+suffixName);
            //String path = "C:/Users/Administrator/Desktop/作业源/demo/src/main/resources/static/images/";
            path=path+"/";
            System.out.println("目录是："+path);
            fileName= UUID.randomUUID()+suffixName;
            System.out.println("修改后的名字："+fileName);
            File upload=new File(path+fileName);
            try {
                file.transferTo(upload);
                return  new JsonData(myname, upload.toString(), "0");
            }catch (IllegalStateException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return new JsonData("-1", "上传失败");
    }

    @RequestMapping("/getSetting")
    @ResponseBody
    public Object getSetting(){
        return testSetting;
    }


}
