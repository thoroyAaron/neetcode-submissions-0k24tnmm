class TimeMap {

    Map<String,List<TimeValue>> map;

    public TimeMap(){
        map = new HashMap<>();
    }


    public void set(String key,String value,int timestamp){

        map.computeIfAbsent(key,k->new ArrayList<>())
           .add(new TimeValue(timestamp,value));
    }


    public String get(String key,int timestamp){

        if(!map.containsKey(key))
            return "";

        List<TimeValue> list = map.get(key);

        int left=0;
        int right=list.size()-1;

        String ans="";


        while(left<=right){

            int mid=left+(right-left)/2;

            if(list.get(mid).timestamp<=timestamp){
                ans=list.get(mid).value;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return ans;
    }


    class TimeValue{
        int timestamp;
        String value;

        TimeValue(int t,String v){
            timestamp=t;
            value=v;
        }
    }
}