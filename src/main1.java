import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class main1 {

//    WholeFruit 2
//    Starbucks 1
//    Maxi 1

    public static List<Chain> getChain(List<Business> businesses, String location ){

        List<Business> shortedList = businesses.stream()
                .filter(business -> {
                    return business.getLocation().equals(location);
                })
                .collect(Collectors.toList());

        Map<String, Long> chain1 = shortedList.stream()
                .collect(
                        Collectors.groupingBy(Business::getName,Collectors.counting())
                );

        List<Chain> chain= new ArrayList<>();

        chain1.forEach((name,count)->{
          chain.add(new Chain(name,count));
        });

       List<Chain> sChain = chain.stream()
               .sorted(Comparator.comparing(Chain::getEntries).reversed()).collect(Collectors.toList());

    return sChain;
    }


    public static void main(String[] args) {
        Business b1 = new Business(102, "Starbucks", "Austin");
        Business b2 = new Business(101, "Starbucks", "Seattle");
        Business b3 = new Business(103, "WholeFruit", "Austin");
        Business b4 = new Business(103, "WholeFruit", "Austin");
        Business b5 = new Business(104, "WholeFruit", "Austin");
        Business b6 = new Business(104, "WholeFruit", "Seattle");
        Business b7 = new Business(105, "Maxi", "Austin");

        List<Business> business =  new ArrayList<>();
        business.add(b1);
        business.add(b2);
        business.add(b3);
        business.add(b4);
        business.add(b5);
        business.add(b6);
        business.add(b7);

        List<Chain> austin = getChain(business, "Austin");


    }
}
