package com.example.zhenmin.weather.util;

import android.text.TextUtils;
import com.example.zhenmin.weather.db.WeatherDB;
import com.example.zhenmin.weather.model.City;
import com.example.zhenmin.weather.model.County;
import com.example.zhenmin.weather.model.Province;

/**
 * Created by zhenmin on 2015/10/28.
 */
public class Utility {
    public synchronized static boolean handleProvincesResponse(WeatherDB weatherDB,String response ){
        if (!TextUtils.isEmpty(response)){
            String[]allProvinces = response.split(",");
            if (allProvinces!=null&&allProvinces.length>0){
                for (String p:allProvinces){
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    weatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false ;
    }

    public static boolean handleCitiesResponse(WeatherDB weatherDB,String response,int provinceId ){
        if (!TextUtils.isEmpty(response)){
            String[]allCities = response.split(",");
            if (allCities!=null&&allCities.length>0){
                for (String c:allCities){
                    String[]array= c.split("\\|");
                    City city  = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    weatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false ;
    }

    public static boolean handleCountiesResponse(WeatherDB weatherDB,String response ,int cityId){
        if (!TextUtils.isEmpty(response)){
            String[]allCounties = response.split(",");
            if (allCounties!=null&&allCounties.length>0){
                for (String c:allCounties){
                    String[]array= c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    weatherDB.saveCounty(county);
                }
                return true;

            }
        }
        return false ;
    }


}
