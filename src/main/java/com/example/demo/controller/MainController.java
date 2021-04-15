package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.entitys.ExcelBO;
import com.example.demo.utils.EasyExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws Exception {

        //需要合并的列
        int[] mergeColumeIndex = {0, 1, 2, 3, 4, 5, 6, 7};
        // 从那一行开始合并
        int mergeRowIndex = 1;

        List<ExcelBO> list = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtfOrder = DateTimeFormatter.ofPattern("yyyyMMdd");
        String excelName = dtf.format(LocalDate.now());
        String prefix = dtfOrder.format(LocalDate.now());
        for (int i = 1; i < 11; i++) {
            ExcelBO order = new ExcelBO();
            order.setOrderId(prefix + i % 4);
            order.setDishNumber(i % 10);
            order.setDishPrice(new BigDecimal(i));
            order.setDishName("测试" + i);
            list.add(order);
        }
        System.out.println(JSON.toJSONString(list));

        list = list.stream().sorted(Comparator.comparing(ExcelBO::getOrderId)).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(list));

        EasyExcelUtil.writerMergeToWeb(response, excelName, mergeRowIndex, mergeColumeIndex, list);

    }

}
