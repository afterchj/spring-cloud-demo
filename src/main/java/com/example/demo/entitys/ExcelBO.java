package com.example.demo.entitys;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.example.demo.convert.LocalDateTimeConverter;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class ExcelBO implements Serializable {


    @ExcelProperty(value = "编码", index = 0)
    private String orderId;

    @ExcelProperty(value = "名称", index = 1)
    private String dishName;

    @ExcelProperty(value = "价格", index = 2)
    private BigDecimal dishPrice;

    @ExcelProperty(value = "数量", index = 3)
    private Integer dishNumber;

    @ColumnWidth(value = 20)
    @ExcelProperty(value = "创建时间", converter = LocalDateTimeConverter.class,index = 4)
    private LocalDateTime createTime = LocalDateTime.now();
}
