package com.example.demo;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.example.demo.entitys.ExcelBO;
import com.example.demo.utils.EasyExcelUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class MainTest {


    @Test
    public void test() throws InterruptedException {

        //需要合并的列
        int[] mergeColumeIndex = {0,1,2,3,4,5};
        // 从那一行开始合并
        int mergeRowIndex = 1;

        List<ExcelBO> list = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtfOrder = DateTimeFormatter.ofPattern("yyyyMMdd");
        String excelName = dtf.format(LocalDate.now()) + ExcelTypeEnum.XLSX.getValue();
        String prefix = dtfOrder.format(LocalDate.now());
        for (int i = 1; i < 11; i++) {
            ExcelBO order = new ExcelBO();
            order.setOrderId(prefix + i % 4);
            order.setDishNumber(i % 10);
            order.setDishPrice(new BigDecimal(i));
            order.setDishName("测试" + i);
            list.add(order);
//            Thread.sleep(3000);
        }
//        System.out.println(JSON.toJSONString(list));

//        Collections.sort(list, ((o1, o2) -> o1.getOrderId().compareTo(o2.getOrderId())));
        list = list.stream().sorted(Comparator.comparing(ExcelBO::getOrderId)).collect(Collectors.toList());

        EasyExcelUtil.writerMergeToFile(excelName, mergeRowIndex, mergeColumeIndex, list);

//        System.out.println(JSON.toJSONString(list));
    }

}
