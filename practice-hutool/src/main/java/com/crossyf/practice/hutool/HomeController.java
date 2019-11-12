package com.crossyf.practice.hutool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.system.SystemUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    @RequestMapping("excel")
    public void home(HttpServletResponse response, HttpServletRequest request) {
        try {
            //创建excel
            ExcelWriter excelWriter = ExcelUtil.getWriter(true);

            String fileName = "测试excel";
            String filename = fileName + ".xls";
            String lowerCase = request.getHeader("User-Agent").toLowerCase();
            if (lowerCase.indexOf("firefox") > 0) {
                filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");
            } else if (lowerCase.indexOf("MSIE") > 0) {
                filename = URLEncoder.encode(filename, "UTF-8");
            } else {
                filename = URLEncoder.encode(filename, "UTF-8");
            }
            List<String> supplierList = CollUtil.newArrayList("土豆供应商","上海其他供应商");
            List<Goods> goods = CollUtil.newArrayList();
            for (int i = 0; i < 2; i++) {
                Goods goods1 = new Goods();
                goods1.setCount(100 + i + "");
                goods1.setGoodsName(i + "");
                goods1.setUnitName("unit" + i);
                goods.add(goods1);
            }
            response.setContentType("application/msexcel");
            response.setHeader("content-Disposition", "attachment; fileName=" + filename);
            List<String> row1 = CollUtil.newArrayList("询价单单号：" + "3423");
            List<String> row2 = CollUtil.newArrayList("物料名称","采购数量","单位名称");
            for (String s : supplierList) {
                row2.add(s);
            }
            List<List<String>> rows = CollUtil.newArrayList(row1,row2,CollUtil.newArrayList());
            for (Goods good : goods) {
                List<String> row = CollUtil.newArrayList(good.getGoodsName(),good.getCount(),good.getUnitName());
                rows.add(row);
            }

            excelWriter.merge(2 + supplierList.size() * 6,"询价单");
            excelWriter.merge(1,1,0,2,row1,false);
            excelWriter.merge(2,3,0,0,row2,false);
            excelWriter.merge(2,3,1,1,row2,false);
            excelWriter.merge(2,3,2,2,row2,false);
            excelWriter.merge(2,2,3,8,row2,false);
            excelWriter.merge(2,2,9,14,"nihao",false);

            excelWriter.write(rows,true);
            excelWriter.flush(response.getOutputStream());

            excelWriter.close();

        } catch (RuntimeException | IOException e) {

        }
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
        Date date1 = Convert.toDate(date, new Date());
        System.out.println(date1);
        //转换为数组
        Object[] a = {"ni", 1, "好"};
        List<?> list = Convert.toList(a);
        System.out.println(list);

//        List<String> list1 = Convert.convert(new TypeReference<List<String>>() {}, a);
//        System.out.println(list1);

        //时间单位转换
        long c = 5643223;
        long minutes = Convert.convertTime(c, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
        System.out.println(minutes);


        long hour = Convert.convertTime(minutes, TimeUnit.MINUTES, TimeUnit.HOURS);
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


        double value = NumberUtil.round(NumberUtil.mul(23, 5.8932), 2).doubleValue();
        Console.log(value);

        Console.log(SystemUtil.getRuntimeInfo());

    }


}
