package com.home.elasticsearch.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightData {
	
	
	private String FlightNum;
	private String Origin;
    private OriginLocation OriginLocation;
    private DestLocation DestLocation;
    private Boolean FlightDelay;
    private Double DistanceMiles;
    private Double FlightTimeMin;
    private String OriginWeather;
    private Integer dayOfWeek;
    private Double AvgTicketPrice;
    private String Carrier;
    private Double FlightDelayMinl;
    private String OriginRegion;
    private String FlightDelayType;
    private String DestAirportID;
    private String timestamp;
    private String Dest;
    private Double FlightTimeHourl;
    private Boolean Cancelled;
    private Double DistanceKilometers;
    private String OriginCityName;
    private String DestWeather;
    private String OriginCountry;
    private String DestCountry;
    private String DestRegion;
    private String OriginAirportID;
    private String DestCityName;
	
    @Builder
    @Data
	static class OriginLocation{
		private Double lon;
		private Double lat;
	}
    
    @Builder
    @Data
    static class DestLocation{
    	private Double lon;
    	private Double lat;
    }

}
