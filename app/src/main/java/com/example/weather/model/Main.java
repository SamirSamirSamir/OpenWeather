package com.example.weather.model;
import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    
    private Double temp;
    @SerializedName("pressure")
    
    private Double pressure;
    @SerializedName("humidity")
    
    private Integer humidity;
    @SerializedName("temp_min")
    
    private Double tempMin;
    @SerializedName("temp_max")
    
    private Double tempMax;
    @SerializedName("sea_level")
    
    private Double seaLevel;
    @SerializedName("grnd_level")
    
    private Double grndLevel;

    public Main(Double temp, Double pressure, Integer humidity, Double tempMin, Double tempMax, Double seaLevel, Double grndLevel) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;

    }


    public Double getTemp() {
        return temp;
    }
    public void setTemp(Double temp) {
        this.temp = temp;
    }
    public Double getPressure() {
        return pressure;
    }
    public void setPressure(Double pressure) {this.pressure = pressure;}
    public Integer getHumidity() { return humidity;}
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
    public Double getTempMin() {
        return tempMin;
    }
    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }
    public Double getTempMax() {
        return tempMax;
    }
    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }
    public Double getSeaLevel() {
        return seaLevel;
    }
    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }
    public Double getGrndLevel() {
        return grndLevel;
    }
    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = grndLevel;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "temp=" + temp +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", tempMin=" + tempMin +
                ", tempMax='" + tempMax + '\'' +
                ", seaLevel='" + seaLevel + '\'' +
                ", grndLevel='" + grndLevel + '\'' +
                '}';
    }

}