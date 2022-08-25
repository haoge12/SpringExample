package com.xuhao.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao {
    public void updateMoney(@Param("id") Integer id, @Param("money") Double money);
}
