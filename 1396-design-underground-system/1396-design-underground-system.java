class Data{
    private String place;
    private int time;
    
    public Data(String place, int time){
        this.place = place;
        this.time = time;
    }
    
    String getPlace(){return this.place;}
    int getTime(){return this.time;}

}
class AverageTravel{
    private int totalDiff;
    private int count;
    
    public AverageTravel(int totalDiff, int count){
        this.totalDiff = totalDiff;
        this.count = count;
    }
    
    int getTotalDiff(){return this.totalDiff;}
    int getCount(){return this.count;}
    void setTotalDiff(int diff){ this.totalDiff = diff;}
    void setCount(int count){this.count = count;}
}

class UndergroundSystem {
    
    static final char DELIMITER = '+';
    private HashMap<Integer,Data>checkIn;
    private HashMap<String,AverageTravel>average;

    public UndergroundSystem() {
        checkIn = new HashMap();
        average = new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Data currTravel = new Data(stationName,t);
        checkIn.put(id,currTravel);
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        
        Data prevTravel = checkIn.get(id);
        int timeDiff = t - prevTravel.getTime();
        
        checkIn.remove(id);

        String key = generateUniquekey(prevTravel.getPlace(),stationName);
        
        average.putIfAbsent(key, new AverageTravel(0,0));
        AverageTravel currAverage = average.get(key);
        currAverage.setCount(currAverage.getCount()+1);
        currAverage.setTotalDiff(currAverage.getTotalDiff()+timeDiff);
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
       String key = generateUniquekey(startStation,endStation);
       AverageTravel currAverage =  average.get(key);
       return (double) currAverage.getTotalDiff()/currAverage.getCount();
    }
    
   private String generateUniquekey(String startStation, String endStation){
        StringBuilder key = new StringBuilder();
        key.append(startStation);
        key.append(DELIMITER);
        key.append(endStation);
       
       return key.toString();
   }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */