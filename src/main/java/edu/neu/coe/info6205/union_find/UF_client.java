package edu.neu.coe.info6205.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class UF_client {
    public static void main(String[] args) {


        int[] no_of_sites = {100, 200, 500, 1000, 2000, 4000, 8000, 16000, 32000, 48000, 64000, 128000, 256000, 384000, 512000, 768000, 1024000};
        for ( int no_Temp : no_of_sites ) {
            int sites = no_Temp;
            int counter = 0;
            int sum = 0;
            while(counter < 50) {
                int count = count(sites);
                System.out.print("RUN" + ( counter + 1 ) + ": " + count + ", ");
                if(counter % 5 == 4 ){
                    System.out.println();
                }

                counter++;
                sum += count;
            }
            System.out.println();
            System.out.println("Avg connections generated for " + sites + " sites: " + ((float) sum / 50));
            System.out.println();

        }

    }

    public static int count(int sites) {
        Random r = new Random();
        int connection = 0;
        UF h = new UF_HWQUPC(sites, true);
        while (h.components() > 1) {
            int p = r.nextInt(sites);
            int q = r.nextInt(sites);
            if(!h.isConnected(p, q)) {
                h.union(p, q);
            }
            connection++;
        }

        return connection;
    }
}
