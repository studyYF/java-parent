package com.crossyf.practice.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.NumberUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Created by YangFan.
 * @date 2019/11/11
 * 功能:
 */
@Slf4j
@RestController
@RequestMapping(value = "/hutool/")
public class HomeController {

    @RequestMapping("home")
    public ModelAndView home() {

        return new ModelAndView("");
    }

    public static void main(String[] args) {

        //克隆 暂时未用到

        //类型转换 Convert.toXX(xx,xx) 第一个参数为object 第二个为转换失败返回的默认值
        long[] b = {1, 2, 3, 4, 5};

        //转换为字符串
        String bStr = Convert.toStr(b);
        System.out.println(bStr);

        //转换为日期
        String date = "2019-11-01";
        Date date1 = Convert.toDate(date,new Date());
        System.out.println(date1);
        //转换为数组
        Object[] a = {"ni", 1, "好"};
        List<?> list = Convert.toList(a);
        System.out.println(list);

//        List<String> list1 = Convert.convert(new TypeReference<List<String>>() {}, a);
//        System.out.println(list1);

        //时间单位转换
        long c = 5643223;
        long minutes = Convert.convertTime(c, TimeUnit.MILLISECONDS,TimeUnit.MINUTES);
        System.out.println(minutes);


        long hour  = Convert.convertTime(minutes, TimeUnit.MINUTES,TimeUnit.HOURS);
        System.out.println(hour);


        //金额大小写转换
        double a1 = 5433.22;
        String daxie = Convert.digitToChinese(a1);
        System.out.println(daxie);


        //日期工具 DateUtil
        Date date2 = new Date();
        String date3 = DateUtil.formatDate(date2);
        System.out.println(date3);

        String date4 = DateUtil.now();
        String today = DateUtil.today();
        System.out.println(date4);
        System.out.println(today);


        double value = NumberUtil.round(NumberUtil.mul(23,5.8932),2).doubleValue();
        Console.log(value);

    }
}
