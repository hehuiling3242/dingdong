package com.dingdong.service;

import com.dingdong.domain.model.DingDongFile;
import com.dingdong.mapper.DingDongFileMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class DingDongFileService {

    private static final String FILE_PATH = "/dingdong/img/";

    @Autowired
    private DingDongFileMapper dingDongFileMapper;

    public void batchUpload(List<MultipartFile> uploadFile){

        if(CollectionUtils.isEmpty(uploadFile)){
            return;
        }

        for (MultipartFile multipartFile : uploadFile) {
            //文件名称
            String filename = multipartFile.getOriginalFilename();
            //上传后的文件名，防止文件名一样导致文件覆盖
            String uploadedName = this.getUploadedName(multipartFile.getOriginalFilename());
            //文件保存路径
            String filePath = FILE_PATH + uploadedName;
            new File(filePath).mkdir();
            File filef = new File(filePath);
            try {
                multipartFile.transferTo(filef);
                DingDongFile dingDongFile = new DingDongFile();
                dingDongFile.setFileName(filename);
                dingDongFile.setFilePath(filePath);
                dingDongFile.setUploadedName(uploadedName);
                dingDongFileMapper.insert(dingDongFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void oneUpload(MultipartFile file, HttpServletRequest request){
        //文件名称
        String filename = file.getOriginalFilename();
        //上传后的文件名，防止文件名一样导致文件覆盖
        String uploadedName = this.getUploadedName(file.getOriginalFilename());
        //文件保存路径

        String filePath = FILE_PATH + uploadedName;

        File filef = new File(new File(FILE_PATH).getAbsolutePath()+ "/" + uploadedName);
        if (!filef.getParentFile().exists()) {
            boolean mkdirs = filef.getParentFile().mkdirs();
        }
        try {
            file.transferTo(filef);
            DingDongFile dingDongFile = new DingDongFile();
            dingDongFile.setFileName(filename);
            dingDongFile.setFilePath(filePath);
            dingDongFile.setUploadedName(uploadedName);
            dingDongFileMapper.insert(dingDongFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void load(Long id){
        DingDongFile dingDongFile = dingDongFileMapper.load(id);

        byte [] bytes = null;
        ServletOutputStream sos =null;// 将图像输出到Servlet输出流中。
        try {
            GetImageRes getImageRes = acctManager.getImageBytes(dingDongFile.getFilePath());
            bytes = getImageRes.getFilebyte();

            ByteArrayInputStream in = new ByteArrayInputStream(bytes);    //将b作为输入流；
            BufferedImage image = ImageIO.read(in);

            resp.setHeader("Pragma", "no-cache");
            resp.setHeader("Cache-Control", "no-cache");
            resp.setDateHeader("Expires", 0);
            sos = resp.getOutputStream();// 将图像输出到Servlet输出流中。
            ImageIO.write(image, "jpeg", sos);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    /**
     * 上传之后的名称
     *
     * @param fileOriginalName
     */
    public String getUploadedName(String fileOriginalName) {
        UUID uuid = UUID.randomUUID();
        String fileUploadedName = uuid.toString()
                + StringUtils.substring(fileOriginalName, StringUtils.lastIndexOf(fileOriginalName, '.'));

        return fileUploadedName;
    }


}
