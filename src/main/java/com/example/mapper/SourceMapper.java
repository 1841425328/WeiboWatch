package com.example.mapper;

import com.example.pojo.Source;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface SourceMapper {
    List<Source> getTopSources();
}
