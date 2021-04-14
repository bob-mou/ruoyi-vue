package com.ruoyi.service.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.service.mapper.MajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.service.domain.Major;
import com.ruoyi.service.mapper.CollegeMapper;
import com.ruoyi.service.domain.College;
import com.ruoyi.service.service.ICollegeService;

/**
 * 学院管理Service业务层处理
 *
 * @author 牟连波
 * @date 2021-04-09
 */
@Service
public class CollegeServiceImpl implements ICollegeService
{
    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private MajorMapper majorMapper;
    /**
     * 查询学院管理
     *
     * @param collegeId 学院管理ID
     * @return 学院管理
     */
    @Override
    public College selectCollegeById(Long collegeId)
    {
        return collegeMapper.selectCollegeById(collegeId);
    }

    /**
     * 查询学院管理列表
     *
     * @param college 学院管理
     * @return 学院管理
     */
    @Override
    public List<College> selectCollegeList(College college)
    {
        return collegeMapper.selectCollegeList(college);
    }

    /**
     * 新增学院管理
     *
     * @param college 学院管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertCollege(College college)
    {
        college.setCreateTime(DateUtils.getNowDate());
        int rows = collegeMapper.insertCollege(college);
        insertMajor(college);
        return rows;
    }

    /**
     * 修改学院管理
     *
     * @param college 学院管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateCollege(College college)
    {
//        int i=collegeMapper.deleteMajorByMajorId(college.getCollegeId());
        insertMajor(college);
        return collegeMapper.updateCollege(college);
    }

    /**
     * 批量删除学院管理
     *
     * @param collegeIds 需要删除的学院管理ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCollegeByIds(Long[] collegeIds)
    {
        collegeMapper.deleteMajorByMajorIds(collegeIds);
        return collegeMapper.deleteCollegeByIds(collegeIds);
    }

    /**
     * 删除学院管理信息
     *
     * @param collegeId 学院管理ID
     * @return 结果
     */
    @Override
    public int deleteCollegeById(Long collegeId)
    {
        collegeMapper.deleteMajorByMajorId(collegeId);
        return collegeMapper.deleteCollegeById(collegeId);
    }

    /**
     * 新增专业管理信息
     *
     * @param college 学院管理对象
     */
    public void insertMajor(College college)
    {
        //前端接收到的college对象中的majorList集合
        List<Major> majorList = college.getMajorList();
        //Long collegeId = college.getCollegeId();
        Major majorobj=new Major();
        majorobj.setCollegeId(college.getCollegeId());
        //数据库中的majorlist（当major表中的college_id为当前college对象的college_id时）
        List<Major> majorlist=majorMapper.selectMajorList(majorobj);
        //前端穿过来的college中的majorlist不为空时
        if (StringUtils.isNotNull(majorList))
        {
            for(Major m:majorlist){
                //前端的majorList中不含数据库中的majorlist中的major对象，说明该major对象该从数据库中删除
                Boolean flag=false;
                for(int j=0;j<majorList.size();j++){
                    //前端的集合包含数据库里的数据，就更新
                    if(majorList.get(j).getMajorId()!=null){
                        if(majorList.get(j).getMajorId().equals(m.getMajorId())){
                            majorMapper.updateMajor(majorList.get(j));
                            break;
                        }
                    }
                    //，前端比较完后，不包含，就删除数据库中的数据
                    else if(j>=majorList.size()-1){
                        flag=true;
                    }
                }
                if(flag){
                    majorMapper.deleteMajorById(m.getMajorId());
                }
            }
            //如果前端传过来的college对象中的majorList中的major_id为空，说明当前major对象应该新增
            List<Major> listadd = new ArrayList<Major>();
            for(Major ma:majorList){
                if(ma.getMajorId()==null){
                    listadd.add(ma);
                }
            }
            if(listadd.size()>0){
                //批量新增专业管理
                collegeMapper.batchMajor(listadd);
            }
        }
        //前端传过来的college里的majorlist没有值时（前端的专业被删完了，或者根本没有专业）
        else{
            if(majorlist.size()>0){
                //将majorlist对象中的major_id转换为数组
                Long [] majorIdlist=new Long[majorlist.size()];
                for(int i=0;i<majorlist.size();i++){
                    majorIdlist[i]=majorlist.get(i).getMajorId();
                }
                //删除所有的当前学院下的所有专业
                majorMapper.deleteMajorByIds(majorIdlist);
            }
        }

    }
}
