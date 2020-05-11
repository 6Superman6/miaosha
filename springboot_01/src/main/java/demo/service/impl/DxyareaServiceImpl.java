package demo.service.impl;


import demo.model.Dxyarea;
import demo.service.DxyareaService;
import demo.service.base.BaseServiceImpl;
import demo.utils.BigDecimalUtil;
import demo.utils.ServerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class DxyareaServiceImpl extends BaseServiceImpl<Dxyarea> implements DxyareaService {


    @Override
    public ServerResponse insert(Dxyarea dxyarea) {
        return null;
    }

    @Override
    public ServerResponse delete(int id) {
        return null;
    }

    @Override
    public ServerResponse update(Dxyarea dxyarea) {
        return null;
    }

    @Override
    public ServerResponse get(int id) {
        Dxyarea dxyarea = dxyareaMapper.selectByPrimaryKey(id);
        System.out.println(dxyarea);
        System.out.println(ServerResponse.createBySuccess(dxyarea));
        return ServerResponse.createBySuccess(dxyarea);
    }

    @Override
    public ServerResponse findAll() {
//        return ServerResponse.createBySuccess(dxyareaMapper.findAll());
        return null;
    }

    @Override
    public int getCountById(int id) {
        return 0;
    }

    @Override
    public ServerResponse getyName(String name) {
        return null;
    }



    @Override
    public int getConfirmedPeople(int count) {
        int cnt = 0;
        List<Dxyarea> list = null;
        list = dxyareaMapper.findAll(count);
        if(!list.isEmpty())
        {
            list=getList(list);
            for(Dxyarea dxyarea : list)
            {
                cnt = cnt + Integer.valueOf(dxyarea.getProvinceConfirmedcount()).intValue();
            }
        }
        return cnt;
    }

    @Override
    public int getsuspectedPeople(int count) {
        int cnt = 0;
        List<Dxyarea> list = null;
        list = dxyareaMapper.findAll(count);
        if(!list.isEmpty())
        {
            list=getList(list);
            for(Dxyarea dxyarea : list)
            {
                cnt = cnt + Integer.valueOf(dxyarea.getProvinceSuspectedcount()).intValue();
            }
        }
        return cnt;
    }

    @Override
    public int getCuredPeople(int count) {
        int cnt = 0;
        List<Dxyarea> list = null;
        list = dxyareaMapper.findAll(count);
        if(!list.isEmpty())
        {
            list=getList(list);
            for(Dxyarea dxyarea : list)
            {
                cnt = cnt + Integer.valueOf(dxyarea.getProvinceCuredcount()).intValue();
            }
        }
        return cnt;
    }

    @Override
    public int getDeadPeople(int count) {
        int cnt = 0;
        List<Dxyarea> list = null;
        list = dxyareaMapper.findAll(count);
        if(!list.isEmpty())
        {
            list=getList(list);
            for(Dxyarea dxyarea : list)
            {
                cnt = cnt + Integer.valueOf(dxyarea.getProvinceDeadcount()).intValue();
            }
        }
        return cnt;
    }

    private ArrayList<Dxyarea> getList(List<Dxyarea> arr) {

        List<Dxyarea> list = new ArrayList<Dxyarea>();

        Iterator it = arr.iterator();

        while (it.hasNext()) {

            Dxyarea obj = (Dxyarea) it.next();

            if (!list.contains(obj)) {                //不包含就添加

                list.add(obj);
            }
        }
        return (ArrayList<Dxyarea>) list;
    }

    @Override
    public List<Dxyarea> AreaList(int count) {
        List<Dxyarea> list = null;
        list = dxyareaMapper.findAll(count);
        int cnt = 0;
        cnt = dxyareaMapper.getConfirmedPeople(count);
        int cntsupect = 0;
        cntsupect = dxyareaMapper.getSuspectedPeople(count);
        int cntcure = 0;
        cntcure = dxyareaMapper.getCuredPeople(count);
        int cntdead = 0;
        cntdead = dxyareaMapper.getDeadPeople(count);

        if(!list.isEmpty())
        {
            list=getList(list);
            List<Dxyarea> dxyareaList = new ArrayList<Dxyarea>();
            for(Dxyarea dxyarea : list)
            {
//                System.out.println(Double.valueOf(dxyarea.getProvinceConfirmedcount())+" * "+(double) cnt );
                String percent = BigDecimalUtil.div(Double.valueOf(dxyarea.getProvinceConfirmedcount()),(double) cnt).toString();
                String supected = "0.0000%";
                String cure = BigDecimalUtil.div(Double.valueOf(dxyarea.getProvinceCuredcount()),(double) cntcure).toString();
                String dead = BigDecimalUtil.div(Double.valueOf(dxyarea.getProvinceDeadcount()),(double) cntdead).toString();
                dxyarea.setPrecent(percent+"%");
                dxyarea.setSupectedPercent(supected);
                dxyarea.setCuredPercent(cure+"%");
                dxyarea.setDeadPercent(dead+"%");
                dxyareaList.add(dxyarea);
            }
            return dxyareaList;
        }
        return list;
    }

}
