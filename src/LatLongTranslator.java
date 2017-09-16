public class LatLongTranslator {
    private int minLat;
    private int minLon;
    private int maxLat;
    private int maxLon;
    private int multiplicationFactor;

    public LatLongTranslator(int minLat, int minLon, int maxLat, int maxLon, int decimalPrecision) {
        if (decimalPrecision < 0) throw new IllegalArgumentException("decimalPrecision has to be at least 0.");
        if (maxLat < minLat || maxLon < minLon) throw new IllegalArgumentException("Maximum latitude/longitude cannot be smaller than minimum latitude/longitude.");

        this.minLat = minLat;
        this.minLon = minLon;
        this.maxLat = maxLat;
        this.maxLon = maxLon;
        this.multiplicationFactor = (int) Math.pow(10, decimalPrecision);
    }

    public int translateLon(float lon) {
        if (lon < minLon || maxLon < lon) throw new RuntimeException("Out of bounds");

        return (int)(lon * multiplicationFactor);
    }

    public int translateLat(float lat) {
        if (lat < minLat || maxLat < lat) throw new RuntimeException("Out of bounds");

        return (int)(lat * multiplicationFactor);
    }

    public int width() {
        return (maxLon - minLon) * multiplicationFactor;
    }

    public int height() {
        return (maxLat - minLat) * multiplicationFactor;
    }
}
