package dbms.railway.models;

public class station {
    private String stationCode;
    private String stationName;

    public station() {

    }

    public station(String stationCode,String stationName){
        this.stationCode = stationCode;
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "station{" +
                "stationCode='" + stationCode + '\'' +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
