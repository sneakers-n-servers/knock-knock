package edu.gwu.csci6010.kk.object;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KKObjectMapper implements RowMapper<KKObject> {

    @Override
    public KKObject mapRow(ResultSet resultSet, int i) throws SQLException {
        KKObject kkObject = new KKObject(resultSet.getString("name"), resultSet.getString("value"));
        return kkObject;
    }

}
