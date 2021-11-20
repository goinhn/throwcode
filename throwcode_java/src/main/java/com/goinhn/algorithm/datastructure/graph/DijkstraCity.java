package com.goinhn.algorithm.datastructure.graph;

import java.util.*;

/**
 * <p>
 * 有向图的最短路径
 *
 * Dijkstra算法
 * </p>
 *
 * @author
 * @date 2020-12-11T20:30:38
 */
public class DijkstraCity {

    public static void main(String[] args) {
        Map<String, City> cityMap = getCityMap(cities);

        List<Vertex> verList = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            Vertex vertex = new Vertex(cities[i]);
            verList.add(vertex);
        }


        Map<Vertex, List<Edge>> vertexEdgeListMap = new HashMap<>();
        for (int i = 0; i < cities.length; i++) {
            String name = cities[i].split("-")[0];
            List<Edge> edgeList = new LinkedList<>();
            for (int j = 0; j < road.length; j++) {
                String[] roadLine = road[j].split("-");
                if (name.equals(roadLine[0]) && cityMap.containsKey(roadLine[1])) {
                    City cityBegin = cityMap.get(name);
                    City cityEnd = cityMap.get(roadLine[1]);
                    int distance = getRealDistance(cityBegin.lat, cityBegin.lng, cityEnd.lat, cityEnd.lng);
                    edgeList.add(new Edge(verList.get(cityBegin.index), verList.get(cityEnd.index), distance));
                }
            }
            vertexEdgeListMap.put(verList.get(i), edgeList);
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("请输入起点城市：");
        String begin = scanner.nextLine().trim();
        if (!cityMap.containsKey(begin)) {
            System.out.println("输入错误，不存在该城市");
            return;
        }
        System.out.println("请输入终点城市：");
        String end = scanner.nextLine().trim();
        if (!cityMap.containsKey(end)) {
            System.out.println("输入错误，不存在该城市");
            return;
        }

        int startIndex = cityMap.get(begin).getIndex();
        int endIndex = cityMap.get(end).getIndex();

        DijkstraCity dijkstraCity = new DijkstraCity(verList, vertexEdgeListMap);
        dijkstraCity.updateChildren(verList.get(startIndex));
        List<String> list = dijkstraCity.dijkstraTravel(startIndex, endIndex);
        int distance = Integer.parseInt(list.get(list.size() - 1));
        System.out.println("最短的路径为：");
        for (int i = list.size() - 2; i > -1; i--) {
            System.out.print(list.get(i));
            if (i != 0) {
                System.out.print(" --> ");
            }
        }
        System.out.println("\n最短的路程为：");
        System.out.println(distance + "km");

        scanner.close();
    }

    /**
     * 城市以及其经纬度坐标
     */
    private static String[] cities = {
            "北京-(116.23182E,40.22077N)",
            "上海-(121.48941E,31.40527N)",
            "天津-(117.30983E,39.71755N)",
            "重庆-(106.54041E,29.40268N)",
            "哈尔滨-(126.95717E,45.54774N)",
            "乌鲁木齐-(88.31104E,43.36378N)",
            "郑州-(113.6401E,34.72468N)",
            "长沙-(112.98626E,28.25591N)",
            "南京-(118.8921E,31.32751N)",
            "杭州-(120.21201E,30.2084N)"
    };

    /**
     * 城市到城市之间的道路
     * 有向图中的边
     */
    private static String[] road = {
            "北京-上海",
            "上海-天津",
            "天津-重庆",
            "重庆-哈尔滨",
            "哈尔滨-乌鲁木齐",
            "乌鲁木齐-郑州",
            "郑州-长沙",
            "长沙-南京",
            "南京-杭州"
    };

    /**
     * 城市信息类
     */
    public static class City {
        /**
         * 图中的下标
         */
        private int index;
        /**
         * 维度
         */
        private double lat;
        /**
         * 经度
         */
        private double lng;

        public City() {
        }

        public City(int index, double lat, double lng) {
            this.index = index;
            this.lat = lat;
            this.lng = lng;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }

    /**
     * 地球的平均半径
     * 单位：km
     */
    private static final double EARTH_R = 6371.393;

    /**
     * 根据经纬度计算真实的距离
     * <p>
     * 经度[-180,180]西经-东经
     * 纬度[-90,90]南纬-北纬
     *
     * @param lat1 纬度
     * @param lng1 经度
     * @param lat2
     * @param lng2
     * @return
     */
    public static int getRealDistance(double lat1, double lng1, double lat2, double lng2) {
// 经纬度（角度）转弧度。弧度用作参数，以调用Math.cos和Math.sin
        double radiansAX = Math.toRadians(lng1);
        double radiansAY = Math.toRadians(lat1);
        double radiansBX = Math.toRadians(lng2);
        double radiansBY = Math.toRadians(lat2);

        // 公式中“cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2”的部分，得到∠AOB的cos值
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
//        System.out.println("cos = " + cos); // 值域[-1,1]
        double acos = Math.acos(cos); // 反余弦值
//        System.out.println("acos = " + acos); // 值域[0,π]
//        System.out.println("∠AOB = " + Math.toDegrees(acos)); // 球心角 值域[0,180]
        return new Double(EARTH_R * acos).intValue();
    }

