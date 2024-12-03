package com.example.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @ExcelProperty("uid")
    private String uid;

    @ExcelProperty("nickname")
    private String nickname;

    @ExcelProperty("real_name")
    private String real_name;

    @ExcelProperty("phone")
    private String phone;

    @ExcelProperty("is_svip")
    private String is_svip;

    @ExcelProperty("group_id")
    private String group_id;

    @ExcelProperty("label_id")
    private List<Integer> label_id;

    @ExcelProperty("member_level")
    private String member_level;

    @ExcelProperty("推广人数")
    private Integer promoteCount;

    @ExcelProperty("spread_uid")
    private Integer spread_uid;

    @ExcelProperty("label")
    private String label;

    @ExcelProperty("belong")
    private String belong;

    @ExcelProperty("is_small_store")
    private Boolean is_small_store;

    @ExcelProperty("promoters")
    private String promoters;

    //**********************************************************************************
    @ExcelIgnore
    private Spread spread;
    //**********************************************************************************

    @ExcelProperty("uid")
    private String second_uid;

    @ExcelProperty("wechat_user_id")
    private String second_wechat_user_id;

    @ExcelProperty("uuid")
    private String second_uuid;

    @ExcelProperty("account")
    private String second_account;

    @ExcelProperty("real_name")
    private String second_real_name;

    @ExcelProperty("sex")
    private Integer second_sex;

    @ExcelProperty("birthday")
    private String second_birthday;

    @ExcelProperty("card_id")
    private String second_card_id;

    @ExcelProperty("mark")
    private String second_mark;

    @ExcelProperty("label_id")
    private List<Integer> second_label_id;

    @ExcelProperty("group_id")
    private Integer second_group_id;

    @ExcelProperty("nickname")
    private String second_nickname;

    @ExcelProperty("phone")
    private String second_phone;

    @ExcelProperty("province_id")
    private Integer second_province_id;

    @ExcelProperty("city_id")
    private Integer second_city_id;

    @ExcelProperty("addres")
    private String second_addres;

    @ExcelProperty("cancel_time")
    private String second_cancel_time;

    @ExcelProperty("create_time")
    private String second_create_time;

    @ExcelProperty("last_time")
    private String second_last_time;

    @ExcelProperty("last_ip")
    private String second_last_ip;

    @ExcelProperty("now_money")
    private String second_now_money;

    @ExcelProperty("brokerage_price")
    private String second_brokerage_price;

    @ExcelProperty("status")
    private Integer second_status;

    @ExcelProperty("spread_uid")
    private Integer second_spread_uid;

    @ExcelProperty("spread_time")
    private String second_spread_time;

    @ExcelProperty("spread_limit")
    private String second_spread_limit;

    @ExcelProperty("brokerage_level")
    private Integer second_brokerage_level;

    @ExcelProperty("user_type")
    private String second_user_type;

    @ExcelProperty("promoter_time")
    private String second_promoter_time;

    @ExcelProperty("is_promoter")
    private Integer second_is_promoter;

    @ExcelProperty("main_uid")
    private Integer second_main_uid;

    @ExcelProperty("pay_count")
    private Integer second_pay_count;

    @ExcelProperty("pay_price")
    private String second_pay_price;

    @ExcelProperty("spread_count")
    private Integer second_spread_count;

    @ExcelProperty("spread_pay_count")
    private Integer second_spread_pay_count;

    @ExcelProperty("spread_pay_price")
    private String second_spread_pay_price;

    @ExcelProperty("integral")
    private Integer second_integral;

    @ExcelProperty("member_level")
    private Integer second_member_level;

    @ExcelProperty("member_value")
    private Integer second_member_value;

    @ExcelProperty("count_start")
    private Integer second_count_start;

    @ExcelProperty("count_fans")
    private Integer second_count_fans;

    @ExcelProperty("count_content")
    private Integer second_count_content;

    @ExcelProperty("is_svip")
    private Integer second_is_svip;

    @ExcelProperty("svip_endtime")
    private String second_svip_endtime;

    @ExcelProperty("svip_save_money")
    private String second_svip_save_money;

    @ExcelProperty("is_all")
    private Integer second_is_all;

    @ExcelProperty("group_uid")
    private Integer second_group_uid;

    @ExcelProperty("old_spread_uid")
    private Integer second_old_spread_uid;

    @ExcelProperty("real_spread_uid")
    private Integer second_real_spread_uid;

    @ExcelProperty("up_one_uid")
    private Integer second_up_one_uid;

    @ExcelProperty("free_money")
    private String second_free_money;

    @ExcelProperty("used_assign_num")
    private Integer second_used_assign_num;

    @ExcelProperty("subbranch_id")
    private Integer second_subbranch_id;
}
