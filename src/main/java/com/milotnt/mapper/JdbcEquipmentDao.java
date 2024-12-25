package com.milotnt.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEquipmentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcEquipmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 统计器材总数。
     * @return 返回器材总数。
     */
    public Integer countEquipment() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM equipment", Integer.class);
    }
}