package Strings.Basics;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentIP {
    public static String findMostFrequentIP(String[] logs) {
        Map<String, Integer> ipFrequency = new HashMap<>();

        for (String log : logs) {
            // Extract IP address from log entry
            String ip = log.split(" - ")[0];  //we need first substring  after splitting
            ipFrequency.put(ip, ipFrequency.getOrDefault(ip, 0) + 1);
        }

        // Find the IP address with the highest frequency
        String mostFrequentIP = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : ipFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentIP = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostFrequentIP;
    }

    public static void main(String[] args) {
        String[] logs = {
                "10.0.0.1 - GET 2020-08-24",
                "10.0.0.1 - GET 2020-08-24",
                "10.0.0.2 - GET 2020-08-20"
        };

        String mostFrequentIP = findMostFrequentIP(logs);
        System.out.println("Most Frequent IP Address: " + mostFrequentIP);
    }
}
