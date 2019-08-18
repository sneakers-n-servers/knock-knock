package edu.gwu.csci6010.kk.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class KKObjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(KKObject kkObject) {
        String insert = "INSERT INTO kkobjects(name, value) VALUES(?,?)";
        return jdbcTemplate.update(insert, kkObject.getName(), kkObject.getValue());
    }

    public List<KKObject> findAll() {
        String sql = "SELECT * FROM kkobjects";
        List<KKObject> objects = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            KKObject obj = new KKObject((String) row.get("name"), (String) row.get("value"));
            objects.add(obj);
        }
        return objects;
    }


}
