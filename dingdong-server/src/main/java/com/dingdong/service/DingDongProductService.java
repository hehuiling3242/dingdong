package com.dingdong.service;

import com.dingdong.domain.model.DingDongFile;
import com.dingdong.domain.model.DingDongProduct;
import com.dingdong.domain.query.DingDongFileQuery;
import com.dingdong.domain.query.DingDongProductQuery;
import com.dingdong.domain.vo.DingDongFileVO;
import com.dingdong.domain.vo.DingDongProductVO;
import com.dingdong.mapper.DingDongProductMapper;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DingDongProductService {

    @Autowired
    private DingDongProductMapper dingDongProductMapper;
    @Autowired
    private DingDongFileService fileService;

    public List<DingDongProductVO> queryList(DingDongProductQuery query){
        List<DingDongProduct> dingDongProducts = dingDongProductMapper.queryList(query);
        if(CollectionUtils.isEmpty(dingDongProducts)){
            return null;
        }

        List<DingDongProductVO> result = new ArrayList<>();
        DingDongProductVO dingDongProductVO;
        for (DingDongProduct dingDongProduct : dingDongProducts) {
            dingDongProductVO = new DingDongProductVO();
            BeanUtils.copyProperties(dingDongProduct,dingDongProductVO);
            result.add(dingDongProductVO);
        }
        Set<Long> productId = dingDongProducts.stream().filter(d -> null != d.getId()).map(DingDongProduct::getId).collect(Collectors.toSet());

        DingDongFileQuery dingDongFileQuery = new DingDongFileQuery();
        dingDongFileQuery.setProductIdArray(productId);
        List<DingDongFile> dingDongFiles = fileService.queryList(dingDongFileQuery);
        if(CollectionUtils.isEmpty(dingDongFiles)){
            return result;
        }

        Map<Long, List<DingDongFile>> longListMap = dingDongFiles.stream().filter(d -> null != d.getProductId()).collect(Collectors.groupingBy(DingDongFile::getProductId, Collectors.toList()));
        for (DingDongProductVO dongProductVO : result) {

            List<DingDongFile> dingDongFileList = longListMap.get(dongProductVO.getId());
            if(CollectionUtils.isEmpty(dingDongFileList)){
                continue;
            }

            List<String> filePaths = new ArrayList<>();
            String urlFix = "http://121.199.24.90:9090/file/";
            for (DingDongFile dingDongFile : dingDongFileList) {
                String url = urlFix + dingDongFile.getId() + "/load";
                File file = new File(new File(dingDongFile.getFilePath()).getAbsolutePath());
                if (!file.exists()) {
                    continue;
                }
                filePaths.add(url);
            }
            Set<Long> fileIdSet = dingDongFileList.stream().map(DingDongFile::getId).collect(Collectors.toSet());
            dongProductVO.setFileIdSet(fileIdSet);
            dongProductVO.setFilePaths(filePaths);
        }
        return result;
    }

    public DingDongProduct load(Long id){
        return dingDongProductMapper.load(id);
    }

    public void update(DingDongProduct dingDongProduct){
        dingDongProductMapper.update(dingDongProduct);
    }
}
