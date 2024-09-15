package com.bdk.media.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdk.model.media.pojo.WmNews;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MediaMapper extends BaseMapper<WmNews> {
}
