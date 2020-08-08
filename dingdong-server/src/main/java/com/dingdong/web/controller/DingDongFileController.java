package com.dingdong.web.controller;

import com.dingdong.domain.model.DingDongFile;
import com.dingdong.domain.query.DingDongFileQuery;
import com.dingdong.domain.vo.DingDongFileVO;
import com.dingdong.service.DingDongFileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件控制类
 *
 * @since 2020/8/3
 */
@RestController
@RequestMapping("file")
public class DingDongFileController {

    @Autowired
    private DingDongFileService dingDongFileService;

    @ApiOperation(value = "测试接口")
    @GetMapping("test")
    public String test(@RequestParam("aaa")String aaa)
    {
        return aaa;
    }

    @ApiOperation(value = "批量上传文件接口")
    @PostMapping("batch-upload")
    @ResponseBody
    public List<Long> upload(@RequestParam("uploadFileArray[]") MultipartFile[] uploadFileArray){
        return dingDongFileService.batchUpload(uploadFileArray);
    }

    @ApiOperation(value = "单文件文件上传接口")
    @PostMapping("{productId}/one-upload")
    @ResponseBody
    public Long upload(@RequestParam("file") MultipartFile file,
                       @PathVariable("productId")Long productId,
                       HttpServletRequest request){
        return dingDongFileService.oneUpload(productId,file, request);
    }

    @ApiOperation(value = "根据id查询")
    @GetMapping("{id}/load")
    public void load(@PathVariable("id") Long id, HttpServletResponse response){
        DingDongFile dingDongFile = dingDongFileService.load(id);

        //读取路径下面的文件
        File file = new File(new File(dingDongFile.getFilePath()).getAbsolutePath());
        if(!file.exists()){
            return;
        }
        try{
            //读取指定路径下面的文件
            InputStream in = new FileInputStream(file);
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            //创建存放文件内容的数组
            byte[] buff =new byte[1024];
            //所读取的内容使用n来接收
            int n;
            //当没有读取完时,继续读取,循环
            while((n=in.read(buff))!=-1){
                //将字节数组的数据全部写入到输出流中
                outputStream.write(buff,0,n);
            }
            //强制将缓存区的数据进行输出
            outputStream.flush();
            //关流
            outputStream.close();
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @ApiOperation(value = "根据商品id查询")
    @GetMapping("query-list")
    @ResponseBody
    public List<DingDongFileVO> queryList(DingDongFileQuery dingDongFileQuery){
        List<DingDongFile> dingDongFiles = dingDongFileService.queryList(dingDongFileQuery);

        List<DingDongFileVO> result = new ArrayList<>();
        String urlFix = "http://localhost:9090/file/";
        DingDongFileVO dongFileVO;
        for (DingDongFile dingDongFile : dingDongFiles) {
            dongFileVO = new DingDongFileVO();
            BeanUtils.copyProperties(dingDongFile,dongFileVO);
            String url = urlFix + dingDongFile.getId() + "/load";
            File file = new File(new File(dingDongFile.getFilePath()).getAbsolutePath());
            if(!file.exists()){
                continue;
            }
            dongFileVO.setUrl(url);
            result.add(dongFileVO);
        }

        return result;
    }


    @GetMapping(value = "aa",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public BufferedImage getImage() throws IOException {
        return ImageIO.read(new FileInputStream(new File("E:/img/1.jpg")));
    }



}
