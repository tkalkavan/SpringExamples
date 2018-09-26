package com.wallethub.service;


import com.wallethub.model.LogParams;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;


public interface LogService {


    List<LogParams> analyzeLogParams(String startDate, String endDate, String threshold);

    List<LogParams> readFromLogFile(String file) throws IOException, ParseException;

    void saveAllLogParams(List<LogParams> logs);

    void saveAllLogComments(List<LogParams> analyzedList, HashMap<Object, Object> searchCriteria);

}
