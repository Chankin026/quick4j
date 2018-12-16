package com.chankin.ssms.core.genericService;

/**
 * 所有自定义枚举类型实现该接口
 **/
public interface GenericEnum {


    // 保存在数据库中的值
    public String getValue();


    //前端显示值
    public String getText();

}
