package com.example.demo.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.demo.entitys.ExcelBO;
import com.example.demo.handler.ExcelMergeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;


@Slf4j
@Component
public class EasyExcelUtil {


    public static void writerMergeToWeb(HttpServletResponse response, String excelName, int mergeRowIndex, int[] mergeColumeIndex, List<ExcelBO> list) throws Exception {

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        excelName = URLEncoder.encode(excelName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + excelName + ExcelTypeEnum.XLSX.getValue());

        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).registerWriteHandler(new ExcelMergeHandler(mergeRowIndex, mergeColumeIndex)).build();

        try {
            //先执行合并策略
            if (!CollectionUtils.isEmpty(list)) {
                //进行写入操作
                WriteSheet sheetWriter = EasyExcel.writerSheet().head(ExcelBO.class).build();
                excelWriter.write(list, sheetWriter);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出订单失败，{}", e.getMessage());
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    public static void writerMergeToFile(String excelName, int mergeRowIndex, int[] mergeColumeIndex, List<ExcelBO> list)  {
        ExcelWriter excelWriter = EasyExcel.write(new File("e:\\" + excelName)).registerWriteHandler(new ExcelMergeHandler(mergeRowIndex, mergeColumeIndex)).build();
        try {
            //先执行合并策略
            if (!CollectionUtils.isEmpty(list)) {
                //进行写入操作
                WriteSheet sheetWriter = EasyExcel.writerSheet().head(ExcelBO.class).build();
                excelWriter.write(list, sheetWriter);
            }

        } catch (Exception e) {
            log.error("导出订单失败，{}", e.getMessage());
            e.printStackTrace();
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
}
