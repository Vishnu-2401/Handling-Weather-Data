package com.kce.weatherdataapi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weather_data")
public class WeatherDataEntity {

    @Id
    private String id;

    private String date;
    private String conds;
    private String dewptm;
    private String fog;
    private String hail;
    private String heatindexm;
    private String hum;
    private String precipm;
    private String pressurm;
    private String rain;
    private String snow;
    private String tempm;
    private String thunder;
    private String tornado;
    private String vism;
    private String wdird;
    private String wdire;
    private String wgustm;
    private String windchillm;
    private String wspdm;

    public WeatherDataEntity() {}


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getConds() { return conds; }
    public void setConds(String conds) { this.conds = conds; }

    public String getDewptm() { return dewptm; }
    public void setDewptm(String dewptm) { this.dewptm = dewptm; }

    public String getFog() { return fog; }
    public void setFog(String fog) { this.fog = fog; }

    public String getHail() { return hail; }
    public void setHail(String hail) { this.hail = hail; }

    public String getHeatindexm() { return heatindexm; }
    public void setHeatindexm(String heatindexm) { this.heatindexm = heatindexm; }

    public String getHum() { return hum; }
    public void setHum(String hum) { this.hum = hum; }

    public String getPrecipm() { return precipm; }
    public void setPrecipm(String precipm) { this.precipm = precipm; }

    public String getPressurm() { return pressurm; }
    public void setPressurm(String pressurm) { this.pressurm = pressurm; }

    public String getRain() { return rain; }
    public void setRain(String rain) { this.rain = rain; }

    public String getSnow() { return snow; }
    public void setSnow(String snow) { this.snow = snow; }

    public String getTempm() { return tempm; }
    public void setTempm(String tempm) { this.tempm = tempm; }

    public String getThunder() { return thunder; }
    public void setThunder(String thunder) { this.thunder = thunder; }

    public String getTornado() { return tornado; }
    public void setTornado(String tornado) { this.tornado = tornado; }

    public String getVism() { return vism; }
    public void setVism(String vism) { this.vism = vism; }

    public String getWdird() { return wdird; }
    public void setWdird(String wdird) { this.wdird = wdird; }

    public String getWdire() { return wdire; }
    public void setWdire(String wdire) { this.wdire = wdire; }

    public String getWgustm() { return wgustm; }
    public void setWgustm(String wgustm) { this.wgustm = wgustm; }

    public String getWindchillm() { return windchillm; }
    public void setWindchillm(String windchillm) { this.windchillm = windchillm; }

    public String getWspdm() { return wspdm; }
    public void setWspdm(String wspdm) { this.wspdm = wspdm; }
}