package com.xuhao.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao {
    void upDate(@Param("id") Integer id, @Param("money") Double money);
}
