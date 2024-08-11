package dbms.railway.dao;


import dbms.railway.models.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class StationJdbcDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<station> stationRowMapper = (rs, rowNum) -> {
        station station = new station();
        station.setStationCode(rs.getString("stationCode"));
        station.setStationName(rs.getString("stationName"));
        return station;
    };

    private HashMap<String, Object> getStationMap(station station) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("stationName", station.getStationCode());
        map.put("stationCode", station.getStationName());
        return map;
    }

    public void createStation(station station) {
        if (getStationByStationCode(station.getStationCode()) != null) {
            throw new DuplicateKeyException("Station code already exists. Please choose a different code.");
        }
        String sql = "INSERT INTO stations   (scode, sname) VALUES (:stationCode,:stationName)";
        HashMap<String, Object> params = getStationMap(station);
        namedParameterJdbcTemplate.update(sql, params);
    }


    public List<station> getAllStations() {
        String sql = "SELECT * FROM stations";
        return namedParameterJdbcTemplate.query(sql, stationRowMapper);
    }

    public station getStationByStationCode(String stationCode){
        String sql = "SELECT * FROM stations WHERE stationCode = :stationCode";
        HashMap<String, Object> params = new HashMap<>();
        params.put("stationCode", stationCode);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, stationRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public station getStationByStationName(String stationName){
        String sql = "SELECT * FROM stations WHERE stationName = :stationName";
        HashMap<String, Object> params = new HashMap<>();
        params.put("stationName", stationName);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, stationRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public List<station> getStationBySearch(String name){
        String sql = "\n" +
                "SELECT * FROM stations WHERE stationName LIKE :stationName OR stationCode like :stationCode ORDER BY CASE WHEN stationCode like :stationCode THEN 2 WHEN stationName LIKE :stationName THEN 1 ELSE 0 END DESC LIMIT 5;";
        HashMap<String, Object> params = new HashMap<>();
        params.put("stationCode", name);
        params.put("stationName", name+"%");
        try {
            return namedParameterJdbcTemplate.query(sql, params, stationRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
