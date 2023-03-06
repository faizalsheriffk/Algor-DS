package math.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {

    private List<GPoint> points = new ArrayList<GPoint>();
    private Map<GPoint, Integer> countMap = new HashMap<GPoint, Integer>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        GPoint graphPoint = new GPoint(point[0], point[1]);
        points.add(graphPoint);
        int count = countMap.getOrDefault(graphPoint,0)+1;
        countMap.put(graphPoint, count);

    }

    public int count(int[] point) {

        GPoint qPoint = new GPoint(point[0], point[1]);
        int count = 0;
        for(GPoint ipoint: points){
            var xx = ipoint.x;
            var yy = ipoint.y;
            if(Math.abs(ipoint.x-qPoint.x)!=Math.abs(ipoint.y-qPoint.y)||(ipoint.x == qPoint.x) || (ipoint.y == qPoint.y))
                continue;

            GPoint leftTop = new GPoint(ipoint.x,qPoint.y);
            GPoint rightBottom = new GPoint(qPoint.x, ipoint.y);
            count = count + countMap.getOrDefault(leftTop, 0)*countMap.getOrDefault(rightBottom, 0);

        }
        return count;
    }
}
//1,2  1, 5,  5,5, 1,5
class GPoint extends Object{
    int x;
    int y;

    GPoint(){

    }

    GPoint(int x1, int y1){
        this.x = x1;
        this.y = y1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GPoint))
            return false;
        GPoint other = (GPoint) o;
        boolean xEquals = (this.x == other.x);

        boolean yEquals = (this.y == other.y);

        return xEquals && yEquals;
    }


    @Override
    public final int hashCode() {

        Integer xx = this.x;
        Integer yy = this.y;

        return xx.hashCode()+yy.hashCode();
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
