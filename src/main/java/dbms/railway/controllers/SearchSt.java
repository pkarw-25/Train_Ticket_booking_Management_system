package dbms.railway.controllers;

import dbms.railway.dao.StationJdbcDao;
import dbms.railway.models.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//import java.awt.*;

import java.util.List;

@RestController
public class SearchSt {

    @Autowired
    private StationJdbcDao stationJdbcDao;
    // search handler
    @GetMapping("SearchSt/{query}")
    public ResponseEntity<?> search(@PathVariable("query") String query){
        List<station> stations = this.stationJdbcDao.getStationBySearch(query);
        return ResponseEntity.ok(stations);
    }
}
