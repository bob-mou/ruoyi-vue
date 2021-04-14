package com.ruoyi.service.service.impl;

import java.util.List;

import com.ruoyi.service.mapper.myClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.service.domain.myClass;
import com.ruoyi.service.mapper.MajorMapper;
import com.ruoyi.service.domain.Major;
import com.ruoyi.service.service.IMajorService;

/**
 * 专业管理Service业务层处理
 *
 * @author XD
 * @date 2021-04-09
 */
@Service
public class MajorServiceImpl implements IMajorService
{
    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private myClassMapper myClassMapper;
    /**
     * 查询专业管理
     *
     * @param majorId 专业管理ID
     * @return 专业管理
     */
    @Override
    public Major selectMajorById(Long majorId)
    {
        return majorMapper.selectMajorById(majorId);
    }

    /**
     * 查询专业管理列表
     *
     * @param major 专业管理
     * @return 专业管理
     */
    @Override
    public List<Major> selectMajorList(Major major)
    {
        return majorMapper.selectMajorList(major);
    }

    /**
     * 新增专业管理
     *
     * @param major 专业管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMajor(Major major)
    {
        int rows = majorMapper.insertMajor(major);
        insertmyClass(major);
        return rows;
    }

    /**
     * 修改专业管理
     *
     * @param major 专业管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMajor(Major major)
    {
        insertmyClass(major);
        return majorMapper.updateMajor(major);
    }

    /**
     * 批量删除专业管理
     *
     * @param majorIds 需要删除的专业管理ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMajorByIds(Long[] majorIds)
    {
        majorMapper.deletemyClassByMajorIds(majorIds);
        return majorMapper.deleteMajorByIds(majorIds);
    }

    /**
     * 删除专业管理信息
     *
     * @param majorId 专业管理ID
     * @return 结果
     */
    @Override
    public int deleteMajorById(Long majorId)
    {
        majorMapper.deletemyClassByMajorId(majorId);
        return majorMapper.deleteMajorById(majorId);
    }

    /**
     * 新增班级管理信息
     *
     * @param major 专业管理对象
     */
    public void insertmyClass(Major major)
    {
        //前端传过来的myclass类的集合
        List<myClass> myClassList = major.getmyClassList();
        myClass maj=new myClass();
        maj.setMajorId(major.getMajorId());
        //数据库里的所有myclass集合
        List<myClass> datalist=myClassMapper.selectmyClassList(maj);
        Long majorId = major.getMajorId();
        if (StringUtils.isNotNull(myClassList))
        {
            for(myClass my:datalist){
                //前端的majorList中不含数据库中的majorlist中的major对象，说明该major对象该从数据库中删除
                Boolean flag=false;
                for(int j=0;j<myClassList.size();j++){
                    //前端的集合包含数据库里的数据，就更新
                    if(myClassList.get(j).getClassId()!=null){
                        if(myClassList.get(j).getClassId().equals(my.getClassId())){
                            //更新数据库中当前myclass对象
                            myClassMapper.updatemyClass(myClassList.get(j));
                            break;
                        }
                    }
                    //数据库当前的myclass对象和前端比较完后，不包含，就删除数据库中的数据
                    else if(j>=myClassList.size()-1){
                        flag=true;
                    }
                }
                if(flag){
                    //删除不包含的班级
                    myClassMapper.deletemyClassById(my.getClassId());
                }
            }
            //如果前端传过来的major对象中的myClasslist中的class_id为空，说明当前class对象应该新增
            List<myClass> listadd = new ArrayList<myClass>();
            for(myClass ma:myClassList){
                if(ma.getClassId()==null){
                    ma.setMajorId(majorId);
                    listadd.add(ma);
                }
            }
            if(listadd.size()>0){
                //批量新增班级管理
                majorMapper.batchmyClass(listadd);
            }
        }else{
            if(datalist.size()>0){
                Long [] classid=new Long[datalist.size()];
                for(int i=0;i<datalist.size();i++){
                    classid[i]=datalist.get(i).getClassId();
                }
                //删除专业下的所有班级
                myClassMapper.deletemyClassByIds(classid);
            }
        }
    }
}
