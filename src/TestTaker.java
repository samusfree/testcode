import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public class TestTaker {

    public static String winners( String[] participantsList ) {

        double [] average = new double[participantsList.length];
        java.util.Map<String, Double> averages = new java.util.LinkedHashMap<>();
        for(int i = 0; i< participantsList.length; i++) {
            String participant = participantsList[i];
            String[] words = participant.trim().split("\\W+");
            int sumOfScores = 0;
            int numberOfScores = 0;
            StringBuilder participantName = new StringBuilder();
            for(String word: words) {
                try{
                    sumOfScores += Integer.parseInt(word);
                    numberOfScores++;
                } catch (NumberFormatException ex) {
                    if(!participantName.toString().isEmpty()) {
                        participantName.append(" ");
                    }
                    participantName.append(word);
                }
            }
            if(numberOfScores != 0) {
                averages.put(participantName.toString(),sumOfScores*1.0/numberOfScores);
            }
        }
        java.util.Map<String, Double> sortedAverages = averages.entrySet().stream()
                .sorted(java.util.Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(java.util.stream.Collectors.toMap (java.util.Map.Entry::getKey, java.util.Map.Entry::getValue, (x, y) -> y, java.util.LinkedHashMap::new));


        Iterator<Map.Entry<String, Double>> it = sortedAverages.entrySet().iterator();
        int i = 0;
        String[] winners = {"", "", ""};

        while(it.hasNext() && i < 3) {
            Map.Entry<String, Double> entry = it.next();
            winners[i] = entry.getKey();
            Double previousScore = (Double)entry.getValue();
            i++;
        }

        return "In 1st place:" + winners[0] + ";In 2nd place:" + winners[1] + ";In 3rd place:" + winners[2] + ";";
    }
}