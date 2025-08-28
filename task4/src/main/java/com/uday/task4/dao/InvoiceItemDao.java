package com.uday.task4.dao;

import com.uday.task4.model.InvoiceItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceItemDao {

    private final JdbcTemplate jdbcTemplate;

    public InvoiceItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(InvoiceItem item) {
        String sql = "INSERT INTO invoice_item (quantity, description, packing, gst, trade_price, retail_price, discount, expiry_date, net_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getQuantity(), item.getDescription(), item.getPacking(), item.getGst(),
                item.getTradePrice(),
                item.getRetailPrice(), item.getDiscount(), item.getExpiryDate(), item.getNetAmount());
    }

    public List<InvoiceItem> findAll() {
        return jdbcTemplate.query("SELECT * FROM invoice_item", new RowMapper<InvoiceItem>() {
            @Override
            public InvoiceItem mapRow(ResultSet rs, int rowNum) throws SQLException {
                InvoiceItem item = new InvoiceItem();
                item.setId(rs.getInt("id"));
                item.setQuantity(rs.getInt("quantity"));
                item.setDescription(rs.getString("description"));
                item.setPacking(rs.getString("packing"));
                item.setGst(rs.getDouble("gst"));
                item.setTradePrice(rs.getDouble("trade_price"));
                item.setRetailPrice(rs.getDouble("retail_price"));
                item.setDiscount(rs.getDouble("discount"));
                item.setExpiryDate(rs.getDate("expiry_date"));
                item.setNetAmount(rs.getDouble("net_amount"));
                return item;
            }
        });
    }
}
