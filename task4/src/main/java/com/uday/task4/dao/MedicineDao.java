package com.uday.task4.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.uday.task4.model.Medicine;
import java.util.List;

@Repository
public class MedicineDao {
    private final JdbcTemplate jdbcTemplate;

    public MedicineDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Medicine> findAll() {
        return jdbcTemplate.query("SELECT * FROM medicine", (rs, rowNum) -> {
            Medicine med = new Medicine();
            med.setId(rs.getInt("id"));
            med.setName(rs.getString("name"));
            med.setPacking(rs.getString("packing"));
            med.setGst(rs.getDouble("gst"));
            med.setTradePrice(rs.getDouble("trade_price"));
            med.setRetailPrice(rs.getDouble("retail_price"));
            med.setDiscount(rs.getDouble("discount"));
            med.setExpiryDate(rs.getDate("expiry_date"));
            return med;
        });
    }

    public Medicine findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM medicine WHERE id = ?",
                new Object[] { id }, (rs, rowNum) -> {
                    Medicine med = new Medicine();
                    med.setId(rs.getInt("id"));
                    med.setName(rs.getString("name"));
                    med.setPacking(rs.getString("packing"));
                    med.setGst(rs.getDouble("gst"));
                    med.setTradePrice(rs.getDouble("trade_price"));
                    med.setRetailPrice(rs.getDouble("retail_price"));
                    med.setDiscount(rs.getDouble("discount"));
                    med.setExpiryDate(rs.getDate("expiry_date"));
                    return med;
                });
    }
}
