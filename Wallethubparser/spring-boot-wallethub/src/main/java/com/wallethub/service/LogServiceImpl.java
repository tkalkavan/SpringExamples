package com.wallethub.service;

import com.wallethub.model.LogComments;
import com.wallethub.model.LogParams;
import com.wallethub.repository.LogCommentsRepository;
import com.wallethub.repository.LogParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogParamsRepository logParamsRepository;

    @Autowired
    private LogCommentsRepository logCommentsRepository;



    //Read from log file and parse it,return list.
    public List<LogParams> readFromLogFile(String file) throws IOException, ParseException {

        List<LogParams> logParamList = new ArrayList<>();

        ///startDate,ip,method,response,usearagent
        logParamList = Files.lines(Paths.get(System.getProperty("user.dir") + "\\" + file))
                .map(line -> line.split("\\s*\\|\\s*"))
                .map(array -> new LogParams(array[0], array[1], array[2], array[3], array[4]))
                .collect(Collectors.toList());

        System.out.println("List size "+logParamList.size());
        return logParamList;

    }

    //
    @Override
    public List<LogParams> analyzeLogParams(String startDate, String endDate, String threshold) {

        List<LogParams> logParamList = logParamsRepository.analyzeLogParams(startDate, endDate, threshold);

        System.out.println("Found ip's: has "
                +threshold
                +" or more than requests between"
                +startDate
                +" and "
                +endDate);

        for (LogParams model : logParamList) {
            //Print ip that fits for search criteria
            System.out.println(model.getLogip());

        }

        return logParamList;
    }

    public void saveAllLogParams(List<LogParams> logs) {

        //Saves all logs to database
        for (LogParams log : logs) {

            logParamsRepository.save(log);
        }

}
    //Saves all log comments to databse
    public void saveAllLogComments(List<LogParams> analyzedList, HashMap<Object, Object> searchCriteria) {

        List<LogComments> commentLogs = new ArrayList<>();

        analyzedList.forEach(logParams -> {
            LogComments c = new LogComments();
            c.setLogip(logParams.getLogip());
            c.setLogComment(logParams.getLogip()
                    + " has "
                    + searchCriteria.get("threshold") +
                    " or more than requests between "
                    + searchCriteria.get("startDate")
                    + " and "
                    +searchCriteria.get("endDate"));

            commentLogs.add(c);
        });

        //Saves each log and comment to database
        for(LogComments logParam:commentLogs){

            logCommentsRepository.save(logParam);
        }

    }

}



  

