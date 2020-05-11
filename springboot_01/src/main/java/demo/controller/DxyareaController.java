package demo.controller;

import demo.service.DxyareaService;
import demo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class DxyareaController {

    @Autowired
    private DxyareaService dxyareaService;

    @RequestMapping("/do/{id}")
    public ServerResponse find(@PathVariable Integer id)
    {
        return dxyareaService.get(id);
    }

    @GetMapping("/hel")
    public String hello()
    {
        return "index";
    }

    public Model box(Model model,int count)
    {
        model.addAttribute("cnt1","全国确诊人数："+dxyareaService.getConfirmedPeople(count));
        model.addAttribute("cnt2","全国疑似人数："+dxyareaService.getsuspectedPeople(count));
        model.addAttribute("cnt3","全国治愈人数："+dxyareaService.getCuredPeople(count));
        model.addAttribute("cnt4","全国死亡人数："+dxyareaService.getDeadPeople(count));
        model.addAttribute("dxyarealist",dxyareaService.AreaList(count));
        return model;
    }

    // 获取全国确认数量
    @GetMapping("/count")
    public String count(Model model)
    {
        int count = getCount();
        model = box(model,count);
        model.addAttribute("cnt",0);
        model.addAttribute("day","2020-03-01");
        return "index";
    }

    // 前一天
    @RequestMapping("/before")
    public String before(Model model,@RequestParam("cnt") int cnt,@RequestParam("day") String day)
    {
        int count = getCount();
        cnt = cnt + 1;
        count = count + cnt;
        model = box(model,count);
        model.addAttribute("cnt",cnt);
        model.addAttribute("day",addOneDay(day,-1));
        System.out.println("before: "+count+" cnt: "+cnt);
        return "index";
    }

    // 后一天
    @RequestMapping("/after")
    public String after(Model model,@RequestParam("cnt") int cnt,@RequestParam("day") String day)
    {
        int count = getCount();
//        System.out.println(count);
        cnt = cnt -1;
        if(cnt<0)
        {
            cnt = 0;
        }
        count = count + cnt;
        model = box(model,count);
        model.addAttribute("cnt",cnt);
        model.addAttribute("day",addOneDay(day,1));
        System.out.println("after: "+count+" cnt: "+cnt);
        return "index";
    }

    public String addOneDay(String time,int day) {
        String add = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date timeNow = df.parse(time);
            Calendar begin = Calendar.getInstance();
            begin.setTime(timeNow);
            begin.add(Calendar.DAY_OF_MONTH, day);
            add = df.format(begin.getTime());
            return add;
        } catch (Exception e) {

        }
        return add;

    }

    public int getCount() {
        int count = 0;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String time = df.format(new Date());
            Date date1 = df.parse(time);
            String time2 = "2020-03-01";
            Date date2 = df.parse(time2);
            long l = (date1.getTime()-date2.getTime())/1000/60/60/24;
            count = (int)l;
        } catch (Exception e) {

        }
        return count;

    }

    public static void main(String[] args)
    {
//        String add = null;
//        try {
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//            Date timeNow = df.parse("2020-03-01");
//            Calendar begin = Calendar.getInstance();
//            begin.setTime(timeNow);
//            begin.add(Calendar.DAY_OF_MONTH, -1);
//            add = df.format(begin.getTime());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        int count = 0;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String time = df.format(new Date());
            Date date1 = df.parse(time);
            String time2 = "2020-03-02";
            Date date2 = df.parse(time2);
            long l = (date1.getTime()-date2.getTime())/1000/60/60/24;
            count = (int)l;
            System.out.println(count);

        } catch (Exception e) {

        }

    }

}
