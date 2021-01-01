package coding.easy;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        long  birdTypeCountMax = 0L;
        int birdType = -1;

        for(int i =1; i <=5; i++)
        {
            final int finalI = i;
            long birdTypeCount = arr.stream().filter( x -> x == finalI).count();
            if(birdTypeCount > birdTypeCountMax)
            {
                birdType = i;
                birdTypeCountMax = birdTypeCount;
            }
        }

        return birdType;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
