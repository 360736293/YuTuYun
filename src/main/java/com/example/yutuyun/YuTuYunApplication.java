package com.example.yutuyun;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.alibaba.fastjson.JSONObject;
import com.example.converter.ListIntegerConverter;
import com.example.entity.Spread;
import com.example.entity.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class YuTuYunApplication implements ApplicationRunner {

    private final Log log = LogFactory.get();
    private final String loginUrl = "https://tv.ytuy.cn/mer/login";
    private final String queryUrl = "https://tv.ytuy.cn/mer/province/user/list";
    private final int pageNum = 80;
    private String token;
    private int page;
    private final List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(YuTuYunApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        login();
        queryPageNum();
        queryData();
        outputExcel();
    }

    private void login() {
        JSONObject loginResultJsonObject;
        Scanner scanner = new Scanner(System.in);
        do {
            log.info("请输入账号：");
            String account = scanner.nextLine();
            log.info("请输入密码：");
            String password = scanner.nextLine();
            if (ObjectUtil.isEmpty(account) || ObjectUtil.isEmpty(password)) {
                log.info("账号或密码为空，请重新输入");
                continue;
            }
            log.info("开始登录系统");
            String loginResult = HttpRequest
                    .post(loginUrl)
                    .form("account", account)
                    .form("password", password)
                    .form("code", "")
                    .form("captchaVerification", "")
                    .execute()
                    .body();
            loginResultJsonObject = JSONObject.parseObject(loginResult);
            int loginStatus = loginResultJsonObject.getIntValue("status");
            if (loginStatus != 200) {
                log.error(loginResultJsonObject.getString("message"));
            } else {
                break;
            }
        } while (true);
        token = loginResultJsonObject.getJSONObject("data").getString("token");
        log.info("登录成功");
    }

    private void queryPageNum() {
        String numResult = HttpRequest
                .get(queryUrl)
                .header("X-Token", token)
                .form("page", 1)
                .form("limit", 1)
                .execute()
                .body();
        JSONObject numResultJsonObject = JSONObject.parseObject(numResult);
        int status = numResultJsonObject.getIntValue("status");
        if (status != 200) {
            log.error(numResultJsonObject.getString("message"));
        }
        Double num = numResultJsonObject.getJSONObject("data").getDouble("count");
        page = (int) Math.ceil(num / pageNum);
        log.info("共 " + page + " 页记录，每页 " + pageNum + "条");
    }

    private void queryData() throws InterruptedException {
        for (int i = 1; i <= page; i++) {
            for (int time = 1; time <= 4; time++) {
                try {
                    log.info("开始查询第 " + i + " 页记录");
                    String result = HttpRequest
                            .get(queryUrl)
                            .header("X-Token", token)
                            .form("page", i)
                            .form("limit", pageNum)
                            .execute()
                            .body();
                    JSONObject resultJsonObject = JSONObject.parseObject(result);
                    int status = resultJsonObject.getIntValue("status");
                    if (status != 200) {
                        log.error(resultJsonObject.getString("message"));
                    }
                    List<User> newUserList = resultJsonObject.getJSONObject("data").getJSONArray("list").toJavaList(User.class);
                    userList.addAll(newUserList);
                    log.info("第 " + i + " 页记录查询完毕，等待 2 秒");
                    Thread.sleep(2000);
                    break;
                } catch (Exception e) {
                    log.error("第 " + i + " 页记录查询出错");
                    if (time == 4) {
                        throw new RuntimeException(e.getCause());
                    } else {
                        log.info("等待 " + 5 * time + " 秒后开始重试第 " + time + " 次，共 " + 3 + " 次");
                        Thread.sleep(5000 * time);
                    }
                }
            }
        }
    }

    private void outputExcel() {
        log.info("开始输出Excel");
        String yyyyMMddHHmmss = DateUtil.format(DateUtil.date(), "yyyyMMddHHmmss");
        String file = ".\\钰兔云" + yyyyMMddHHmmss + ".xlsx";
        for (User user : userList) {
            Spread spread = user.getSpread();
            if (ObjectUtil.isEmpty(spread)) {
                continue;
            }
            user.setSecond_uid(spread.getUid());
            user.setSecond_wechat_user_id(spread.getWechat_user_id());
            user.setSecond_uuid(spread.getUuid());
            user.setSecond_account(spread.getAccount());
            user.setSecond_real_name(spread.getReal_name());
            user.setSecond_sex(spread.getSex());
            user.setSecond_birthday(spread.getBirthday());
            user.setSecond_card_id(spread.getCard_id());
            user.setSecond_mark(spread.getMark());
            user.setSecond_label_id(spread.getLabel_id());
            user.setSecond_group_id(spread.getGroup_id());
            user.setSecond_nickname(spread.getNickname());
            user.setSecond_phone(spread.getPhone());
            user.setSecond_province_id(spread.getProvince_id());
            user.setSecond_city_id(spread.getCity_id());
            user.setSecond_addres(spread.getAddres());
            user.setSecond_cancel_time(spread.getCancel_time());
            user.setSecond_create_time(spread.getCreate_time());
            user.setSecond_last_time(spread.getLast_time());
            user.setSecond_last_ip(spread.getLast_ip());
            user.setSecond_now_money(spread.getNow_money());
            user.setSecond_brokerage_price(spread.getBrokerage_price());
            user.setSecond_status(spread.getStatus());
            user.setSecond_spread_uid(spread.getSpread_uid());
            user.setSecond_spread_time(spread.getSpread_time());
            user.setSecond_spread_limit(spread.getSpread_limit());
            user.setSecond_brokerage_level(spread.getBrokerage_level());
            user.setSecond_user_type(spread.getUser_type());
            user.setSecond_promoter_time(spread.getPromoter_time());
            user.setSecond_is_promoter(spread.getIs_promoter());
            user.setSecond_main_uid(spread.getMain_uid());
            user.setSecond_pay_count(spread.getPay_count());
            user.setSecond_pay_price(spread.getPay_price());
            user.setSecond_spread_count(spread.getSpread_count());
            user.setSecond_spread_pay_count(spread.getSpread_pay_count());
            user.setSecond_spread_pay_price(spread.getSpread_pay_price());
            user.setSecond_integral(spread.getIntegral());
            user.setSecond_member_level(spread.getMember_level());
            user.setSecond_member_value(spread.getMember_value());
            user.setSecond_count_start(spread.getCount_start());
            user.setSecond_count_fans(spread.getCount_fans());
            user.setSecond_count_content(spread.getCount_content());
            user.setSecond_is_svip(spread.getIs_svip());
            user.setSecond_svip_endtime(spread.getSvip_endtime());
            user.setSecond_svip_save_money(spread.getSvip_save_money());
            user.setSecond_is_all(spread.getIs_all());
            user.setSecond_group_uid(spread.getGroup_uid());
            user.setSecond_old_spread_uid(spread.getOld_spread_uid());
            user.setSecond_real_spread_uid(spread.getReal_spread_uid());
            user.setSecond_up_one_uid(spread.getUp_one_uid());
            user.setSecond_free_money(spread.getFree_money());
            user.setSecond_used_assign_num(spread.getUsed_assign_num());
            user.setSecond_subbranch_id(spread.getSubbranch_id());
        }
        ExcelWriter excelWriter = EasyExcel.write(file).registerConverter(new ListIntegerConverter()).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();
        WriteSheet writeSheet;
        writeSheet = EasyExcel.writerSheet("用户信息").head(User.class).build();
        excelWriter.write(userList, writeSheet);
        excelWriter.finish();
        log.info("输出Excel完毕，路径：" + file);
    }
}
