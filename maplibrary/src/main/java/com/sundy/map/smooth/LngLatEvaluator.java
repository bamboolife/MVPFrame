package com.sundy.map.smooth;

import android.animation.TypeEvaluator;

public class LngLatEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        LngLat startLnglat = (LngLat) startValue;
        LngLat endLnglat = (LngLat) endValue;
        double lng = startLnglat.getLng() + fraction * (endLnglat.getLng() - startLnglat.getLng());
        double lat = startLnglat.getLat() + fraction * (endLnglat.getLat() - startLnglat.getLat());
        return new LngLat(lng,lat);
    }
}
