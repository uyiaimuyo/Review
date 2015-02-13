// Given a two dimensional graph with points on it, find a line which passes the most number of points

public class LinePassesMostPoints {
	
	public Line findLine(Point[] points) {

		HashMap<Line, Integer> m = new HashMap<Line,Integer>();

		Line max = null;
		for(int i=0; i<points.length; i++) {
			for(int j=i+1; j<points.length; j++) {
				Line l = new Line(points[i],points[j]);

				if (m.contains(l)) {
					m.put(l, m.get(l)+1);
				} else {
					m.put(l, 1);
				}

				if (max == null || m.get(l) > m.get(max))
					max = l;
			}
		}
		return max;
	}

	public class Line {
		float slope;
		int intercept;

		public Line(Point a, Point b) {
			slope = (b.y-a.y)/(b.x-a.x);
			intercept = b.y - slop*b.x;
		}
	}
}