    /**
     * 获取城市的映射关系
     *
     * @param cities
     * @return
     */
    public static Map<String, City> getCityMap(String[] cities) {
        Map<String, City> map = new HashMap<>();
        for (int i = 0; i < cities.length; i++) {
            String[] line = cities[i].split("-");
            String name = line[0];
//            位置信息的转换
            String[] location = line[1].substring(1, line[1].length() - 1).split(",");
            String latStr = location[0];
            String lngStr = location[1];
            double lat = Double.parseDouble(latStr.substring(0, latStr.length() - 1));
            lat = latStr.charAt(latStr.length() - 1) == 'E' ? lat : -lat;
            double lng = Double.parseDouble(lngStr.substring(0, lngStr.length() - 1));
            lng = lngStr.charAt(lngStr.length() - 1) == 'N' ? lng : -lng;

            City city = new City(i, lat, lng);
//            插入不重复的城市
            if (!map.containsKey(name)) {
                map.put(name, city);
            }
        }

        return map;
    }

    /**
     * 图的顶点集
     */
    private List<Vertex> vertexList;

    /**
     * 图的每个顶点对应的有向边
     */
    private Map<Vertex, List<Edge>> verEdgeListMap;

    public DijkstraCity(List<Vertex> vertexList, Map<Vertex, List<Edge>> verEdgeListMap) {
        this.vertexList = vertexList;
        this.verEdgeListMap = verEdgeListMap;
    }

    /**
     * 设置初始节点的参数
     *
     * @param v
     */
    public void setRoot(Vertex v) {
        v.setParent(null);
        v.setDistance(0);
    }

    /**
     * 从初始节点开始递归更新邻接表
     *
     * @param v
     */
    private void updateChildren(Vertex v) {
        if (v == null) {
            return;
        }

        if (verEdgeListMap.get(v) == null || verEdgeListMap.get(v).size() == 0) {
            return;
        }

        List<Vertex> childrenList = new LinkedList<>();
        for (Edge e : verEdgeListMap.get(v)) {
            Vertex childVertex = e.getEndVertex();
//            如果子节点之前未知,则把当前子节点加入更新列表
            if (!childVertex.isKnown()) {
                childVertex.setKnown(true);
                childVertex.setDistance(v.getDistance() + e.getWeight());
                childVertex.setParent(v);
                childrenList.add(childVertex);
            }

//            子节点之前已知,则比较子节点的adjudist&&nowDist
            int nowDist = v.getDistance() + e.getWeight();
            if (nowDist < childVertex.getDistance()) {
                childVertex.setDistance(nowDist);
                childVertex.setParent(v);
            }
        }

        //更新每一个子节点
        for (Vertex vc : childrenList) {
            updateChildren(vc);
        }
    }


    /**
     * @param startIndex dijkstra遍历的起点节点下标
     * @param destIndex  dijkstra遍历的终点节点下标
     */
    public List<String> dijkstraTravel(int startIndex, int destIndex) {
        Vertex start = vertexList.get(startIndex);
        Vertex dest = vertexList.get(destIndex);
//        String path = "[" + dest.getName() + "]";

        setRoot(start);
        updateChildren(vertexList.get(startIndex));

        int shortestLength = dest.getDistance();
//        将之前计算的节点指向的过程进行遍历拿出
        List<String> result = new ArrayList<>();
        result.add(dest.getName());

        while ((dest.getParent() != null) && (!dest.equals(start))) {
            result.add(dest.getParent().getName());
            dest = dest.getParent();
        }

//        获取最短路径的值，该值直接存在结束的节点的位置

        result.add(Integer.toString(shortestLength));

        return result;
    }

    /**
     * 定义节点Vertex类
     */
    public static class Vertex {
        /**
         * 无限的距离
         */
        private final static int INFINITE_DIS = 0;
        /**
         * 节点的名字
         */
        private String name;
        /**
         * 该节点是否被探索
         */
        private boolean known;
        /**
         * 距离此节点距离
         */
        private int distance;
        /**
         * 当前从初始化节点到此节点的最短路径下的父亲节点
         * 每次都是不一样的
         */
        private Vertex parent;

        public Vertex() {
            this.known = false;
            this.distance = INFINITE_DIS;
            this.parent = null;
        }

        public Vertex(String name) {
            this();
            this.name = name;
        }

        public static int getInfiniteDis() {
            return INFINITE_DIS;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isKnown() {
            return known;
        }

        public void setKnown(boolean known) {
            this.known = known;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Vertex getParent() {
            return parent;
        }

        public void setParent(Vertex parent) {
            this.parent = parent;
        }
    }


    /**
     * 定义有向边类
     */
    public static class Edge {
        /**
         * 此有向边的起始点
         */
        private Vertex startVertex;
        /**
         * 此有向边的终点
         */
        private Vertex endVertex;
        /**
         * 此有向边的权值，类似路径的长短
         */
        private int weight;

        public Edge(Vertex startVertex, Vertex endVertex, int weight) {
            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.weight = weight;
        }

        public Vertex getStartVertex() {
            return startVertex;
        }

        public void setStartVertex(Vertex startVertex) {
            this.startVertex = startVertex;
        }

        public Vertex getEndVertex() {
            return endVertex;
        }

        public void setEndVertex(Vertex endVertex) {
            this.endVertex = endVertex;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }


}