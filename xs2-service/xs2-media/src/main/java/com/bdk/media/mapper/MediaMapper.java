package com.bdk.media.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdk.model.media.dto.WmNewsDto;
import com.bdk.model.media.pojo.WmNews;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MediaMapper extends BaseMapper<WmNews> {

    public List<WmNews> loadArticleList(WmNewsDto dto, Short type);


}
