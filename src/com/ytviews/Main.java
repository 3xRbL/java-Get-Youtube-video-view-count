package com.ytviews;

import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        String videoId = "https://www.youtube.com/watch?v=oHg5SJYRHA0";

        if(args.length > 0) videoId = args[0];

        try {
            System.out.println(GetViewCount(videoId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long GetViewCount(String videoId) throws Exception{
        URL site = new URL(videoId);
        BufferedReader read = new BufferedReader(new InputStreamReader(site.openStream()));

        String line;
        while ((line = read.readLine()) != null){
            if(line.contains("<meta itemprop=\"interactionCount\"")) break;
        }

        assert line != null;
        String[] answer = line.split("\"");

        return Long.parseLong(answer[answer.length - 2]);
    }
}
