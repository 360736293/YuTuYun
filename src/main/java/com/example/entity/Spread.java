package com.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spread {

    @ExcelProperty("uid")
    private String uid;

    @ExcelProperty("wechat_user_id")
    private String wechat_user_id;

    @ExcelProperty("uuid")
    private String uuid;

    @ExcelProperty("account")
    private String account;

    @ExcelProperty("real_name")
    private String real_name;

    @ExcelProperty("sex")
    private Integer sex;

    @ExcelProperty("birthday")
    private String birthday;

    @ExcelProperty("card_id")
    private String card_id;

    @ExcelProperty("mark")
    private String mark;

    @ExcelProperty("label_id")
    private List<Integer> label_id;

    @ExcelProperty("group_id")
    private Integer group_id;

    @ExcelProperty("nickname")
    private String nickname;

    @ExcelProperty("phone")
    private String phone;

    @ExcelProperty("province_id")
    private Integer province_id;

    @ExcelProperty("city_id")
    private Integer city_id;

    @ExcelProperty("addres")
    private String addres;

    @ExcelProperty("cancel_time")
    private String cancel_time;

    @ExcelProperty("create_time")
    private String create_time;

    @ExcelProperty("last_time")
    private String last_time;

    @ExcelProperty("last_ip")
    private String last_ip;

    @ExcelProperty("now_money")
    private String now_money;

    @ExcelProperty("brokerage_price")
    private String brokerage_price;

    @ExcelProperty("status")
    private Integer status;

    @ExcelProperty("spread_uid")
    private Integer spread_uid;

    @ExcelProperty("spread_time")
    private String spread_time;

    @ExcelProperty("spread_limit")
    private String spread_limit;

    @ExcelProperty("brokerage_level")
    private Integer brokerage_level;

    @ExcelProperty("user_type")
    private String user_type;

    @ExcelProperty("promoter_time")
    private String promoter_time;

    @ExcelProperty("is_promoter")
    private Integer is_promoter;

    @ExcelProperty("main_uid")
    private Integer main_uid;

    @ExcelProperty("pay_count")
    private Integer pay_count;

    @ExcelProperty("pay_price")
    private String pay_price;

    @ExcelProperty("spread_count")
    private Integer spread_count;

    @ExcelProperty("spread_pay_count")
    private Integer spread_pay_count;

    @ExcelProperty("spread_pay_price")
    private String spread_pay_price;

    @ExcelProperty("integral")
    private Integer integral;

    @ExcelProperty("member_level")
    private Integer member_level;

    @ExcelProperty("member_value")
    private Integer member_value;

    @ExcelProperty("count_start")
    private Integer count_start;

    @ExcelProperty("count_fans")
    private Integer count_fans;

    @ExcelProperty("count_content")
    private Integer count_content;

    @ExcelProperty("is_svip")
    private Integer is_svip;

    @ExcelProperty("svip_endtime")
    private String svip_endtime;

    @ExcelProperty("svip_save_money")
    private String svip_save_money;

    @ExcelProperty("is_all")
    private Integer is_all;

    @ExcelProperty("group_uid")
    private Integer group_uid;

    @ExcelProperty("old_spread_uid")
    private Integer old_spread_uid;

    @ExcelProperty("real_spread_uid")
    private Integer real_spread_uid;

    @ExcelProperty("up_one_uid")
    private Integer up_one_uid;

    @ExcelProperty("free_money")
    private String free_money;

    @ExcelProperty("used_assign_num")
    private Integer used_assign_num;

    @ExcelProperty("subbranch_id")
    private Integer subbranch_id;
}
