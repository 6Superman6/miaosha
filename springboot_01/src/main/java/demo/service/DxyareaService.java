package demo.service;

import demo.model.Dxyarea;
import demo.service.base.BaseService;

import java.util.List;

public interface DxyareaService extends BaseService<Dxyarea> {

    //确诊人数
    int getConfirmedPeople(int count);

    //疑似人数
    int getsuspectedPeople(int count);

    //治愈人数
    int getCuredPeople(int count);

    //死亡人数
    int getDeadPeople(int count);

    // 各省情况
    List<Dxyarea> AreaList(int count);

}
