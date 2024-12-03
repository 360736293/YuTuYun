package com.example.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

import java.util.List;
import java.util.StringJoiner;

public class ListIntegerConverter implements Converter<List> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return List.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.NUMBER;
    }

    /**
     * 写（导出）数据时调用
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<List> context) {
        //这里是将List<Integer>转换为String类型数据，根据自己的数据进行处理
        StringJoiner joiner = new StringJoiner(",");
        for (Object data : context.getValue()) {
            joiner.add(String.valueOf(data));
        }
        //然后将转换后的String类型数据写入到Excel表格对应字段当中
        return new WriteCellData<>(joiner.toString());
    }

}
