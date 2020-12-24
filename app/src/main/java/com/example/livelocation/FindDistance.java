package com.example.livelocation;

class FindDistance {

    public static double calculateDistance(double latitude1, double longitude1,  double latitude2, double longitude2){

        double radiusEarth = 6371e3; //in meters to get final distance in meter

        // Converting coordinates from degree to radian
        double lat1 = latitude1 * Math.PI/180;
        double lon1 = longitude1 * Math.PI/180;
        double lat2 = latitude2 * Math.PI/180;
        double lon2 = longitude2 * Math.PI/180;

        // Finding deltaLatitude and deltaLongitude (difference between latitudes and longitudes)
        double delLat = (lat2 - lat1) ;
        double delLon = (lon2 - lon1);

        // Applying formula
        // a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
        // c = 2 ⋅ atan2( √a, √(1−a) )
        // d = R ⋅ c
        // where	φ is latitude, λ is longitude, R is earth’s radius (mean radius = 6,371km);
        // note that angles need to be in radians to pass to trig functions!
        double formula1 = Math.sin(delLat/2) * Math.sin(delLat/2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(delLon/2) * Math.sin(delLon/2);
        double formula2 = 2 * Math.atan2(Math.sqrt(formula1), Math.sqrt(1-formula1));
        double finalDist = radiusEarth * formula2;

        return finalDist;
    }
}
