package sample;

import java.io.*;
import java.util.*;

public class WeatherCounter {

    public int totalCount = 0;

    public Map<String, Integer> weatherCount;

    public String[] keyWeather;
    public int[] keyCount;

    public WeatherCounter() {
        weatherCount = new TreeMap<>();
    }

    public void fileProcess(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Directory of File:");
        String file = scanner.nextLine();
        File inFile = new File(file);

        try {
            BufferedReader in = new BufferedReader(new FileReader(inFile));
            String line;

            int columnIndex = 5;

            while ((line = in.readLine()) != null) {
                String[] data = line.split(",");
                String nextWeather = data[columnIndex];

                if (isWord(nextWeather)) {
                    countWord(nextWeather);
                }
                totalCount++;
            }

            setKeyWeather();
            setKeyCount();

//            Set<String> keys = weatherCount.keySet();
//            Iterator<String> keyIterator = keys.iterator();
//
//            while (keyIterator.hasNext()) {
//                String key = keyIterator.next();
//                int count = weatherCount.get(key);
//
//                if (count >= 2) {
//                    System.out.println(key + ": " + count);
//                }
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void countWord(String word) {
        if (weatherCount.containsKey(word)) {
            int oldCount = weatherCount.get(word);
            weatherCount.put(word, oldCount + 1);
        } else {
            weatherCount.put(word, 1);
        }
    }

    private boolean isWord(String str){
        String pattern = "^[ a-zA-Z]*$";
        if (str.matches(pattern)){
            return true;
        }
        return false;
    }

    public int getSize(){
        return this.weatherCount.size();
    }

    public void setKeyWeather(){
        keyWeather = new String[weatherCount.size()];
        Set<String> keys = weatherCount.keySet();
        Iterator<String> keyIterator = keys.iterator();
        int index = 0;
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            this.keyWeather[index] = key;
            index++;
        }
    }

    public void setKeyCount(){
        keyCount = new int[weatherCount.size()];
        Set<String> keys = weatherCount.keySet();
        Iterator<String> keyIterator = keys.iterator();
        int index = 0;
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            int count = weatherCount.get(key);
            this.keyCount[index] = count;
            index++;
        }
    }
}
