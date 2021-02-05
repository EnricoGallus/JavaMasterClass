public class PaintJob {
    public static void main(String[] args) {
        /*System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));*/
        System.out.println(getBucketCount(0.75, 0.75, 0.5, 0));
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }

        return getBucketCount(width, height, areaPerBucket) - extraBuckets;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;
        }

        double area = width * height;
        return getBucketCount(area, areaPerBucket);
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }

        return (int)Math.ceil((area / areaPerBucket));
    }

    /*private static int calculateFromDimension(double width, double height, double areaPerBucket, int extraBuckets) {
        double area = width * height;
        return calculateFromArea(area, areaPerBucket, extraBuckets);
    }

    private static int calculateFromArea(double area, double areaPerBucket, int extraBuckets) {
        return (int)Math.ceil((area / areaPerBucket))  - extraBuckets;
    }*/
}
